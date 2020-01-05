package com.egu.example.nattable.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.egu.example.nattable.entity.Person;
import com.egu.example.nattable.service.PersonService;

/**
 * {@link NatTable} を利用してスクロール可能なテーブルを作成します。
 * https://www.vogella.com/tutorials/NatTable/article.html#exercise_nattable_layerstack
 * @author t-eguchi
 *
 */
public class NatTableLayerStackExamplePart {

	/** サービス */
	private final PersonService personService = new PersonService();

	@PostConstruct
	public void postConstruct(Composite parent) {
		// レイアウトの適用
		parent.setLayout(new GridLayout());

		// カラム提供者の生成
		IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<>(
				"firstName", "lastName", "gender", "married", "birthday");

		// データ提供者の生成
		IDataProvider bodyDataProvider = new ListDataProvider<Person>(
				personService.getPersons(50), columnPropertyAccessor);

		// データ提供レイヤーの生成
		DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);

		// 選択アクションを実行するためのレイヤーの生成
		SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);

		// 仮想の性質の追加やハンドリングを行うレイヤーの生成
		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

		// 選択アクションのデフォルトのUIバインディングは、GridRegion.BODY Region ラベルにバインドされます。
		// この演習ではグリッド構成がないため、選択を正しく機能させるために、
		// リージョンラベルを手動で設定する必要があります。
		viewportLayer.setRegionName(GridRegion.BODY);

		// テーブルの生成
		NatTable natTable = new NatTable(parent, viewportLayer);

		// グリッドデータのテーブルへの適用
		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
	}
}
