package com.egu.example.swt.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;

import com.egu.example.swt.widgets.util.SWTUtil;

/**
 * イメージを利用したサンプルです。
 * @author t-eguchi
 *
 */
public class ImageExample {

    public static void main(String[] args) {
    	// ウィンドウの作成
        Display display = new Display();
        Shell shell = new Shell(display);
        Layout layout = new RowLayout();
        shell.setLayout(layout);
        shell.setText("Photo Application");

        // 5列のレイアウトを持つ子コンテナを作成
        Composite parent = new Composite(shell, SWT.FILL);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 5;
        parent.setLayout(gridLayout);

        // アイコン一覧を作成
        List<Image> imageList = new ArrayList<>();
        imageList.add(display.getSystemImage(SWT.ICON_WARNING));
        imageList.add(display.getSystemImage(SWT.ICON_WORKING));
        imageList.add(display.getSystemImage(SWT.ICON_QUESTION));
        imageList.add(display.getSystemImage(SWT.ICON_INFORMATION));
        imageList.add(display.getSystemImage(SWT.ICON_ERROR));

        // アイコンをラベルを使って追加
        imageList.forEach(image -> {
        	Label label = new Label(parent, SWT.NONE);
            label.setImage(image);
        });

        // リサイズ
        shell.pack();

        // 開始
        SWTUtil.startMonitoringEvent(display, shell);

        // イメージの破棄
        imageList.forEach(Image::dispose);
    }
}