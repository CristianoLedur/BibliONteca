package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo{
	private ArrayList<Livro> livros;
	private Usuario usuario;
	private String dataRetirada;
	private String dataDevolucao;
	

	public long diferencaData(String dataReirada, String dataDevolucao) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiraDt = sdf.parse(dataReirada);
		Date segundaDt = sdf.parse(dataDevolucao);	
		long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());	
		long diff = TimeUnit.DAYS.convert(diffEmMil,TimeUnit.MILLISECONDS);
		return diff;
	}
	
	public String getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	
	public void adicionarLivros(Livro livro) {
		this.livros.add(livro);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public void retirarLivro(Usuario usuario, ArrayList<Livro> livros, String dataRetirada) {
		this.usuario = usuario;
		this.livros = livros;
		this.dataRetirada = dataRetirada;
				
		//ainda estou pensando em como fazer para adicionar mais de um livro simultaneamente	
	}
	
	public void devolverLivro(Usuario usuario, ArrayList<Livro> livros, Date dataDevolucao) {
		//ainda estou pensando em como fazer para devolver mais de um livro simultaneamente
		
	}
}
