package visao;

import java.io.IOException;
import java.util.List;

import Fabrica.Fabrica;
import entidade.Entidade;
import persistencia.Persistencia;

public abstract class Visao {
	public abstract void menu(Fabrica fabrica) throws IOException;
	//Dentro de visao deve exister somente Sair,Livro,Emprestimo
	//Quando entramos no livro, temos que abrir as opções lá
	public static void main(String args[]) throws IOException {
		menuGeral();
		
	}
	public static void menuGeral() throws IOException {
        String opcao = null;
        
        Fabrica fabricaEmprestimo = Fabrica.getFactory("Emprestimo");
        Fabrica fabricaLivro = Fabrica.getFactory("Livro");
        
        Persistencia persistenciaEmprestimo = fabricaEmprestimo.createPersistencia();
        Persistencia persistenciaLivro = fabricaLivro.createPersistencia();
        
        persistenciaEmprestimo.carregarArquivo();
        persistenciaLivro.carregarArquivo();
      
        while(opcao != "0") 
        {
            System.out.println("Menu");
            System.out.println("\tLivro");
            System.out.println("\tEmprestimo");
            System.out.println("\t0 - Sair");
            System.out.println("\nDigite a Opção:");
           
        

        opcao = Console.readLine();
        if(opcao.equals("0"))break;
        
        //Define qual tipo de entidade será escolhida
        Fabrica fabricaGeral = Fabrica.getFactory(opcao);
        
        //É fabricada a visao da minha entidade
        Visao visao = fabricaGeral.createVisao();
        
        //Chama o menu específico de cada entidade
        visao.menu(fabricaGeral);
        
        
        }
        
        //Para poder escrever nas listas logo que finalizar o programa
        persistenciaEmprestimo.escreverArquivo();
        persistenciaLivro.escreverArquivo();
    }
	public abstract void view(List<Entidade> Entidade);
	public abstract void viewBusca(Entidade entidade);
	
}
