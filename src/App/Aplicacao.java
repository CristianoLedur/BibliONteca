package App;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.w3c.dom.events.EventException;
import App.Livro;
import App.Usuario;
import App.Emprestimo;

import App.panel.DevolverLivro;
import App.panel.PanelLivro;
import App.panel.PanelUsuario;
import App.panel.RetirarLivro;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Aplicacao {

	private JFrame frame;
	private JPanel panelBody;
	private static PanelUsuario IniciandoPainelUsuario = new PanelUsuario();
	private static PanelLivro IniciandoPainelLivro = new PanelLivro();
	private static RetirarLivro IniciandoPainelRetirarLivro = new RetirarLivro();
	private DevolverLivro IniciandoPainelDevolverLivro = new DevolverLivro();
	//private PanelLivro painelLivro;
	//private RetirarLivro painelRetirarLivro;
	//private DevolverLivro painelDevolverLivrvo;

	public static PanelUsuario getIniciandoPainelUsuario() {
		return IniciandoPainelUsuario;
	}

	public void setIniciandoPainelUsuario(PanelUsuario iniciandoPainelUsuario) {
		IniciandoPainelUsuario = iniciandoPainelUsuario;
	}

	public static PanelLivro getIniciandoPainelLivro() {
		return IniciandoPainelLivro;
	}

	public void setIniciandoPainelLivro(PanelLivro iniciandoPainelLivro) {
		IniciandoPainelLivro = iniciandoPainelLivro;
	}

	public static RetirarLivro getIniciandoPainelRetirarLivro() {
		return IniciandoPainelRetirarLivro;
	}

	public void setIniciandoPainelRetirarLivro(RetirarLivro iniciandoPainelRetirarLivro) {
		IniciandoPainelRetirarLivro = iniciandoPainelRetirarLivro;
	}

	public DevolverLivro getIniciandoPainelDevolverLivro() {
		return IniciandoPainelDevolverLivro;
	}

	public void setIniciandoPainelDevolverLivro(DevolverLivro iniciandoPainelDevolverLivro) {
		IniciandoPainelDevolverLivro = iniciandoPainelDevolverLivro;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacao window = new Aplicacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacao() {
		
		File f = new File("pasta");
		f.mkdir();
		File arquivoUsuarioCadastrados = new File("pasta/usuarios.txt");
		File arquivoLivrosCadastrados = new File("pasta/livros.txt");
		File arquivoEmprestimosCadastrados = new File("pasta/emprestimos.txt");
		try {
			if (!arquivoUsuarioCadastrados.exists()) {
				arquivoUsuarioCadastrados.createNewFile();
			}
			if (!arquivoLivrosCadastrados.exists()) {
				arquivoLivrosCadastrados.createNewFile();
			}
			if (!arquivoEmprestimosCadastrados.exists()) {
				arquivoEmprestimosCadastrados.createNewFile();
			}
			
			FileReader frUsuarios = new FileReader(arquivoUsuarioCadastrados);
			BufferedReader brUsuarios = new BufferedReader(frUsuarios);
			
			String linha = null;
			
			while((linha = brUsuarios.readLine()) != null) {
				if (linha!= null && !linha.isEmpty()) {
					String[] dados = linha.split("\\;");
					Usuario usuario = new Usuario(dados[0],dados[1],dados[2],dados[3]);
					Aplicacao.IniciandoPainelUsuario.getUsuariosCadastrados().add(usuario);
				}	
			}
			brUsuarios.close();
			frUsuarios.close();
			
			
			FileReader frLivros = new FileReader(arquivoLivrosCadastrados);
			BufferedReader brLivros = new BufferedReader(frLivros);
			
			linha = null;
			
			while((linha = brLivros.readLine()) != null) {
				if (linha!= null && !linha.isEmpty()) {
					String[] dados = linha.split("\\;");
					Livro livro = new Livro(dados[0],dados[1],dados[2],dados[3]);
					Aplicacao.getIniciandoPainelRetirarLivro().adicionarItemJComboBox(dados[0]);
					Aplicacao.IniciandoPainelLivro.getLivrosCadastrados().add(livro);
				}
			}
			brLivros.close();
			frLivros.close();
			
			
			FileReader frEmprestimos = new FileReader(arquivoEmprestimosCadastrados);
			BufferedReader brEmprestimos = new BufferedReader(frEmprestimos);

			linha = null;
			Emprestimo usuarioEmprestimo = new Emprestimo();
			ArrayList<Livro> arraylivros = new ArrayList<Livro>();
			Usuario usuario = new Usuario();
			String data = "";
			while((linha = brEmprestimos.readLine()) != null) {
				String[] dados = linha.split("\\;");
				if (linha != null && !linha.isEmpty()) {
					if (dados[0].equals("Usuario")) {
						usuario.setNome(dados[1]);
						usuario.setIdade(dados[2]);
						usuario.setMatricula(dados[3]);
						usuario.setEndereco(dados[4]);
						continue;
					} else if (dados[0].equals("Livro")) {
						Livro livro = new Livro(dados[1],dados[2],dados[3],dados[4]);
						arraylivros.add(livro);
						continue;
					} else if (dados[0].equals("Data da retirada")) {
						data = dados[1];
					}
					usuarioEmprestimo.retirarLivro(usuario,arraylivros,data);
					Aplicacao.getIniciandoPainelRetirarLivro().getEmprestimosCadastrados().add(usuarioEmprestimo);
					usuario = new Usuario();
					usuarioEmprestimo = new Emprestimo();
					arraylivros = new ArrayList<Livro>();
					data = "";
				}			
			}
			brEmprestimos.close();
			frEmprestimos.close();
		}catch (IOException s) {
			
		}
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(251, 251, 251));
		frame.setBounds(100, 100, 1200, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 191, 255));
		frame.setJMenuBar(menuBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(100);
		menuBar.add(horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(50);
		menuBar.add(verticalStrut);
		
		//inicializando paineis
		
		JMenuItem mntmBiblioneteca = new JMenuItem("BibliONteca");
		mntmBiblioneteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panelBody);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
			}
		});
		mntmBiblioneteca.setHorizontalAlignment(SwingConstants.LEFT);
		mntmBiblioneteca.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		mntmBiblioneteca.setBackground(new Color(0, 191, 255));
		menuBar.add(mntmBiblioneteca);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(290);
		menuBar.add(horizontalStrut_1);
		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastro de Usu\u00E1rio");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(IniciandoPainelUsuario);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
			}
		});
		mntmCadastrarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCadastrarUsuario.setForeground(Color.BLACK);
		mntmCadastrarUsuario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		mntmCadastrarUsuario.setBackground(new Color(0, 191, 255));
		menuBar.add(mntmCadastrarUsuario);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(45);
		menuBar.add(horizontalStrut_2);
		
		JMenuItem mntmCadastrarLivro = new JMenuItem("Cadastro de Livro");
		mntmCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(IniciandoPainelLivro);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
				
				
				
			}
		});
		mntmCadastrarLivro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCadastrarLivro.setForeground(Color.BLACK);
		mntmCadastrarLivro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		mntmCadastrarLivro.setBackground(new Color(0, 191, 255));
		menuBar.add(mntmCadastrarLivro);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(40);
		menuBar.add(horizontalStrut_3);
		
		JMenuItem mntmRetirarLivro = new JMenuItem("Reservar Livro");
		mntmRetirarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(IniciandoPainelRetirarLivro);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
			}
		});
		mntmRetirarLivro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRetirarLivro.setForeground(Color.BLACK);
		mntmRetirarLivro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		mntmRetirarLivro.setBackground(new Color(0, 191, 255));
		menuBar.add(mntmRetirarLivro);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(10);
		menuBar.add(horizontalStrut_4);
		
		JMenuItem mntmDevolverLivro = new JMenuItem("Devolver Livro");
		mntmDevolverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(IniciandoPainelDevolverLivro);
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
			}
		});
		mntmDevolverLivro.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDevolverLivro.setForeground(Color.BLACK);
		mntmDevolverLivro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		mntmDevolverLivro.setBackground(new Color(0, 191, 255));
		menuBar.add(mntmDevolverLivro);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_5);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		panelBody = new JPanel();
		panelBody.setBackground(new Color(251, 251, 251));
		frame.getContentPane().add(panelBody);
		panelBody.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem-Vindos a");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel.setBounds(310, 75, 574, 78);
		panelBody.add(lblNewLabel);
		
		JLabel lblBiblionteca = new JLabel("BibliONteca");
		lblBiblionteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblionteca.setForeground(new Color(0, 191, 255));
		lblBiblionteca.setFont(new Font("Comic Sans MS", Font.PLAIN, 99));
		lblBiblionteca.setBounds(152, 187, 890, 161);
		panelBody.add(lblBiblionteca);
		
		JLabel lblNewLabel_1 = new JLabel("Desenvolvedores:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(505, 481, 183, 23);
		panelBody.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cristiano Ledur");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(505, 515, 183, 23);
		panelBody.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Jonas Herpich");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(505, 536, 183, 32);
		panelBody.add(lblNewLabel_1_2);
	}
}
