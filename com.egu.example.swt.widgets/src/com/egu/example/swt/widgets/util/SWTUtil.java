package com.egu.example.swt.widgets.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * SWTを扱う場合に利用するユーティリティクラスです。
 * @author t-eguchi
 *
 */
public class SWTUtil {

	/** デフォルトコンストラクタを隠蔽 */
	private SWTUtil() {}

	/**
	 * イベントの監視を開始します。
	 * @param display
	 * @param shell
	 */
	public static void startMonitoringEvent(Display display, Shell shell) {
		// オープン
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
