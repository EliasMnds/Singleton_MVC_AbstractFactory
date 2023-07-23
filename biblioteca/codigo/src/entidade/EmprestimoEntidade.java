package entidade;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoEntidade extends Entidade{
	private  List<LivroEntidade> Livros = new ArrayList<LivroEntidade>();
	public String matriculaAluno;
	
	public String getMatriculaAluno() {
		return matriculaAluno;
		}
	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	public String getNomeLivro(LivroEntidade L) {
		for(LivroEntidade l: Livros) 
		{
			if(l.getNomeLivro().equals(L.getNomeLivro())) 
			{
				return l.getNomeLivro();
			}
		}
		return "null";
	}
	public String pString() 
	{
		String k = " ";
		for(LivroEntidade l : Livros) 
		{
			k += l.pString();
		}
		String s = "\n---------------------------------:\n";
		s += "id: " + this.getId() + "\nMatricula do Aluno: " + this.getMatriculaAluno() + "\n" + "Livros: " + k + "\n";
		
		return s;
	}
	public void setLivros(List<LivroEntidade> lLivros) 
	{
		Livros = lLivros;
		
	}
	public void addLivro(LivroEntidade Livro) 
	{
		Livros.add(Livro);
	}
	public void excluirLivro(LivroEntidade Livro) {
		for(LivroEntidade Le : Livros) 
		{
			if(Le.getNomeLivro().equals(Livro.getNomeLivro())) 
			{
				Livros.remove(Le);
			}
		}
	}
	public List<LivroEntidade> getLivros() 
	{
		return Livros;
	}

}
