package com.egu.example.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * {@link GridLayout}を利用したサンプルです。
 * @author t-eguchi
 *
 */
public class GridLayoutSWT {

	public static void main(String[] args) {
		// ディスプレイの作成
		Display display = new Display();
		Shell shell = new Shell(display);

		// 2つのカラムを利用するが、ひとしいサイズにはしない
		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		// ラベルとボタンをレイアウトによらない配置を行う。
		Label label1 = new Label(shell, SWT.NONE);
		label1.setText("A label");
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Press Me");

		// 2列1行でラベルを作成する
		Label label2 = new Label(shell, SWT.BORDER);
		label2.setText("This is a label");
		GridData label2GridData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
		label2.setLayoutData(label2GridData);

		// セパレータとして2列1行のラベルを作成する
		Label label3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData label3GridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		label3GridData.horizontalSpan = 2;
		label3.setLayoutData(label3GridData);

		// 2列1行でボタンを作成する
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("New Button");
		GridData button2GridData = new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1);
		button2.setLayoutData(button2GridData);

		// 2列1行のスピナー(0 - 1000)を作成する
		Spinner spinner = new Spinner(shell, SWT.READ_ONLY);
		spinner.setMinimum(0);
		spinner.setMaximum(1000);
		spinner.setSelection(500);
		spinner.setIncrement(1);
		spinner.setPageIncrement(100);
		GridData spinnerGridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		spinnerGridData.widthHint = SWT.DEFAULT;
		spinnerGridData.heightHint = SWT.DEFAULT;
		spinnerGridData.horizontalSpan = 2;
		spinner.setLayoutData(spinnerGridData);

		// 子コンテナを2列1行で作成する
		Composite composite = new Composite(shell, SWT.BORDER);
		GridData compositeGridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		compositeGridData.horizontalSpan = 2;
		composite.setLayoutData(compositeGridData);
		composite.setLayout(new GridLayout(1, false));	// 子コンテナは1列のレイアウトを適用

		// 子コンテナにテキストを追加
		Text txtTest = new Text(composite, SWT.NONE);
		txtTest.setText("Testing");
		GridData txtGridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		txtTest.setLayoutData(txtGridData);

		// 子コンテナにもう一つテキストを追加
		Text txtMoreTests = new Text(composite, SWT.NONE);
		txtMoreTests.setText("Another test");

		// グループを作成
		Group group = new Group(shell, SWT.NONE);
		group.setText("This is my group");
		GridData groupGridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		groupGridData.horizontalSpan = 2;
		group.setLayoutData(groupGridData);
		group.setLayout(new RowLayout(SWT.VERTICAL));

		// グループにテキストを追加
		Text txtAnotherTest = new Text(group, SWT.NONE);
		txtAnotherTest.setText("Another test");

		// リサイズ
		shell.pack();

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}