package com.egu.example.nattable.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.egu.example.nattable.entity.Person;
import com.egu.example.nattable.service.PersonService;

/**
 * {@link NatTable} を利用したサンプルパートです。
 * https://www.vogella.com/tutorials/NatTable/article.html#exercise_nattable_data_application_model
 * @author t-eguchi
 *
 */
public class NatTableDataExamplePart {

	/** サービス */
	private final PersonService personService = new PersonService();

	@PostConstruct
	public void postConstruct(Composite parent) {
		// レイアウトの設定
		parent.setLayout(new GridLayout());

		// カラム情報提供者の作成
		IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<>(
				"firstName", "lastName", "gender", "married", "birthday");

		// データ提供者の作成
		IDataProvider bodyDataProvider = new ListDataProvider<Person>(
				personService.getPersons(10), columnPropertyAccessor);

		// データレイヤーの作成
		DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);

		// 様々なスタイルのビットを使用して、小さなテーブルの非アクティブなスクロールバーのレンダリングを回避します
		// スクロールバーの有効化/無効化および表示は、ViewportLayerによって処理されます。
		// ViewportLayerがない場合、スクロールバーは常にNatTableのデフォルトスタイルビットで表示されます。
		NatTable natTable = new NatTable(
				parent,
				SWT.NO_REDRAW_RESIZE | SWT.DOUBLE_BUFFERED | SWT.BORDER,
				bodyDataLayer);

		// NATTableにグリッドデータを適用
		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
	}
}
