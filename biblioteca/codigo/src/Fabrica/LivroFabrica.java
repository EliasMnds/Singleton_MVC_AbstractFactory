package Fabrica;


//Importanto superclasses
import controlador.Controlador;
import entidade.Entidade;
import visao.Visao;
import persistencia.Persistencia;
//Importando classes filhas
import persistencia.LivroPersistencia;
import entidade.LivroEntidade;
import controlador.LivroControlador;
import visao.LivroVisao;


public class LivroFabrica extends Fabrica{

	@Override
	public Entidade createEntidade() {
		// TODO Auto-generated method stub
		return new LivroEntidade();
		
	}

	@Override
	public Persistencia createPersistencia() {
		// TODO Auto-generated method stub
		//O retorno é diferente devido a natureza singleton da classe
		return LivroPersistencia.getInstance();
	}

	@Override
	public Controlador createControlador() {
		// TODO Auto-generated method stub
		return new LivroControlador();
	}

	@Override
	public Visao createVisao() {
		// TODO Auto-generated method stub
		return new LivroVisao();
	}
	

}
