package App.panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Checkbox;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.event.AncestorListener;

import org.w3c.dom.events.EventException;

import App.Aplicacao;
import App.Emprestimo;
import App.Livro;
import App.Usuario;

import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import javax.swing.DropMode;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JTextArea;

public class RetirarLivro extends JPanel {
	private JTextField tfNomeRetirada;
	private PanelUsuario painelUsuario;
	//private PanelLivro painelLivro;
	private JLabel lblErroNomeUsuario;
	private ArrayList<Livro> livrosDoUsuario = new ArrayList<Livro>();
	private ArrayList<Emprestimo> emprestimosCadastrados = new ArrayList<Emprestimo>();
	private JComboBox<String> comboBoxLivrosCadastrados = new JComboBox<String>();
	private JComboBox<String> comboBoxLivrosReservadosPeloUsuario = new JComboBox<String>();
	private JComboBox cmbDia;
	private JComboBox cmbMes;
	private JComboBox cmbAno;
	

	public ArrayList<Emprestimo> getEmprestimosCadastrados() {
		return emprestimosCadastrados;
	}
	public void setEmprestimosCadastrados(ArrayList<Emprestimo> emprestimosCadastrados) {
		this.emprestimosCadastrados = emprestimosCadastrados;
	}
	
	public JComboBox<String> getComboBoxLivrosReservadosPeloUsuario() {
		return comboBoxLivrosReservadosPeloUsuario;
	}
	public void setComboBoxLivrosReservadosPeloUsuario(JComboBox<String> comboBoxLivrosReservadosPeloUsuario) {
		this.comboBoxLivrosReservadosPeloUsuario = comboBoxLivrosReservadosPeloUsuario;
	}
	public JComboBox<String> getComboBoxLivrosCadastrados() {
		return comboBoxLivrosCadastrados;
	}
	public void adicionarItemJComboBox(String item) {
		this.comboBoxLivrosCadastrados.addItem(item); 
	}

	public void setComboBoxLivrosCadastrados(JComboBox<String> comboBoxLivrosCadastrados) {
		this.comboBoxLivrosCadastrados = comboBoxLivrosCadastrados;
	}

