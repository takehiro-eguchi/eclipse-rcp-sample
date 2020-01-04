package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * {@link CTabFolder} を利用したサンプルです。
 * https://www.vogella.com/tutorials/SWT/article.html#ctabfolder
 * @author t-eguchi
 *
 */
public class CTabFolderExample {

	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());

		// CTabFolderの作成
		CTabFolder folder = new CTabFolder(shell, SWT.BOTTOM);
		// 2列1行のレイアウトを適用
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		folder.setLayoutData(data);
		// 選択されたタブの色を赤に設定
		folder.setSelectionForeground(display.getSystemColor(SWT.COLOR_RED));
		CTabItem cTabItem1 = new CTabItem(folder, SWT.NONE);
		cTabItem1.setText("Tab1");
		CTabItem cTabItem2 = new CTabItem(folder, SWT.NONE);
		cTabItem2.setText("Tab2");
		CTabItem cTabItem3 = new CTabItem(folder, SWT.NONE);
		cTabItem3.setText("Tab3");

		// タブにテキストを追加
		Text text = new Text(folder, SWT.BORDER);
		text.setText("Hello");
		cTabItem1.setControl(text);

		// リサイズ
		shell.pack();

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}