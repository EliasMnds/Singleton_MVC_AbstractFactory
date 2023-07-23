package visao;

import java.io.IOException;
import java.util.List;

import Fabrica.Fabrica;
import controlador.Controlador;
import entidade.Entidade;
import entidade.LivroEntidade;

public class LivroVisao extends Visao{	
	@Override
	public void menu(Fabrica fabricaEspecifica) throws IOException {
		// TODO Auto-generated method stub       
		int opcao = -1;
		int opcao2 = -1;
		int Id;
		String Nome;
		LivroEntidade livro;
		Controlador controlador;
		
		LivroEntidade livroAntigo;
		LivroEntidade livroNovo;
		
		String nomeLivro;		
		String novoLivro;
		
		while(opcao != 0) 
		{
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Visualizar Livro");
			System.out.println("3 - Alterar Livro");
			System.out.println("4 - Excluir");
			System.out.println("5 - Buscar Livro");
			System.out.println("0 - Retornar");
			
			opcao = Integer.parseInt(Console.readLine());
			
			 switch (opcao) {

		        case 1:
		        	livro = (LivroEntidade) fabricaEspecifica.createEntidade();
		        	System.out.println("Nome do Livro: ");
		        	nomeLivro = Console.readLine();
		        	livro.setNomeLivro(nomeLivro);
		        	
		        	controlador = fabricaEspecifica.createControlador();
		        	
		        	controlador.insereArray(livro, opcao);
		            break;
		        case 2:
		        	controlador = fabricaEspecifica.createControlador();
		        	controlador.visualizar();
		        	break;
		        case 3:
		        	livroAntigo = (LivroEntidade) fabricaEspecifica.createEntidade();
		        	
		        	System.out.println("Nome do Livro que deseja alterar: ");
		        	nomeLivro = Console.readLine();
		        	livroAntigo.setNomeLivro(nomeLivro);
		        	
		        	livroNovo = (LivroEntidade) fabricaEspecifica.createEntidade();
		        	
		        	System.out.println("Novo nome do Livro: ");
		        	novoLivro = Console.readLine();
		        	livroNovo.setNomeLivro(novoLivro);
		  
		        	
		        	controlador = fabricaEspecifica.createControlador();
		        	
		        	controlador.alterar(livroAntigo, livroNovo);
		        	break;
		        case 4:
		        	livro = (LivroEntidade) fabricaEspecifica.createEntidade();
		        	System.out.println("Nome Livro: ");
		        	nomeLivro = Console.readLine();
		        	livro.setNomeLivro(nomeLivro);
		        	
		        	controlador = fabricaEspecifica.createControlador();
		        	controlador.excluir(livro);
		        	break;
		        case 5:
		        	System.out.println("1 - Busca por Id");
					System.out.println("2 - Busca por Nome");
					System.out.println("0 - Retornar");
					
					opcao2 = Integer.parseInt(Console.readLine());
					
					switch(opcao2) {
						case 1:
							livro = (LivroEntidade) fabricaEspecifica.createEntidade();
				        	System.out.println("Id: ");
				        	Id = Integer.parseInt(Console.readLine());
				        	livro.setId(Id);
				        	controlador = fabricaEspecifica.createControlador();
				        	controlador.buscaPorId(Id);
							break;
						case 2:
							livro = (LivroEntidade) fabricaEspecifica.createEntidade();
				        	System.out.println("Nome: ");
				        	Nome = Console.readLine();
				        	livro.setNomeLivro(Nome);
				        	controlador = fabricaEspecifica.createControlador();
				        	controlador.buscaPorString(Nome);
							break;
						default:
							break;
					}
		        	break;
		        default:
		            System.out.println("Opcao Invalida!");
		     }
		}
		
	}

	@Override
	public void view(List<Entidade> Entidade) {
		// TODO Auto-generated method stub
		for(Entidade l: Entidade) {
			LivroEntidade k = (LivroEntidade) l;
			System.out.println("\n");
			System.out.println("ID: " + l.getId());
			System.out.println("Nome Livro: " + k.getNomeLivro());
		}
	}

	public void viewBusca(Entidade livro) {
		// TODO Auto-generated method stub
		LivroEntidade k = (LivroEntidade) livro;
		System.out.println("ID: " + livro.getId());
		System.out.println("Nome Livro: " + k.getNomeLivro());
	}
}
