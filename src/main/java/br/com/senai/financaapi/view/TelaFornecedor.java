package br.com.senai.financaapi.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class TelaFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroEdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

		JButton adicionarBtn = new JButton("Adicionar");

		JButton listarBtn = new JButton("Listar");

		JLabel filtroLbl = new JLabel("Filtro");

		filtroEdt = new JTextField();
		filtroEdt.setColumns(10);

		JButton removerBtn = new JButton("Remover");

		JButton editarBtn = new JButton("Editar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(filtroLbl, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addComponent(filtroEdt, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addContainerGap().addComponent(listarBtn,
												GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(adicionarBtn))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addGap(198)
												.addComponent(editarBtn, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(removerBtn)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(adicionarBtn).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(filtroLbl).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(filtroEdt, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(listarBtn)
												.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(removerBtn).addComponent(editarBtn))
												.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
