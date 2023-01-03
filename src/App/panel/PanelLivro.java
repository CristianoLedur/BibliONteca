package App.panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import App.Aplicacao;
import App.Livro;
import App.Usuario;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelLivro extends JPanel {
	private JTextField tfTituloLivro;
	private JTextField tfAutorLivro;
	private JTextField tfEditoraLivrvo;
	private JTextField tfNumeroChamadaLivro;
	private ArrayList<Livro> livrosCadastrados = new ArrayList<Livro>();
	private JButton btnCadastrarLivro;

	public ArrayList<Livro> getLivrosCadastrados() {
		return livrosCadastrados;
	}

	public void setLivrosCadastrados(ArrayList<Livro> livrosCadastrados) {
		this.livrosCadastrados = livrosCadastrados;
	}
	
	public JButton getBtnCadastrarLivro() {
		return btnCadastrarLivro;
	}

	public void setBtnCadastrarLivro(JButton btnCadastrarLivro) {
		this.btnCadastrarLivro = btnCadastrarLivro;
	}


	/**
	 * Create the panel.
	 */
	public PanelLivro() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(251,251,251));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTituloLivro = new JLabel("T\u00EDtulo do Livro:");
		lblTituloLivro.setBounds(375, 114, 149, 23);
		lblTituloLivro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblTituloLivro);
		
		JLabel lblAutorLivro = new JLabel("Autor:");
		lblAutorLivro.setBounds(375, 182, 60, 23);
		lblAutorLivro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblAutorLivro);
		
		JLabel lblTitle = new JLabel("Cadastrar Livro");
		lblTitle.setBounds(437, 48, 324, 34);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		panel.add(lblTitle);
		
		JLabel lblEditoraLivro = new JLabel("Editora:");
		lblEditoraLivro.setBounds(375, 250, 111, 23);
		lblEditoraLivro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblEditoraLivro);
		
		JLabel lblNumeroChamadaLivro = new JLabel("N\u00FAmero de chamada:");
		lblNumeroChamadaLivro.setBounds(375, 319, 199, 23);
		lblNumeroChamadaLivro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblNumeroChamadaLivro);
		
		tfTituloLivro = new JTextField();
		tfTituloLivro.setHorizontalAlignment(SwingConstants.LEFT);
		tfTituloLivro.setBounds(375, 148, 484, 23);
		panel.add(tfTituloLivro);
		tfTituloLivro.setColumns(10);
		
		tfAutorLivro = new JTextField();
		tfAutorLivro.setHorizontalAlignment(SwingConstants.LEFT);
		tfAutorLivro.setBounds(375, 216, 337, 23);
		panel.add(tfAutorLivro);
		tfAutorLivro.setColumns(10);
		
		tfEditoraLivrvo = new JTextField();
		tfEditoraLivrvo.setHorizontalAlignment(SwingConstants.LEFT);
		tfEditoraLivrvo.setBounds(375, 284, 337, 23);
		panel.add(tfEditoraLivrvo);
		tfEditoraLivrvo.setColumns(10);
		
		tfNumeroChamadaLivro = new JTextField();
		tfNumeroChamadaLivro.setHorizontalAlignment(SwingConstants.LEFT);
		tfNumeroChamadaLivro.setBounds(375, 353, 337, 23);
		panel.add(tfNumeroChamadaLivro);
		tfNumeroChamadaLivro.setColumns(10);
		
		JLabel lblErroNumeroChamadaLivro = new JLabel("N\u00FAmero de chamada inv\u00E1lido!");
		lblErroNumeroChamadaLivro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErroNumeroChamadaLivro.setForeground(new Color(251,251,251));
		lblErroNumeroChamadaLivro.setBounds(722, 351, 222, 23);
		panel.add(lblErroNumeroChamadaLivro);
		
		btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String validarCaracteresNumeroChamada = tfNumeroChamadaLivro.getText();
					int validarValorNumeroChamada = Integer.parseInt(tfNumeroChamadaLivro.getText());
					boolean valida = false;
					boolean validou = false;
					int teste = 0;
					int validaTeste = livrosCadastrados.size();
					if (livrosCadastrados.size() > 0) {
						for (Iterator iterator = livrosCadastrados.iterator(); iterator.hasNext();) {
							Livro livro = (Livro) iterator.next();
							if (validarCaracteresNumeroChamada.length() == 4 && validarValorNumeroChamada != livro.getNumeroDeChamada()) {
								teste++;
							}
							if (teste == validaTeste) {
								validou = true;
							}
						}		
						if (validou) {
							lblErroNumeroChamadaLivro.setForeground(new Color(251, 251, 251));
							valida = true;
							livrosCadastrados.add(new Livro(tfTituloLivro.getText(),tfAutorLivro.getText(),tfEditoraLivrvo.getText(),tfNumeroChamadaLivro.getText()));
							Aplicacao.getIniciandoPainelRetirarLivro().adicionarItemJComboBox(tfTituloLivro.getText());
							File arquivoLivrosCadastrados = new File("pasta/livros.txt");
							try {
								if (!arquivoLivrosCadastrados.exists()) {
									arquivoLivrosCadastrados.createNewFile();
								}
								FileWriter fw = new FileWriter(arquivoLivrosCadastrados, true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(tfTituloLivro.getText() + ";" + tfAutorLivro.getText() + ";" + tfEditoraLivrvo.getText() + ";" + tfNumeroChamadaLivro.getText() + "\n");
								bw.close();
								fw.close();
							}catch (IOException s) {
								
							}
						}
					} else {
						if (validarCaracteresNumeroChamada.length() == 4) {
							lblErroNumeroChamadaLivro.setForeground(new Color(251, 251, 251));
							valida = true;
							livrosCadastrados.add(new Livro(tfTituloLivro.getText(),tfAutorLivro.getText(),tfEditoraLivrvo.getText(),tfNumeroChamadaLivro.getText()));
							Aplicacao.getIniciandoPainelRetirarLivro().adicionarItemJComboBox(tfTituloLivro.getText());
							File arquivoLivrosCadastrados = new File("pasta/livros.txt");
							try {
								if (!arquivoLivrosCadastrados.exists()) {
									arquivoLivrosCadastrados.createNewFile();
								}
								FileWriter fw = new FileWriter(arquivoLivrosCadastrados, true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(tfTituloLivro.getText() + ";" + tfAutorLivro.getText() + ";" + tfEditoraLivrvo.getText() + ";" + tfNumeroChamadaLivro.getText() + "\n");
								
								bw.close();
								fw.close();
							}catch (IOException s) {
								
							}
						} else {
							lblErroNumeroChamadaLivro.setForeground(Color.RED);
						}
					}
					if (!valida) {
						lblErroNumeroChamadaLivro.setForeground(Color.RED);
					}
				} catch (ConcurrentModificationException s) {	
					lblErroNumeroChamadaLivro.setForeground(Color.RED);
				} catch (NumberFormatException c) {
					lblErroNumeroChamadaLivro.setForeground(Color.RED);
				}
			}
		});
		btnCadastrarLivro.setBounds(497, 418, 204, 43);
		btnCadastrarLivro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnCadastrarLivro.setBackground(new Color(0, 191, 255));
		panel.add(btnCadastrarLivro);
	}
}