	/**
	 * Create the panel.
	 */
	public RetirarLivro() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(251,251,251));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeRetirada = new JLabel("Nome Completo:");
		lblNomeRetirada.setBounds(375, 115, 162, 23);
		lblNomeRetirada.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblNomeRetirada);
		
		JLabel lblTitle = new JLabel("Reservar Livro");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(444, 48, 310, 34);
		lblTitle.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		panel.add(lblTitle);
		
		JLabel lblNomeLivrosRetirada = new JLabel("T\u00EDtulo dos livros:");
		lblNomeLivrosRetirada.setBounds(375, 183, 209, 23);
		lblNomeLivrosRetirada.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblNomeLivrosRetirada);
		
		tfNomeRetirada = new JTextField();
		tfNomeRetirada.setBounds(375, 149, 310, 23);
		panel.add(tfNomeRetirada);
		tfNomeRetirada.setColumns(10);
		
		lblErroNomeUsuario = new JLabel("Usu\u00E1rio n\u00E3o cadastrado!");
		lblErroNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErroNomeUsuario.setForeground(new Color(251,251,251));
		lblErroNomeUsuario.setBounds(695, 149, 162, 23);
		panel.add(lblErroNomeUsuario);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblDia.setBounds(375, 344, 34, 23);
		panel.add(lblDia);
		
		cmbDia = new JComboBox();
		cmbDia.setToolTipText("");
		cmbDia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbDia.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbDia.setBounds(375, 372, 48, 22);
		panel.add(cmbDia);
		
		cmbMes = new JComboBox();
		cmbMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cmbMes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbMes.setBounds(438, 372, 48, 22);
		panel.add(cmbMes);
		
		JLabel lblMes = new JLabel("M\u00EAs");
		lblMes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblMes.setBounds(438, 344, 34, 23);
		panel.add(lblMes);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblAno.setBounds(496, 344, 34, 23);
		panel.add(lblAno);
		
		cmbAno = new JComboBox();
		cmbAno.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023"}));
		cmbAno.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbAno.setBounds(496, 372, 66, 22);
		panel.add(cmbAno);
		
		JLabel lblDataRetirada = new JLabel("Data Retirada:");
		lblDataRetirada.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblDataRetirada.setBounds(375, 319, 308, 23);
		panel.add(lblDataRetirada);
		
		comboBoxLivrosCadastrados = new JComboBox<String>();		
		comboBoxLivrosCadastrados.setBounds(375, 217, 310, 23);
		
		panel.add(comboBoxLivrosCadastrados);
		
		
		JButton btnAdicionarListaLivrosUsuario = new JButton("Adicionar a lista");
		btnAdicionarListaLivrosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxLivrosReservadosPeloUsuario.addItem((String) comboBoxLivrosCadastrados.getSelectedItem());
			}
		});
		btnAdicionarListaLivrosUsuario.setForeground(new Color(0, 0, 0));
		btnAdicionarListaLivrosUsuario.setBackground(new Color(0, 191, 255));
		btnAdicionarListaLivrosUsuario.setBounds(695, 217, 135, 23);
		panel.add(btnAdicionarListaLivrosUsuario);
		
		JLabel lblNewLabel = new JLabel("Livros reservados:");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds(375, 251, 310, 23);
		panel.add(lblNewLabel);
		
		comboBoxLivrosReservadosPeloUsuario = new JComboBox<String>();
		comboBoxLivrosReservadosPeloUsuario.setBounds(375, 285, 310, 23);
		panel.add(comboBoxLivrosReservadosPeloUsuario);
		
		JButton btnRemoverLivroLista = new JButton("Remover da lista");
		btnRemoverLivroLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxLivrosReservadosPeloUsuario.removeItem(comboBoxLivrosReservadosPeloUsuario.getSelectedItem());
			}
		});
		btnRemoverLivroLista.setBackground(new Color(240, 128, 128));
		btnRemoverLivroLista.setBounds(695, 285, 135, 23);
		panel.add(btnRemoverLivroLista);
		
		
		JButton btnCadastrarUsuario = new JButton("Reservar Livro");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean valida = false;
					if (Aplicacao.getIniciandoPainelUsuario().getUsuariosCadastrados().size() > 0) {
						for (Iterator iterator = Aplicacao.getIniciandoPainelUsuario().getUsuariosCadastrados().iterator(); iterator.hasNext();) {
							Usuario usuario = (Usuario) iterator.next();
							String nomeDoUsuario = tfNomeRetirada.getText();
							if (usuario.getNome().equals(nomeDoUsuario)) {
								valida = true;
								lblErroNomeUsuario.setForeground(new Color(251, 251, 251));
								for (int i = 0; i < comboBoxLivrosReservadosPeloUsuario.getItemCount(); i++) {
									for (Iterator iterator2 = Aplicacao.getIniciandoPainelLivro().getLivrosCadastrados().iterator(); iterator2.hasNext();) {
										Livro livro = (Livro) iterator2.next();
										if (comboBoxLivrosReservadosPeloUsuario.getItemAt(i).equals(livro.getTitulo())) {
											livrosDoUsuario.add(livro);
										}
									}
								}
								if (valida) {
									Emprestimo usuarioEmprestimo = new Emprestimo();
									String dataRetirada = "";
									dataRetirada+= cmbDia.getSelectedItem();
									dataRetirada+= "/";
									dataRetirada+= cmbMes.getSelectedItem();
									dataRetirada+= "/";
									dataRetirada+=  cmbAno.getSelectedItem();
									usuarioEmprestimo.retirarLivro(usuario,livrosDoUsuario,dataRetirada);
									emprestimosCadastrados.add(usuarioEmprestimo);
									File arquivoEmprestimosCadastrados = new File("pasta/emprestimos.txt");
									try {
										if (!arquivoEmprestimosCadastrados.exists()) {
											arquivoEmprestimosCadastrados.createNewFile();
										}
										FileWriter fw = new FileWriter(arquivoEmprestimosCadastrados, true);
										BufferedWriter bw = new BufferedWriter(fw);
										bw.write("Usuario" + ";" + usuario.getNome() + ";" + usuario.getIdade() + ";" + usuario.getMatricula() + ";" + usuario.getEndereco() + "\n");
										
										for (Iterator iterator2 = livrosDoUsuario.iterator(); iterator2.hasNext();) {
											Livro livro = (Livro) iterator2.next();
											bw.write("Livro" + ";" + livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getEditora() + ";" + livro.getNumeroDeChamada() + "\n");	
										}
										bw.write("Data da retirada" + ";" + dataRetirada + "\n");
										
										bw.close();
										fw.close();
										comboBoxLivrosReservadosPeloUsuario.removeAllItems();
									}catch (IOException s) {
										
									}
								}
							} else if (!valida){
								lblErroNomeUsuario.setForeground(Color.RED);
							}
						}
					} else if (!valida) {
						lblErroNomeUsuario.setForeground(Color.RED);
					}
					comboBoxLivrosReservadosPeloUsuario.removeAllItems();
					} catch (EventException s) {
					
					} catch (NumberFormatException c) {
						
					}
			}
		});
		
		btnCadastrarUsuario.setForeground(new Color(0, 0, 0));
		btnCadastrarUsuario.setBounds(497, 443, 204, 43);
		btnCadastrarUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnCadastrarUsuario.setBackground(new Color(0, 191, 255));
		panel.add(btnCadastrarUsuario);
	}
}
