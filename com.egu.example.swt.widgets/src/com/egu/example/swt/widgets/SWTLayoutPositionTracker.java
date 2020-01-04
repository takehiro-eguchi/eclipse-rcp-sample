package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * ウィジェットのポジショニングを実現するオブジェクトです。
 * @author t-eguchi
 *
 */
public class SWTLayoutPositionTracker {

	public static void main(String[] args) {
		// ディスプレイの生成
		Display display = new Display();
		Shell shell = new Shell(display);

		// 座標の生成
		int x = 60;
		int y = 20;
		int width = 400;
		int height = 200;
		int toolbarSize = 30;

		// ラベルの作成
		Label label = new Label(shell, SWT.BORDER);
		label.setBounds(x, y, width, height);

        // 全体のサイズの設定
		shell.setBounds(200, 400, width + x * 2, height + y * 2 + toolbarSize);

		// マウスイベントの追加
		shell.addMouseMoveListener(e -> showSize(e, shell, label));
		label.addMouseMoveListener(e -> showSize(e, shell, label));

		// !! setBounds は位置とサイズの両方を設定している。
		//  setLocation と setSize でも定義することができる !!

		// シェルの開始し、イベントが発生しない場合はスリープ
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		// ディスプレイの破棄
		display.dispose();
	}

	/** ポジション情報を表示します */
	private static void showSize(MouseEvent e, Shell shell, Label label) {
		// ポジションの取得
		int x = e.x;
		int y = e.y;

		// 文字列の作成
		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder
			.append("Bounds for Label: ").append(label.getBounds()).append(System.lineSeparator())
			.append("Bounds for Shell: ").append(shell.getBounds()).append(System.lineSeparator())
			.append("Mouse pointer: (").append(x).append(", ").append(y).append(")");

		// ラベルへの反映
		String msg = msgBuilder.toString();
		label.setText(msg);
	}
}
