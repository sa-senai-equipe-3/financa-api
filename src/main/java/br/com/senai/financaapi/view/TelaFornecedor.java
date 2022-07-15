package br.com.senai.financaapi.view;

import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.financaapi.controller.FornecedorController;
import br.com.senai.financaapi.entity.Fornecedor;
import br.com.senai.financaapi.view.table.ListagemTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class TelaFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroEdt;
	private TableColumnModel cm;

	@Autowired
	private FornecedorController fornecedorController;

	private void atualizarTableListagem(JTable tabela) {
		List<Fornecedor> fornecedores = fornecedorController.listarPor(filtroEdt.getText());
		ListagemTableModel modelo = new ListagemTableModel(fornecedores);
		tabela.setModel(modelo);
		cm = tabela.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(352);
		tabela.updateUI();
	}

	/**
	 * Create the frame.
	 */
	public TelaFornecedor() {
		setTitle("Fornecedor (LISTAGEM) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTable tabela = new JTable();
		tabela.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabela);

		JButton adicionarBtn = new JButton("Adicionar");

		JButton listarBtn = new JButton("Listar");
		listarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTableListagem(tabela);
			}
		});

		JLabel filtroLbl = new JLabel("Filtro");

		filtroEdt = new JTextField();
		filtroEdt.setColumns(10);

		JButton removerBtn = new JButton("Remover");

		JButton editarBtn = new JButton("Editar");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(filtroEdt, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(286, Short.MAX_VALUE)
						.addComponent(listarBtn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(198)
						.addComponent(editarBtn, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(removerBtn))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(filtroLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(adicionarBtn).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(adicionarBtn)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(filtroLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(filtroEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(listarBtn).addGap(33)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(removerBtn).addComponent(editarBtn))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
