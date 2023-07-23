package controlador;

import java.io.IOException;

import entidade.Entidade;
import entidade.LivroEntidade;

public abstract class Controlador {

	public abstract void insereArray(Entidade entidade, int opcao) throws IOException;

	public abstract void alterar(Entidade entidadeAntiga, Entidade entidadeNova);

	public abstract void excluir(Entidade entidade);

	public abstract void visualizar();
	
	public abstract void buscaPorId(int Id);
	
	public abstract void buscaPorString(String nome);


}
