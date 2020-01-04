package com.egu.example.swt.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * 既存のレイアウトに新しい行を動的に作成する方法と、これらの行を削除する方法の例です。
 * @author t-eguchi
 *
 */
public class SWTDynamicLayoutChanges {

	public static void main(String[] args) {
		// ディスプレイの生成
		Display display = new Display();
		Shell shell = new Shell(display);

		// 色一覧の作成
		List<Color> colors = getColors(display);

		// グリッドレイアウトを適用
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;	// 幅マージンなし
		gridLayout.marginHeight = 0;	// 高さマージンなし
		gridLayout.verticalSpacing = 0;	// 横の余白なし
		gridLayout.horizontalSpacing = 0;	// 縦の余白なし
		shell.setLayout(gridLayout);

		// トップウィジェットの設定
		Composite top = new Composite(shell, SWT.NONE);
		GridData topGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		top.setLayoutData(topGridData);
		top.setBackground(display.getSystemColor(SWT.COLOR_GREEN));

		// レイヤーを3つ作成する
		createLayer(shell, top, colors);
		createLayer(shell, top, colors);
		createLayer(shell, top, colors);

		// 全体サイズの設定
		shell.setBounds(100, 100, 800, 600);

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}

	/** 色の一覧を作成します */
	private static List<Color> getColors(Display display) {
		List<Color> colors = new ArrayList<>();
		colors.add(display.getSystemColor(SWT.COLOR_RED));
		colors.add(display.getSystemColor(SWT.COLOR_GREEN));
		colors.add(display.getSystemColor(SWT.COLOR_YELLOW));
		colors.add(display.getSystemColor(SWT.COLOR_CYAN));
		colors.add(new Color(display, 122, 122, 122));
		colors.add(new Color(display, 255, 51, 227));
		colors.add(new Color(display, 27, 82, 255));
		colors.add(new Color(display, 240, 201, 27));
		colors.add(new Color(display, 188, 188, 188));
		colors.add(display.getSystemColor(SWT.COLOR_DARK_MAGENTA));
		return colors;
	}

	private static Composite createLayer(
			Composite parent, Composite top, List<Color> colors) {
		// レイヤーの作成
		Composite layer = new Composite(parent, SWT.NONE);
		Layout layout = new FillLayout();
		layer.setLayout(layout);

		// 色の数分アイコンを追加する
		for (int i = 0; i < colors.size(); i++) {
			// ラベルを追加
			Label label = new Label(layer, SWT.NONE);
			label.setText("I go \u26F7");
			Color color = colors.get(i);

			// マウスがクリックされた場合に確認ダイアログを表示し、
			//  topを該当する色に変更する
			MouseListener listener = new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					Shell shell = Display.getDefault().getActiveShell();
					MessageBox dialog = new MessageBox(
							shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
					dialog.setText("My info");
					dialog.setMessage("Do you really want to do this?");
					int result = dialog.open();
					if (result == SWT.OK) {
						top.setBackground(color);
					}
				}
			};
			label.addMouseListener(listener);
		}

		// 削除ボタンの追加
		Button removeButton = new Button(layer, SWT.PUSH);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// レイヤーの破棄
				layer.dispose();

				// 再レイアウト
				parent.requestLayout();
			}
		});

		// 追加ボタンの追加
		Button addButton = new Button(layer, SWT.PUSH);
		addButton.setText("Add");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// レイヤーの新規作成
				Composite composite = createLayer(parent, top, colors);

				// 上部へ配置
				composite.moveAbove(addButton.getParent());

				// 再レイアウト
				parent.requestLayout();
			}
		});

		// 上部に配置し、水平方向はパディングし、垂直方向はパディングしない
		GridData layerGridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		layer.setLayoutData(layerGridData);
		return layer;
	}
}