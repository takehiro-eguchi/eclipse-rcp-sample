package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * {@link KeyEvent} を利用したサンプルです。
 * https://www.vogella.com/tutorials/SWT/article.html#keybindings-for-swt-widgets
 * @author t-eguchi
 *
 */
public class SWTKeyEventExample {
	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("KeyListener Example");
		shell.setLayout(new GridLayout());

		// ボタンの追加
		Button button = new Button(shell, SWT.CENTER);
		button.setText("Press (optionally) meta keys and another key");
		KeyListener keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String string = "";

				// マスクキーも押下した場合は、追加
				if ((e.stateMask & SWT.ALT) != 0)
					string += "ALT ";
				if ((e.stateMask & SWT.CTRL) != 0)
					string += "CTRL ";
				if ((e.stateMask & SWT.SHIFT) != 0)
					string += "SHIFT ";

				// バックスペース
				if (e.keyCode == SWT.BS) {
					string += "BACKSPACE ";
				}

				// エスケープ
				if (e.keyCode == SWT.ESC) {
					string += "ESCAPE ";
				}

				// 押下した文字の追加
				if ((e.keyCode >= 97 && e.keyCode <= 122) || (e.keyCode >= 48 && e.keyCode <= 57)) {
					string += " " + e.character + " - keyCode = " + e.keyCode;
				}

				// 文字の表示
				if (!string.equals("")) {
					System.out.println(string);
				}
			}
		};
		button.addKeyListener(keyListener);

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}