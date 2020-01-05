package com.egu.example.jface;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * {@link LocalResourceManager} を利用したサンプルです。
 * https://www.vogella.com/tutorials/EclipseJFace/article.html#jface_localresoucemanager
 * @author t-eguchi
 *
 */
public class LocalResourceManagerExample {

	public static void main(String[] args) {
		// ウィンドウの生成
		Display display = new Display();
		Shell composite = new Shell(display);

		// リソースマネージャの生成
		ResourceManager resManager = new LocalResourceManager(
				JFaceResources.getResources(), composite);

		// リソースの作成
		Color color = resManager.createColor(new RGB(200, 100, 0));
		Font font = resManager.createFont(FontDescriptor.createFrom("Arial", 10, SWT.BOLD));
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(
				LocalResourceManagerExample.class, "hoge.png");
		Image image = resManager.createImage(imageDescriptor);
	}

}
