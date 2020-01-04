package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * 日付関連のウィジェットのサンプルです。
 * @author t-eguchi
 *
 */
public class DateTimeExample {

	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = new Display();
		Shell shell = new Shell(display);
		Layout layout = new RowLayout();
		shell.setLayout(layout);

		// 1列の子コンテナを追加
		Composite parent = new Composite(shell, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);

		// カレンダーを追加
		@SuppressWarnings("unused")
		DateTime calendar = new DateTime(parent, SWT.CALENDAR);

		// 日付を追加
		@SuppressWarnings("unused")
		DateTime date = new DateTime(parent, SWT.DATE);

		// 時刻を追加
		@SuppressWarnings("unused")
		DateTime time = new DateTime(parent, SWT.TIME);

		// カレンダー選択日付を追加
		@SuppressWarnings("unused")
		DateTime datePicker = new DateTime(parent, SWT.DATE | SWT.DROP_DOWN);

		// リサイズ
		shell.pack();

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}