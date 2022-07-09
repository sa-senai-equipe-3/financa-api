package br.com.senai.financaapi.view.table;

import javax.swing.table.AbstractTableModel;

import antlr.collections.List;

public class ListagemTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int QTDE_COLUNAS = 2;

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
