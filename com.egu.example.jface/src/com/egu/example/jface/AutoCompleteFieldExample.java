package com.egu.example.jface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.jface.util.SWTUtil;

/**
 * {@link Combo} の自動補完を行うサンプルです。
 * https://www.vogella.com/tutorials/EclipseJFace/article.html#using-field-assists-together-with-combo-boxes
 * @author t-eguchi
 *
 */
public class AutoCompleteFieldExample {

	/** ディレクトリ */
	private static Path lastDir;

	public static void main(String[] args) {
		// TODO 実装中

		// ウィンドウを生成
		Display display = new Display();
		Shell shell = new Shell(display);
		setUpLayout(shell);

		// コンボボックスの生成
		Combo combo = new Combo(shell, SWT.NONE);
		// 自動補完フィールドの設定
		AutoCompleteField autoCompleteField = new AutoCompleteField(combo, new ComboContentAdapter());
		// コンボボックスの変更をハンドリング
		combo.addModifyListener(e -> {
			Path dir = getPathWithoutFileName(combo.getText());
			if (dir == null || dir.equals(lastDir) || !isDirectory(dir)) {
				return;
			}
			lastDir = dir;
			try (Stream<Path> paths = Files.list(dir)) {
				List<String> directories = filterPaths(paths);
				autoCompleteField.setProposals(directories.toArray(new String[directories.size()]));
			} catch (IOException ex) {
				// ignore
			}
		});

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}

	/** レイアウトを設定する */
	private static void setUpLayout(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		parent.setLayout(gridLayout);
	}

	/** ファイル名以外のパスを取得 */
	private static Path getPathWithoutFileName(String inputPath) {
		int lastIndex = inputPath.lastIndexOf(File.separatorChar);
		if (separatorNotFound(lastIndex)) {
			return null;
		} else if (endsWithSeparator(inputPath, lastIndex)) {
			return getPath(inputPath);
		} else {
			return getPath(removeFileName(inputPath, lastIndex));
		}
	}

	/** 区切り文字の存在を確認 */
	private static boolean separatorNotFound(int lastIndex) {
		return lastIndex < 0;
	}

	/** 区切り文字で終了しているかの確認 */
	private static boolean endsWithSeparator(String inputPath, int lastIndex) {
		return lastIndex == inputPath.length();
	}

	/** ファイル名を除去する */
	private static String removeFileName(String text, int lastIndex) {
		if (lastIndex == 0) {
			return File.separator;
		} else {
			return text.substring(0, lastIndex);
		}
	}

	/** パスを取得 */
	private static Path getPath(String text) {
		try {
			return Paths.get(text);
		} catch (InvalidPathException ex) {
			return null;
		}
	};

	/** ディレクトリかどうかの確認 */
	private static boolean isDirectory(Path dir) {
		try {
			return Files.isDirectory(dir);
		} catch (SecurityException ex) {
			return false;
		}
	}

    private static List<String> filterPaths(Stream<Path> paths) {
		        return paths.filter(path -> {
		            String[] directoriesInPath = path.toString().split(File.separator);
		            String fileName = directoriesInPath[directoriesInPath.length - 1];
		            String lastDirectory = directoriesInPath[directoriesInPath.length - 2];
		            return !lastDirectory.equals(".") && !fileName.startsWith(".") && Files.isDirectory(path);
		        })
		        		.map(Path::toString).collect(Collectors.toList());
		    }

}
