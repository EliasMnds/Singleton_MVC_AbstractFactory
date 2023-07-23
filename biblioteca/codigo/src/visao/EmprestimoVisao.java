package visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Fabrica.Fabrica;
import controlador.Controlador;
import entidade.EmprestimoEntidade;
import entidade.Entidade;
import entidade.LivroEntidade;
import persistencia.LivroPersistencia;

public class EmprestimoVisao extends Visao {
	Fabrica fabLivro = Fabrica.getFactory("Livro");
	Fabrica fabEmprestimo = Fabrica.getFactory("Emprestimo");

	@Override
	public void menu(Fabrica fabrica) throws IOException {
		// TODO Auto-generated method stub
		int opcao = -1;
		int opcao2 = -1;
		int Id;
		String Nome;

		Controlador controlador;
		EmprestimoEntidade emprestimoAntigo;
		EmprestimoEntidade emprestimoNovo;
		EmprestimoEntidade emprestimo;

		String nomeLivro = null;
		LivroEntidade Livro = null;

		String matriculaAluno;

		String novoLivroNome;
		String novaMatriculaAluno;

		while (opcao != 0) {
			Livro = (LivroEntidade) fabLivro.createEntidade();
			emprestimo = (EmprestimoEntidade) fabEmprestimo.createEntidade();
			System.out.println("1 - Cadastrar Emprestimo");
			System.out.println("2 - Visualizar Emprestimos");
			System.out.println("3 - Alterar Emprestimo");
			System.out.println("4 - Remover Emprestimo");
			System.out.println("5 - Buscar Emprestimo");
			System.out.println("0 - Retornar");

			opcao = Integer.parseInt(Console.readLine());

			switch (opcao) {
			case 1:
				cadastro();
				break;
			case 2:
				controlador = fabrica.createControlador();
				controlador.visualizar();
				break;
			case 3:
				emprestimoAntigo = (EmprestimoEntidade) fabrica.createEntidade();
				System.out.println("Matricula do Aluno: ");
				matriculaAluno = Console.readLine();
				emprestimoAntigo.setMatriculaAluno(matriculaAluno);

				emprestimoNovo = (EmprestimoEntidade) fabrica.createEntidade();

				System.out.println("Nova Matricula: ");
				novaMatriculaAluno = Console.readLine();
				emprestimoNovo.setMatriculaAluno(novaMatriculaAluno);

				controlador = fabrica.createControlador();

				controlador.alterar(emprestimoAntigo, emprestimoNovo);
				break;
			case 4:
				emprestimo = (EmprestimoEntidade) fabrica.createEntidade();
				System.out.println("Matricula: ");
				matriculaAluno = Console.readLine();
				emprestimo.setMatriculaAluno(matriculaAluno);
				controlador = fabrica.createControlador();
				controlador.excluir(emprestimo);
				break;
			case 5:
				System.out.println("1 - Busca por Id");
				System.out.println("2 - Busca por Matricula");
				System.out.println("0 - Retornar");

				opcao2 = Integer.parseInt(Console.readLine());

				switch (opcao2) {
				case 1:
					emprestimo = (EmprestimoEntidade) fabrica.createEntidade();
					System.out.println("Id: ");
					Id = Integer.parseInt(Console.readLine());
					emprestimo.setId(Id);
					controlador = fabrica.createControlador();
					controlador.buscaPorId(Id);
					break;
				case 2:
					emprestimo = (EmprestimoEntidade) fabrica.createEntidade();
					System.out.println("Matricula: ");
					matriculaAluno = Console.readLine();
					controlador = fabrica.createControlador();
					controlador.buscaPorString(matriculaAluno);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void view(List<Entidade> emprestimos) {
		// TODO Auto-generated method stub
		for (Entidade e : emprestimos) {
			viewBusca(e);
		}

	}

	public void viewBusca(Entidade emprestimo) {
		// TODO Auto-generated method stub
		EmprestimoEntidade k = (EmprestimoEntidade) emprestimo;
		System.out.println(k.pString());
	}

	public boolean sanitizeString(String S) {
		if (isInteger(S)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean sanitizeInt(String S) {
		if (!isInteger(S)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isInteger(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public int cadastro() throws IOException {
		Fabrica fabEmprestimo = Fabrica.getFactory("Emprestimo");
		Fabrica fabLivro = Fabrica.getFactory("Livro");

		LivroEntidade Livro = (LivroEntidade) fabLivro.createEntidade();
		Controlador controlador = fabEmprestimo.createControlador();

		String nomeLivro;
		String matriculaAluno;
		int opcao = 1;
		boolean p = false;

		EmprestimoEntidade emprestimo = (EmprestimoEntidade) fabEmprestimo.createEntidade();
		boolean insercao = false;
		while (true) {

			Livro = (LivroEntidade) fabLivro.createEntidade();
			System.out.println("Nome Livro(Digite 'parar' para finalizar): ");
			nomeLivro = Console.readLine();
			Livro = (LivroEntidade) fabLivro.createEntidade();
			Livro.setNomeLivro(nomeLivro);
			
			
			
			if (nomeLivro.equals("parar")) {
				break;
			}
			if (sanitizeString(nomeLivro) == false) {
				System.out.println("Entrada de dado(Livro) inválida");
				return -1;
			}

			List<LivroEntidade> livros = LivroPersistencia.getLivros();
			insercao = false;
			for (LivroEntidade l : livros) {
				if (Livro.getNomeLivro().equals(l.getNomeLivro())) {
					emprestimo.addLivro(Livro);
					insercao = true;
					break;

				}
			}

			if (insercao == false) {
				System.out.println("O livro não foi cadastrado");
				return -2;
			}

		}
		if (insercao == true) {
			System.out.println("Matricula: ");
			matriculaAluno = Console.readLine();
			if (sanitizeString(matriculaAluno) == true) {
				System.out.println("Entrada de dado(Matricula) invalida");
				return -3;
			}
			emprestimo.setMatriculaAluno(matriculaAluno);

			controlador = fabEmprestimo.createControlador();

			controlador.insereArray(emprestimo, opcao);

			return 1;
		}
		return 0;
	}
}
