package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * {@link Table}を用いたサンプルです。
 * https://www.vogella.com/tutorials/SWT/article.html#table
 * @param args
 */
public class TableExample {

	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());

		// テーブルの作成
		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true); // 線表示あり
		table.setHeaderVisible(true); // ヘッダー表示あり
		GridData tableGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableGridData.heightHint = 200;
		table.setLayoutData(tableGridData);

		// テーブルヘッダの作成
		String[] headers = { "First Name", "Last Name", "Age" };
		for (int i = 0; i < headers.length; i++) {
			// カラム作成
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(headers[i]);
			table.getColumn(i).pack();
		}

		// テーブルレコードの作成
		for (int i = 0; i <= 50; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, "Person " + i);
			item.setText(1, "LastName " + i);
			item.setText(2, String.valueOf(i));
		}

		// カラムのリサイズ
		for (int i = 0; i < headers.length; i++) {
			table.getColumn(i).pack();
		}

		// ウィンドウのリサイズ
		shell.pack();

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}