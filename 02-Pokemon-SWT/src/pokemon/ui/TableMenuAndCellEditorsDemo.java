package pokemon.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import pokemon.data.Pokemon;
import pokemon.data.Type;

/**
 * Class to demonstrate creation and usage of interaction elements for a table:
 * 1. Context-Menu 
 * 2. Drop Box based Editor 
 * 3. Text based Editor
 *
 */
public class TableMenuAndCellEditorsDemo {

	public static void main(String[] args) {
		// SWT setup
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		// setup the table instance
		Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		// create a context menu
		Menu contextMenu = new Menu(shell);
		table.setMenu(contextMenu);
		MenuItem miCreate = new MenuItem(contextMenu, SWT.None);
		miCreate.setText("Create Pokemon");
		// Listener for the action performed when menu item is selected
		miCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = e.getSource();
				if (o != null) {
					if (o instanceof MenuItem) {
						System.out.println(o.getClass().getSimpleName() + " '"
								+ ((MenuItem) o).getText() + "' has been selected");
					}
				}
				Pokemon p = new Pokemon("", Type.Fire);
				// create a new TableItem with the Pokemon data
				TableItem item = new TableItem(table, SWT.NONE); 
				// attach the Pokemon instance to the item
				item.setData(p);
				item.setText(0, p.getType().name());
				createCComboEditor(table, item, 0, p.getType());
			}
		});
		// Listener to show the Menu when a right click is performed in the
		// table
		table.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem[] selection = table.getSelection();
				if (selection.length != 0 && (event.button == 3)) {
					contextMenu.setVisible(true);
				}
			}
		});
		// create the table headers
		final String[] HEADS = { "Type", "Name" };
		for (String head : HEADS) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(head);
			// set a default width instead of packing for better visibility
			column.setWidth(100);
			// column.pack();
		}
		// create some table rows with Pokemons attached
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(new Pokemon("", Type.Fire));
		}
		// drop down box editor for Enum values
		TableItem[] items = table.getItems();
		for (int i = 0; i < items.length; i++) {
			createCComboEditor(table, items[i], 0, null);
		}

		// editor for the text table cell
		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		// and its listener for MouseDoubleClick events and text editor
		table.addListener(SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				// iterate through the tables row
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					// the tables columns index creating the text editor is the
					// 2nd column (=1) of table
					int columnIndex = 1;
					Rectangle rect = item.getBounds(columnIndex);
					if (rect.contains(pt)) {
						// create a text input box
						final Text text = new Text(table, SWT.NONE);
						// create a listener for the text input box
						Listener textListener = new Listener() {
							public void handleEvent(final Event e) {
								switch (e.type) {
								case SWT.FocusOut:
									// update the items text with the text from
									// the input
									item.setText(columnIndex, text.getText());
									// and update attached data element if it exist
									if (item.getData() != null) {
										if (item.getData() instanceof Pokemon)
										((Pokemon)item.getData()).setName(text.getText());
									}
									text.dispose();
									break;
								case SWT.Traverse:
									switch (e.detail) {
									case SWT.TRAVERSE_RETURN:
										item.setText(columnIndex, text.getText());
										// FALL THROUGH
									case SWT.TRAVERSE_ESCAPE:
										text.dispose();
										e.doit = false;
									}
									break;
								}
							}
						};
						// add the listener to the text input box for
						// deselection
						text.addListener(SWT.FocusOut, textListener);
						// and selection
						text.addListener(SWT.Traverse, textListener);
						editor.setEditor(text, item, columnIndex);
						text.setText(item.getText(columnIndex));
						text.selectAll();
						text.setFocus();
						return;
					}
					if (!visible && rect.intersects(clientArea)) {
						visible = true;
					}
					if (!visible)
						return;
					index++;
				}
			}
		});
		// show the UI
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * Creates a CCombo with an attached Editor for a TableItem in the specified
	 * columnIndex with selected Type as default
	 * 
	 * @param table
	 *            the Table to create the CCombo in
	 * @param item
	 *            the TableItem (row) to create the CCombo in
	 * @param columnIndex
	 *            the column index to create the CCombo in
	 * @param selected
	 *            the Type selected as default
	 */
	private static void createCComboEditor(Table table, TableItem item, int columnIndex, Type selected) {
		// editor for the drop down element
		final TableEditor ceditor = new TableEditor(table);
		// create a Drop Dowon box based on the contents of a enum
		CCombo combo = new CCombo(table, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(e);
				// get the selected Type
				Type t = Type.valueOf(combo.getText());
				// set the selected type to the pokemon instance attached
				if (item.getData() != null) {
					if(item.getData() instanceof Pokemon){
						((Pokemon) item.getData()).setType(t);
						// print changed pokemon
						System.out.println(item.getData());	
					}
				}
			}
		});
		String tname = "";
		for (Type t : Type.values()) {
			tname = t.name();
			combo.add(tname);
		}
		if (selected == null) {
			// set the last element as selected
			combo.setText(tname);
		} else {
			combo.setText(selected.name());
		}
		ceditor.grabHorizontal = true;
		// place the combo box in the actual row in the 1st column (=0) of
		// table
		ceditor.setEditor(combo, item, columnIndex);
	}

}
