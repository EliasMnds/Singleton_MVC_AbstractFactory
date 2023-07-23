package Fabrica;

import entidade.Entidade;
import persistencia.Persistencia;
import controlador.Controlador;
import visao.Visao;


public abstract class Fabrica {
	
	public static Fabrica getFactory(String string) 
	{
		//1 - Livro
		Fabrica fabrica = null;
		if(string.equals("Livro"))
		{
			fabrica = new LivroFabrica();
		}
		//2 - Emprestimo
		else if(string.equals("Emprestimo")) 
		{
			fabrica = new EmprestimoFabrica();
		}
		return fabrica;
	}
	//Métodos abstrato para serem sobscritos nas subclasses
	    public abstract Entidade createEntidade();
	    public abstract Persistencia createPersistencia();
	    public abstract Controlador createControlador();
	    public abstract Visao createVisao();
	    
}
