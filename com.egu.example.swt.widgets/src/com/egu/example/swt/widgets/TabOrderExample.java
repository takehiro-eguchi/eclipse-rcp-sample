package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * タブ順序を設定するためのサンプルです。
 * @author t-eguchi
 *
 */
public class TabOrderExample {

	public static void main(String[] args) {
		// ディスプレイの生成
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        Layout layout = new RowLayout();
        shell.setLayout(layout);

        // ボタンの作成
        Button b1 = new Button(shell, SWT.PUSH);
        b1.setText("Button1");
        Button b2 = new Button(shell, SWT.PUSH);
        b2.setText("Button2");
        Button b3 = new Button(shell, SWT.PUSH);
        b3.setText("Button3");

        // タブ順序を設定する
        Control[] controls = new Control[] { b2, b1, b3 };
        shell.setTabList(controls);

        // リサイズ
        shell.pack();

        // 開始
        SWTUtil.startMonitoringEvent(display, shell);
    }
}