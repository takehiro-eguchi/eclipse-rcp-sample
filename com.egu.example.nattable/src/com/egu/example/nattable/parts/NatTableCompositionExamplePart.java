package com.egu.example.nattable.parts;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.egu.example.nattable.entity.Person;
import com.egu.example.nattable.service.PersonService;

/**
 * NatTableの列ヘッダーと本文を使用してレイヤー構成をセットアップする方法を示します。
 * https://www.vogella.com/tutorials/NatTable/article.html#exercise_nattable_composition
 * @author t-eguchi
 *
 */
public class NatTableCompositionExamplePart {

	/** サービス */
	private final PersonService personService = new PersonService();

	/** プロパティ名一覧 */
	private static final String[] PROPERTY_NAMES = {
			"firstName", "lastName", "gender", "married", "birthday" };

	@PostConstruct
	public void postConstruct(Composite parent) {
		// レイアウトの設定
		parent.setLayout(new GridLayout());

		// カラム提供者を生成
		IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<>(
				PROPERTY_NAMES);

		// データ提供者を生成
		IDataProvider bodyDataProvider = new ListDataProvider<Person>(
				personService.getPersons(50), columnPropertyAccessor);

		// 本体部分のレイヤーを生成
		DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
		SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);
		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

		// カラムヘッダ提供者を生成
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("firstName", "Firstname");
		propertyToLabelMap.put("lastName", "Lastname");
		propertyToLabelMap.put("gender", "Gender");
		propertyToLabelMap.put("married", "Married");
		propertyToLabelMap.put("birthday", "Birthday");

		// ヘッダレイヤーを生成
		IDataProvider headerDataProvider = new DefaultColumnHeaderDataProvider(PROPERTY_NAMES, propertyToLabelMap);
		DataLayer headerDataLayer = new DataLayer(headerDataProvider);
		ILayer columnHeaderLayer = new ColumnHeaderLayer(headerDataLayer, viewportLayer, selectionLayer);

		// コンポジションの作成
		// リージョンラベルを設定して、デフォルトの構成が機能するようにします。
		CompositeLayer compositeLayer = new CompositeLayer(1, 2);
		compositeLayer.setChildLayer(GridRegion.COLUMN_HEADER, columnHeaderLayer, 0, 0);
		compositeLayer.setChildLayer(GridRegion.BODY, viewportLayer, 0, 1);

		// テーブルの生成
		NatTable natTable = new NatTable(parent, compositeLayer);

		// グリッドをテーブルに適用
		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
	}
}
