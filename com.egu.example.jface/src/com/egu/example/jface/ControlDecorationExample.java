package com.egu.example.jface;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.egu.example.jface.util.SWTUtil;

/**
 * {@link ControlDecoration} を利用したサンプルです。
 * https://www.vogella.com/tutorials/EclipseJFace/article.html#user-input-help-with-field-assistance
 * @author t-eguchi
 *
 */
public class ControlDecorationExample {

	public static void main(String[] args) {
		// ウィンドウの生成
		Display display = new Display();
		Shell shell = new Shell(display);
		Layout layout = new GridLayout();
		shell.setLayout(layout);

		// ラベルの作成
		Label label = new Label(shell, SWT.NONE);
		label.setText("Please enter a value:");
		GridData labelGridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		label.setLayoutData(labelGridData);

		// テキストの作成
		Text text = new Text(shell, SWT.BORDER);
		GridData textGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textGridData.horizontalIndent = 8;
		text.setLayoutData(textGridData);

		// テキストにデコレーションを設定
		ControlDecoration deco = new ControlDecoration(text, SWT.TOP | SWT.LEFT);
		// デコレーションに説明文を設定
		deco.setDescriptionText("Use CTRL + SPACE to see possible values");
		// デコレーションにイメージを設定
		// 入力テキストに「情報」イメージを設定
		Image image = FieldDecorationRegistry.getDefault().getFieldDecoration(
				FieldDecorationRegistry.DEC_INFORMATION).getImage();
		deco.setImage(image);
		// 常にデコレーションを表示
		deco.setShowOnlyOnFocus(false);

		// テキストに変更が入った際にデコレーション表示を制御する
		text.addModifyListener(e -> {
		    Text source = (Text) e.getSource();
		    if (!source.getText().isEmpty()) {
		        deco.hide();
		    } else {
		        deco.show();
		    }
		});

		// 入力補完の設定
		try {
			// 入力補完用キー
			KeyStroke keyStroke = KeyStroke.getInstance("Ctrl+Space");

			// 自動補完有効化文字
			char[] autoActivationCharacters = new char[] { '.', ' ' };

			// テキスト用アダプタの生成
			IControlContentAdapter contentAdapter = new TextContentAdapter();

			// 補完内容を生成
			IContentProposalProvider contentProposalProvider = new SimpleContentProposalProvider(
					"ProposalOne", "ProposalTwo", "ProposalThree");

			// 補完の適用
			new ContentProposalAdapter(
		    		text, contentAdapter, contentProposalProvider,
		    		keyStroke, autoActivationCharacters);

		} catch (ParseException e1) {
		    e1.printStackTrace();
		}

		// 開始
		SWTUtil.startMonitoringEvent(display, shell);
	}
}
