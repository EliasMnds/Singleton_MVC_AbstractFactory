package teste;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import Fabrica.EmprestimoFabrica;
import Fabrica.Fabrica;
import Fabrica.LivroFabrica;
import controlador.Controlador;
import entidade.EmprestimoEntidade;
import entidade.LivroEntidade;
import persistencia.LivroPersistencia;
import persistencia.Persistencia;
import visao.Console;
import visao.EmprestimoVisao;

public class Teste {
	
	Fabrica fabEmprestimo = Fabrica.getFactory("Emprestimo");
	
	
	
	String nomeLivro;
	
	String matricula;
	
	@Test
	public void nomeLivroInvalido() throws IOException 
	{
		EmprestimoVisao visao = (EmprestimoVisao) fabEmprestimo.createVisao();
		assertEquals(-1, visao.cadastro());
	}
	
	@Test
	public void livroNaoCadastrado() throws IOException {
		EmprestimoVisao visao = (EmprestimoVisao) fabEmprestimo.createVisao();
		assertEquals(-2, visao.cadastro());
	}
	
	@Test
    public void matriculaInvalida() throws IOException {
		EmprestimoVisao visao = (EmprestimoVisao) fabEmprestimo.createVisao();
		assertEquals(-3, visao.cadastro());
	}
	@Test
    public void cadastroSucesso() throws IOException {
		EmprestimoVisao visao = (EmprestimoVisao) fabEmprestimo.createVisao();
		Fabrica fabLivro = Fabrica.getFactory("Livro");
		Controlador controlador = fabLivro.createControlador();
		LivroEntidade Livro = (LivroEntidade) fabLivro.createEntidade();
		Livro.setNomeLivro("Livro1");
		controlador.insereArray(Livro,0);
		assertEquals(1, visao.cadastro());
	}
	
	
}
