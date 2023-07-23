package entidade;

public class LivroEntidade extends Entidade{
	public String nomeLivro;

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String pString() 
	{
		String s = "\n";
		s += "Nome do Livro: " + nomeLivro;
		return s;
	}


	
}
