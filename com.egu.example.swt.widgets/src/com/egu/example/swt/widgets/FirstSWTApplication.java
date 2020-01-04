package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 初回のSWTアプリケーションです。
 * @author t-eguchi
 *
 */
public class FirstSWTApplication {

	public static void main(String[] args) {
		// ディスプレイの生成
		Display display = new Display();

		// シェルの生成
		Shell shell = new Shell(display);

		// レイアウトの設定
		Layout layout = new FillLayout();
		shell.setLayout(layout);

		// ラベルの追加
		Label label = addLabel(shell);

		// テキストの追加
		Text text = addText(shell, display);

		// ボタンの追加
		Button button = addButton(shell, display);

		// レイアウト上好ましいサイズに調整する
		label.pack();
		text.pack();
		button.pack();

		// 画面を開く
		shell.open();
		while (!shell.isDisposed()) {
			// イベントが発生しない場合は、発生する迄スリープする
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		// リソースの破棄
		display.dispose();
	}

	/** テキストを追加します */
	private static Text addText(Shell shell, Display display) {
		Text text = new Text(shell, SWT.NONE);
		text.setText("This is the text in the text widget.");

		// 背景色の設定
		Color backColor = display.getSystemColor(SWT.COLOR_BLACK);
		text.setBackground(backColor);

		// 表面色の設定
		Color foreColor = display.getSystemColor(SWT.COLOR_WHITE);
		text.setForeground(foreColor);

		return text;
	}

	/** ラベルを追加します。 */
	private static Label addLabel(Shell shell) {
		Label label = new Label(shell, SWT.BORDER);

		// テキストおよびツールチップの設定
		label.setText("This is a label.");
		label.setToolTipText("This is a tooltip of this label.");

		// フォントの設定
		Display display = label.getDisplay();
		FontData fontData = new FontData("Mono", 10, SWT.ITALIC);
		Font font = new Font(display, fontData);
		label.setFont(font);

		// フォントを変更する場合は、コントロールよりFontDataを取得し、
		// それから新しいFontオブジェクトを作成する
		fontData = label.getFont().getFontData()[0];
		fontData.setName("Meiryo UI");
		fontData.setStyle(SWT.BOLD);
		font = new Font(display, fontData);
		label.setFont(font);

		// !! Font は自動的に破棄されないため注意すること !!

		return label;
	}

	/** ボタンを追加します */
	private static Button addButton(Shell shell, Display display) {
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Press me");

		// イベントの追加
		SelectionListener listener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Called!!");
			}
		};
		button.addSelectionListener(listener);

		return button;
	}
}
