package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * グローバルキーリスナーの例です。
 * https://www.vogella.com/tutorials/SWT/article.html#define-a-global-keylistener-for-your-display
 * @author t-eguchi
 *
 */
public class GlobalKeyListenerExample {

	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = new Display();
		Shell shell = new Shell(display);

		// ディスプレイフィルタにキー押下イベントを適用する
		display.addFilter(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				char c = event.character;
				System.out.println(c);
			}
		});

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}