package App.panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import org.w3c.dom.events.EventException;

import App.Livro;
import App.Usuario;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
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

public class PanelUsuario extends JPanel {
	private JTextField tfNomeUsuario;
	private JTextField tfIdadeUsuario;
	private JTextField tfMatriculaUsuario;
	private JTextField tfEnderecoUsuario;
	private JButton btnCadastrarUsuario;
	private JLabel lblErroMatricula;
	private ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();

	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public void setUsuariosCadastrados(ArrayList<Usuario> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}

	/**
	 * Create the panel.
	 */
	public PanelUsuario() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(251,251,251));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeUsuario = new JLabel("Nome Completo:");
		lblNomeUsuario.setBounds(375, 114, 162, 23);
		lblNomeUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblNomeUsuario);
		
		JLabel lblIdadeUsuario = new JLabel("Idade:");
		lblIdadeUsuario.setBounds(375, 182, 60, 23);
		lblIdadeUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblIdadeUsuario);
		
		JLabel lblTitle = new JLabel("Cadastrar Usu\u00E1rio");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(437, 48, 324, 34);
		lblTitle.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		panel.add(lblTitle);
		
		JLabel lblMatriculaUsuario = new JLabel("Matr\u00EDcula:");
		lblMatriculaUsuario.setBounds(376, 250, 90, 23);
		lblMatriculaUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblMatriculaUsuario);
		
		JLabel lblEnderecoUsuario = new JLabel("Endere\u00E7o:");
		lblEnderecoUsuario.setBounds(375, 318, 91, 23);
		lblEnderecoUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		panel.add(lblEnderecoUsuario);
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfNomeUsuario.setBounds(375, 148, 223, 23);
		panel.add(tfNomeUsuario);
		tfNomeUsuario.setColumns(10);
		
		tfIdadeUsuario = new JTextField();
		tfIdadeUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfIdadeUsuario.setBounds(375, 216, 61, 23);
		panel.add(tfIdadeUsuario);
		tfIdadeUsuario.setColumns(10);
		
		tfMatriculaUsuario = new JTextField();
		tfMatriculaUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfMatriculaUsuario.setBounds(375, 284, 91, 23);
		panel.add(tfMatriculaUsuario);
		tfMatriculaUsuario.setColumns(10);
		
		tfEnderecoUsuario = new JTextField();
		tfEnderecoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		tfEnderecoUsuario.setBounds(375, 352, 469, 23);
		panel.add(tfEnderecoUsuario);
		tfEnderecoUsuario.setColumns(10);
		
		lblErroMatricula = new JLabel("Matr\u00EDcula inv\u00E1lida!");
		lblErroMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErroMatricula.setForeground(new Color(251, 251, 251));
		lblErroMatricula.setBounds(476, 282, 136, 23);
		panel.add(lblErroMatricula);
		
		JLabel lblIErroUsuarioNCadastrado = new JLabel("Usu\u00E1rio n\u00E3o cadastrrado!");
		lblIErroUsuarioNCadastrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblIErroUsuarioNCadastrado.setForeground(new Color(251, 251, 251));
		lblIErroUsuarioNCadastrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIErroUsuarioNCadastrado.setBounds(538, 116, 264, 23);
		panel.add(lblIErroUsuarioNCadastrado);
		
		btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String validarCaracteresMatricula = tfMatriculaUsuario.getText();
					int validarValorMatricula = Integer.parseInt(tfMatriculaUsuario.getText());
					boolean valida = false;
					boolean validou = false;
					int teste = 0;
					int validaTeste = usuariosCadastrados.size();
					if (usuariosCadastrados.size() > 0) {
						for (Iterator iterator = usuariosCadastrados.iterator(); iterator.hasNext();) {
							Usuario usuario = (Usuario) iterator.next();
							if (validarCaracteresMatricula.length() == 4 && validarValorMatricula != usuario.getMatricula()) {
								teste++;
							}
							if (teste == validaTeste) {
								validou = true;
							}
						}
						if (validou) {
							lblIErroUsuarioNCadastrado.setForeground(new Color(251, 251, 251));
							lblErroMatricula.setForeground(new Color(251, 251, 251));
							valida = true;
							usuariosCadastrados.add(new Usuario(tfNomeUsuario.getText(),tfIdadeUsuario.getText(),tfMatriculaUsuario.getText(),tfEnderecoUsuario.getText()));
							File arquivoUsuarioCadastrados = new File("pasta/usuarios.txt");
							try {
								if (!arquivoUsuarioCadastrados.exists()) {
									arquivoUsuarioCadastrados.createNewFile();
								}
								FileWriter fw = new FileWriter(arquivoUsuarioCadastrados, true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(tfNomeUsuario.getText() + ";" + tfIdadeUsuario.getText() + ";" + tfMatriculaUsuario.getText() + ";" + tfEnderecoUsuario.getText() + "\n");
								bw.close();
								fw.close();
							}catch (IOException s) {
								
							}
						}
					} else {
						if (validarCaracteresMatricula.length() == 4) {
							lblIErroUsuarioNCadastrado.setForeground(new Color(251, 251, 251));
							lblErroMatricula.setForeground(new Color(251, 251, 251));
							valida = true;
							usuariosCadastrados.add(new Usuario(tfNomeUsuario.getText(),tfIdadeUsuario.getText(),tfMatriculaUsuario.getText(),tfEnderecoUsuario.getText()));
							File arquivoUsuarioCadastrados = new File("pasta/usuarios.txt");
							try {
								if (!arquivoUsuarioCadastrados.exists()) {
									arquivoUsuarioCadastrados.createNewFile();
								}
								FileWriter fw = new FileWriter(arquivoUsuarioCadastrados, true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(tfNomeUsuario.getText() + ";" + tfIdadeUsuario.getText() + ";" + tfMatriculaUsuario.getText() + ";" + tfEnderecoUsuario.getText() + "\n");
								bw.close();
								fw.close();
							}catch (IOException s) {
								
							}
						} else {
							lblErroMatricula.setForeground(Color.RED);
						}
					}
					if (!valida) {
						lblErroMatricula.setForeground(Color.RED);
					}
				} catch (ConcurrentModificationException s) {
					lblIErroUsuarioNCadastrado.setForeground(Color.RED);
				} catch (NumberFormatException c) {
					lblIErroUsuarioNCadastrado.setForeground(Color.RED);
				}
			}
		});
		btnCadastrarUsuario.setBounds(497, 429, 204, 43);
		btnCadastrarUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnCadastrarUsuario.setBackground(new Color(0, 191, 255));
		panel.add(btnCadastrarUsuario);
		
	}
}
