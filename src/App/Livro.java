package App;

public class Livro extends Emprestimo{
	private String titulo;
	private String autor;
	private String editora;
	private int numeroDeChamada;
	
	
	public Livro(String titulo, String autor, String editora, String numeroDeChamada) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.numeroDeChamada = Integer.parseInt(numeroDeChamada);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumeroDeChamada() {
		return numeroDeChamada;
	}

	public void setNumeroDeChamada(String numeroDeChamada) {
		this.numeroDeChamada = Integer.parseInt(numeroDeChamada);
	}

	public void cadastrarLivro(String titulo, String autor, String editora, int numeroDeChamada ) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.numeroDeChamada = numeroDeChamada;
	}
}
