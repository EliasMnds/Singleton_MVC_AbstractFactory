package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;

import entidade.Entidade;

public abstract class Persistencia {
	public abstract void inserir(Entidade entidade) throws IOException;
	public abstract void alterar(Entidade entidade1, Entidade entidade2);
	public abstract void excluir(Entidade entidade);
	public abstract void buscaPorId(int Id) ;
	public abstract void buscaPorString(String nome);
	public abstract void visualizar();
	public abstract void escreverArquivo() throws IOException;
	public abstract void carregarArquivo() throws FileNotFoundException, IOException;

}
