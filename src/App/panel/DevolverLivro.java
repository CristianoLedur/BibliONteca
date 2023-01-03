package App.panel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import org.w3c.dom.events.EventException;

import App.Aplicacao;
import App.Emprestimo;
import App.Livro;
import App.Usuario;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DevolverLivro extends JPanel {
	private JTextField tfNomeDevolucao;
	private JComboBox cmbAno;
	private JComboBox cmbMes;
	private JComboBox cmbDia;
	private JComboBox<String> comboBoxUsuarioLivrosReservados;
	private JComboBox<String> comboBoxUsuarioLivrosDevolucao;
	private JTextField tfStatusDaRetirada;
	/**
	 * Create the panel.
	 */
	public DevolverLivro() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(251,251,251));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeDevolucao = new JLabel("Nome Completo:");
		lblNomeDevolucao.setBounds(375, 116, 176, 23);
		lblNomeDevolucao.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblNomeDevolucao);
		
		JLabel lblDevolucaoDeLivros = new JLabel("Devolver Livro");
		lblDevolucaoDeLivros.setBounds(448, 48, 302, 34);
		lblDevolucaoDeLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevolucaoDeLivros.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		panel.add(lblDevolucaoDeLivros);
		
		JLabel lblDataDevolucao = new JLabel("Data da devolu\u00E7\u00E3o:");
		lblDataDevolucao.setBounds(375, 322, 176, 23);
		lblDataDevolucao.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblDataDevolucao);
		
		tfNomeDevolucao = new JTextField();
		tfNomeDevolucao.setHorizontalAlignment(SwingConstants.LEFT);
		tfNomeDevolucao.setBounds(375, 150, 311, 23);
		panel.add(tfNomeDevolucao);
		tfNomeDevolucao.setColumns(10);
		
		JLabel lblErroUsuarioDevolucao = new JLabel("Usu\u00E1rio n\u00E3o cadastrado!");
		lblErroUsuarioDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErroUsuarioDevolucao.setForeground(new Color(251,251,251));
		lblErroUsuarioDevolucao.setBounds(535, 118, 151, 23);
		panel.add(lblErroUsuarioDevolucao);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblDia.setBounds(375, 356, 38, 14);
		panel.add(lblDia);
		
		cmbDia = new JComboBox();
		cmbDia.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbDia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbDia.setBounds(375, 381, 48, 22);
		panel.add(cmbDia);
		
		JLabel lblMes = new JLabel("M\u00EAs");
		lblMes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblMes.setBounds(435, 356, 38, 14);
		panel.add(lblMes);
		
		cmbMes = new JComboBox();
		cmbMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cmbMes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbMes.setBounds(435, 381, 48, 22);
		panel.add(cmbMes);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblAno.setBounds(493, 356, 38, 14);
		panel.add(lblAno);
		
		cmbAno = new JComboBox();
		cmbAno.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023"}));
		cmbAno.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cmbAno.setBounds(493, 381, 66, 22);
		panel.add(cmbAno);
		
		JLabel lblLivrosParaDevoluo = new JLabel("Livros para devolu\u00E7\u00E3o:");
		lblLivrosParaDevoluo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblLivrosParaDevoluo.setBounds(375, 249, 311, 23);
		panel.add(lblLivrosParaDevoluo);
		
		comboBoxUsuarioLivrosReservados = new JComboBox<String>();
		comboBoxUsuarioLivrosReservados.setBounds(375, 213, 311, 23);
		panel.add(comboBoxUsuarioLivrosReservados);
		
		JLabel lblUsuarioLivrosReservados = new JLabel("Livros reservados:");
		lblUsuarioLivrosReservados.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblUsuarioLivrosReservados.setBounds(375, 181, 310, 23);
		panel.add(lblUsuarioLivrosReservados);
		
		comboBoxUsuarioLivrosDevolucao = new JComboBox<String>();
		comboBoxUsuarioLivrosDevolucao.setBounds(375, 280, 311, 23);
		panel.add(comboBoxUsuarioLivrosDevolucao);
		
		JButton btnRemoverLivroLista = new JButton("Remover da lista");
		btnRemoverLivroLista.setForeground(Color.BLACK);
		btnRemoverLivroLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxUsuarioLivrosDevolucao.removeItem(comboBoxUsuarioLivrosDevolucao.getSelectedItem());
			}
		});
		btnRemoverLivroLista.setBackground(new Color(240, 128, 128));
		btnRemoverLivroLista.setBounds(696, 280, 210, 23);
		panel.add(btnRemoverLivroLista);
		
		JButton btnAdicionarListaLivrosUsuario = new JButton("Adicionar a lista de devolu\u00E7\u00E3o");
		btnAdicionarListaLivrosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxUsuarioLivrosDevolucao.addItem((String) comboBoxUsuarioLivrosReservados.getSelectedItem());
			}
		});
		btnAdicionarListaLivrosUsuario.setForeground(Color.BLACK);
		btnAdicionarListaLivrosUsuario.setBackground(new Color(0, 191, 255));
		btnAdicionarListaLivrosUsuario.setBounds(696, 213, 210, 23);
		panel.add(btnAdicionarListaLivrosUsuario);
		
		JLabel lblStatusDaReserva = new JLabel("Status:");
		lblStatusDaReserva.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblStatusDaReserva.setBounds(473, 504, 76, 23);
		panel.add(lblStatusDaReserva);
		
		tfStatusDaRetirada = new JTextField();
		tfStatusDaRetirada.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		tfStatusDaRetirada.setBounds(540, 507, 132, 20);
		panel.add(tfStatusDaRetirada);
		tfStatusDaRetirada.setColumns(10);

		
		JButton btnDevolverLivro = new JButton("Devolver Livro");
		btnDevolverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File arquivoEmprestimosCadastrados = new File("pasta/emprestimos.txt");
					try {
						if (!arquivoEmprestimosCadastrados.exists()) {
							arquivoEmprestimosCadastrados.createNewFile();
						}
						FileWriter fwEmprestimos = new FileWriter(arquivoEmprestimosCadastrados, false);
						BufferedWriter bwEmprestimos = new BufferedWriter(fwEmprestimos);
						boolean valida = false;
						int n = comboBoxUsuarioLivrosDevolucao.getItemCount();
						String[] livros = new String[n];
						for (int i = 0; i < n; i++) {
							livros[i] = comboBoxUsuarioLivrosDevolucao.getItemAt(i);
						}
						for (Iterator iterator = Aplicacao.getIniciandoPainelRetirarLivro().getEmprestimosCadastrados().iterator(); iterator.hasNext();) {
							Emprestimo emprestimo = (Emprestimo) iterator.next();
							String nomeDoUsuario = tfNomeDevolucao.getText();
							if (emprestimo.getUsuario().getNome().equals(nomeDoUsuario)) {
								valida = true;
								lblErroUsuarioDevolucao.setForeground(new Color(251,251,251));
								for (int j = 0; j < livros.length; j++) {
									for (int i = 0; i < emprestimo.getLivros().size(); i++) {
										Livro livro = emprestimo.getLivros().get(i);						
										if (livro.getTitulo().equals(livros[j])) {
											emprestimo.getLivros().remove(livro);
											break;
										}
									}
								}
								try {
									String dataDaDevolucao = "";
									dataDaDevolucao+= cmbDia.getSelectedItem();
									dataDaDevolucao+= "/";
									dataDaDevolucao += cmbMes.getSelectedItem();
									dataDaDevolucao+= "/";
									dataDaDevolucao+= cmbAno.getSelectedItem();
									String dataDaRetirada = emprestimo.getDataRetirada();
									int dias = (int) emprestimo.diferencaData(dataDaRetirada,dataDaDevolucao);
									if (dias > 7) {
										tfStatusDaRetirada.setText("Atrasado");
										tfStatusDaRetirada.setForeground(Color.RED);		
									} else {
										tfStatusDaRetirada.setText("Em dia");
										tfStatusDaRetirada.setForeground(Color.GREEN);
									}
								} catch (Exception s) {
								}
								comboBoxUsuarioLivrosReservados.removeAllItems();
								comboBoxUsuarioLivrosDevolucao.removeAllItems();
							}
							if (emprestimo.getLivros().size() > 0) {
								bwEmprestimos.write("Usuario" + ";" + emprestimo.getUsuario().getNome() + ";" + emprestimo.getUsuario().getIdade() + ";" + emprestimo.getUsuario().getMatricula() + ";" + emprestimo.getUsuario().getEndereco() + "\n");	
								for (Iterator iterator3 = emprestimo.getLivros().iterator(); iterator3.hasNext();) {
									Livro livro = (Livro) iterator3.next();
									bwEmprestimos.write("Livro" + ";" + livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getEditora() + ";" + livro.getNumeroDeChamada() + "\n");	
								}
								bwEmprestimos.write("Data da retirada" + ";" + emprestimo.getDataRetirada() + "\n");	
							}
						}
						bwEmprestimos.close();
						fwEmprestimos.close();
						}catch (IOException s) {
							
					}
				} catch (ConcurrentModificationException s) {
					
				} catch (NumberFormatException c) {
					
				}	
			}
		});
		btnDevolverLivro.setBounds(497, 437, 204, 43);
		btnDevolverLivro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnDevolverLivro.setBackground(new Color(0, 191, 255));
		panel.add(btnDevolverLivro);
		
		JButton btnValidaUsuario = new JButton("Validar usuario");
		btnValidaUsuario.setForeground(Color.BLACK);
		btnValidaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboBoxUsuarioLivrosReservados.removeAllItems();
					comboBoxUsuarioLivrosDevolucao.removeAllItems();
					boolean valida = false;
					for (Iterator iterator = Aplicacao.getIniciandoPainelRetirarLivro().getEmprestimosCadastrados().iterator(); iterator.hasNext();) {
						Emprestimo emprestimo = (Emprestimo) iterator.next();
						String nomeDoUsuario = tfNomeDevolucao.getText();
						if (emprestimo.getUsuario().getNome().equals(nomeDoUsuario)) {
							valida = true;
							lblErroUsuarioDevolucao.setForeground(new Color(251,251,251));
							
							for (int i = 0; i < emprestimo.getLivros().size(); i++) {
								Livro livro = emprestimo.getLivros().get(i);
								comboBoxUsuarioLivrosReservados.addItem(livro.getTitulo());	
							};
						}
					}
					if (!valida) {
							lblErroUsuarioDevolucao.setForeground(Color.RED);
					}	
				} catch (EventException s) {
					
				}
			}
		});
		btnValidaUsuario.setBackground(new Color(0, 191, 255));
		btnValidaUsuario.setBounds(696, 150, 210, 23);
		panel.add(btnValidaUsuario);
		
	}
}
