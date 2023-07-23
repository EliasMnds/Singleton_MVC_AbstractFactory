package Fabrica;

//Importanto super classes
import controlador.Controlador;
import entidade.Entidade;
import persistencia.Persistencia;
import visao.Visao;

//Importanto classes filha
import controlador.EmprestimoControlador;
import entidade.EmprestimoEntidade;
import persistencia.EmprestimoPersistencia;
import visao.EmprestimoVisao;

public class EmprestimoFabrica extends Fabrica {

	@Override
	public Entidade createEntidade() {
		// TODO Auto-generated method stub
		return new EmprestimoEntidade();
	}

	@Override
	public Persistencia createPersistencia() {
		// TODO Auto-generated method stub
		//O retorno dessa função é diferente devido a propriedade singleton da classe
		return EmprestimoPersistencia.getInstance();
	}

	@Override
	public Controlador createControlador() {
		// TODO Auto-generated method stub
		return new EmprestimoControlador();
	}

	@Override
	public Visao createVisao() {
		// TODO Auto-generated method stub
		return new EmprestimoVisao();
	}
	
}
