package App;

public class Usuario extends Emprestimo{
	private String nome;
	private int idade;
	private int matricula;
	private String endereco;
	
	public Usuario(String nome, String idade, String matricula, String endereco) {
		super();
		this.nome = nome;
		this.idade = Integer.parseInt(idade);
		this.matricula = Integer.parseInt(matricula);
		this.endereco = endereco;
	}

	public Usuario() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = Integer.parseInt(idade);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = Integer.parseInt(matricula);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void cadastrarUsuario(String nome, int idade, int matricula, String endereco) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.endereco = endereco;
	}
	
}
