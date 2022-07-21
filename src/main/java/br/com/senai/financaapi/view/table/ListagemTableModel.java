package br.com.senai.financaapi.view.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.senai.financaapi.entity.Fornecedor;

public class ListagemTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int QTDE_COLUNAS = 2;
	private List<Fornecedor> fornecedores;

	public ListagemTableModel(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public int getRowCount() {
		return fornecedores.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}

	public String getColumnName(int column) {

		if (column == 0) {
			return "ID";
		}

		else if (column == 1) {
			return "Nome Fantasia";
		}

		throw new IllegalArgumentException("Indice inválido");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (columnIndex == 0) {
			return this.fornecedores.get(columnIndex).getId();
		}

		else if (columnIndex == 1) {
			return this.fornecedores.get(columnIndex).getNomeFantasia();
		}

		throw new IllegalArgumentException("Índice inválido");
	}

}
