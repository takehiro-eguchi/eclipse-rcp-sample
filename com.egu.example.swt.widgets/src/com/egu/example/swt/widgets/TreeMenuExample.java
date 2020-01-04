package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * {@link Tree} 及び {@link Menu} を利用したサンプルです。
 * https://www.vogella.com/tutorials/SWT/article.html#tree-and-menu
 * @param args
 */
public class TreeMenuExample {

	public static void main(String[] args) {
		// ウィンドウの作成
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		// ツリーの作成
		Tree tree = new Tree(shell, SWT.V_SCROLL);
		for (int i = 0; i < 5; i++) {
			// ツリーアイテムの追加
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(String.valueOf(i));
			for (int j = 0; j < 3; j++) {
				// ツリーサブアイテムの追加
				TreeItem subItem = new TreeItem(item, SWT.NONE);
				subItem.setText(String.valueOf(i) + " " + String.valueOf(j));
			}
		}
		tree.pack();

		// メニューの作成
		Menu menu = new Menu(tree);
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("Print Element");
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				// 選択されているツリーのテキストを表示
				TreeItem selectedTreeItem = tree.getSelection()[0];
				System.out.println(selectedTreeItem.getText());
			}
		});

		// ツリーにメニューを設定
		tree.setMenu(menu);

		// リサイズ
		shell.pack();

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}