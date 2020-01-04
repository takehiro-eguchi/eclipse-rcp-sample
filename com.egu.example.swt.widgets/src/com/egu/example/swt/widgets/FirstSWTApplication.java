package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
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
		Label label = new Label(shell, SWT.BORDER);
		label.setText("This is a label.");
		label.setToolTipText("This is a tooltip of this label.");

		// テキストの追加
		Text text = new Text(shell, SWT.NONE);
		text.setText("This is the text in the text widget.");
		// 背景色の設定
		Color backColor = display.getSystemColor(SWT.COLOR_BLACK);
		text.setBackground(backColor);
		// 表面色の設定
		Color foreColor = display.getSystemColor(SWT.COLOR_WHITE);
		text.setForeground(foreColor);

		// レイアウト上好ましいサイズに調整する
		label.pack();
		text.pack();

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

}
