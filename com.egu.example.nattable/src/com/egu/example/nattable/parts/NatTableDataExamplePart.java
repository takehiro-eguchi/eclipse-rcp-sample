package com.egu.example.nattable.parts;

import org.eclipse.nebula.widgets.nattable.NatTable;

/**
 * {@link NatTable} を利用したサンプルパートです。
 * https://www.vogella.com/tutorials/NatTable/article.html#exercise_nattable_data_application_model
 * @author t-eguchi
 *
 */
public class NatTableDataExamplePart {

//	@PostConstruct
//	public void postConstruct(Composite parent, PersonService personService) {
//		// レイアウトの設定
//		parent.setLayout(new GridLayout());
//
//		// property names of the Person class
//		String[] propertyNames = { "firstName", "lastName", "gender", "married", "birthday" };
//
//		// create the data provider
//		IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<>(
//				propertyNames);
//		IDataProvider bodyDataProvider = new ListDataProvider<Person>(
//				personService.getPersons(10), columnPropertyAccessor);
//
//		final DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
//
//		// use different style bits to avoid rendering of inactive scrollbars for small table
//		// Note: The enabling/disabling and showing of the scrollbars is handled by the
//		//       ViewportLayer. Without the ViewportLayer the scrollbars will always be
//		//       visible with the default style bits of NatTable.
//		final NatTable natTable = new NatTable(
//				parent,
//				SWT.NO_REDRAW_RESIZE | SWT.DOUBLE_BUFFERED | SWT.BORDER,
//				bodyDataLayer);
//
//		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
//	}
}
