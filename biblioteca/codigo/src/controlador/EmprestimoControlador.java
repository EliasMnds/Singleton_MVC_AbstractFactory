package controlador;

import java.io.IOException;

import Fabrica.Fabrica;
import entidade.Entidade;
import entidade.LivroEntidade;
import persistencia.Persistencia;

public class EmprestimoControlador extends Controlador{
	Fabrica fabrica = Fabrica.getFactory("Emprestimo");
	Persistencia persistencia;
	public void insereArray(Entidade emprestimo, int opcao) throws IOException {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.inserir(emprestimo);
	}
	@Override
	public void alterar(Entidade emprestimoAntigo, Entidade emprestimoNovo) {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.alterar(emprestimoAntigo,emprestimoNovo);
		
	}
	@Override
	public void excluir(Entidade emprestimo) {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.excluir(emprestimo);
	}
	@Override
	public void visualizar() {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.visualizar();
	}
	@Override
	public void buscaPorId(int Id) {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.buscaPorId(Id);
	}
	@Override
	public void buscaPorString(String matricula) {
		// TODO Auto-generated method stub
		persistencia = fabrica.createPersistencia();
		persistencia.buscaPorString(matricula);
	}
}
