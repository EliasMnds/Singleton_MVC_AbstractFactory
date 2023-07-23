package persistencia;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Fabrica.Fabrica;
import Fabrica.LivroFabrica;
import entidade.EmprestimoEntidade;
import entidade.Entidade;
import entidade.LivroEntidade;
import visao.Visao;

public class EmprestimoPersistencia extends Persistencia{
	static java.io.File diretorio = null;
	static java.io.File arquivo;
	private static FileWriter texto = null;
	private static PrintWriter escrito = null;
	Fabrica fabrica = Fabrica.getFactory("Emprestimo");
	
	
	//Lista de Emprestimo
	private static List<EmprestimoEntidade> emprestimos = new ArrayList<EmprestimoEntidade>();
	//Declaração da classe como singleton
	private static EmprestimoPersistencia uniqueInstance;
	
	private EmprestimoPersistencia() {
	}
	public static synchronized EmprestimoPersistencia getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new EmprestimoPersistencia();
		diretorio = new java.io.File("C:\\testesMatheus\\BElias\\BElias");
		arquivo = new java.io.File(diretorio, "emprestimos.txt");
		return uniqueInstance;
	}
	//------------------------------------
	//Criar metodo para salvar o array no arquivo
	//Criar metodo para ler o arquivo e salvar no arrays
	@Override
	public void inserir(Entidade emprestimo) throws IOException {
		// TODO Auto-generated method stub
		emprestimo.setId(emprestimos.size() + 1);
		Boolean verifica = emprestimos.add((EmprestimoEntidade) emprestimo);
		if(verifica == true) {
			System.out.println("Cadastrado com Sucesso!");
		}
		else {
			System.out.println("Sem sucesso no Cadastro!");
		}
	}

	public void escreverArquivo() throws IOException {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			EmprestimoEntidade k = (EmprestimoEntidade) e;
			texto = new FileWriter(arquivo, true);
			escrito = new PrintWriter(texto);
			escrito.println("Emprestimo:");
			escrito.println("Id: ~" + e.getId());
			escrito.println("Matricula Aluno: #" + k.getMatriculaAluno());
			for(LivroEntidade l: k.getLivros()) 
			{
				escrito.println("Nome do Livro: &" + l.getNomeLivro());
			}
			escrito.flush();
			escrito.close();
		}
	}
	//O objetivo é poder verficiar a existência do emprestimo para poder renová-lo
	@Override
	public void alterar(Entidade emprestimoAntigo, Entidade emprestimoNovo) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			EmprestimoEntidade k = (EmprestimoEntidade) e;
			EmprestimoEntidade p = (EmprestimoEntidade) emprestimoAntigo;
			EmprestimoEntidade y = (EmprestimoEntidade) emprestimoNovo;
			if(k.getMatriculaAluno().equals(p.getMatriculaAluno())){
				EmprestimoEntidade novoEmprestimo = (EmprestimoEntidade) e;
				novoEmprestimo.setMatriculaAluno(y.getMatriculaAluno());
				return;
			}
		}
		
	}
	@Override
	public void excluir(Entidade emprestimo) {
		// TODO Auto-generated method stub
		EmprestimoEntidade t = (EmprestimoEntidade) emprestimo;
		System.out.println(t.getMatriculaAluno());
		for(int i =0 ; i < emprestimos.size(); i++) 
		{
			//EmprestimoEntidade p = (EmprestimoEntidade) k;
			if(emprestimos.get(i).matriculaAluno.equals(t.getMatriculaAluno())) 
			{
				emprestimos.remove(emprestimos.get(i));
			}
		}
		
	}
	@Override
	public void buscaPorId(int Id) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			if(e.getId().equals(Id)) {
				Visao visao;
				visao = fabrica.createVisao();
				visao.viewBusca(e);
				break;
			}
		}
	}
	@Override
	public void buscaPorString(String matricula) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			EmprestimoEntidade k = (EmprestimoEntidade) e;
			if(k.getMatriculaAluno().equals(matricula)) 
			{
				Visao visao;
				visao = fabrica.createVisao();
				visao.viewBusca(e);
				break;
			}
		}
	}
	@Override
	public void visualizar() {
		// TODO Auto-generated method stub
		Visao visao;
		visao = fabrica.createVisao();
		for (Entidade e : emprestimos) {
			visao.viewBusca(e);
		}
	}
	@Override
	public void carregarArquivo() throws IOException {
		LivroFabrica fabricaLiv = (LivroFabrica) Fabrica.getFactory("Livro");
		// TODO Auto-generated method stub
		if(arquivo.exists()) {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);		
			List<String> ids = new ArrayList<String>();
			EmprestimoEntidade emprestimo= (EmprestimoEntidade) fabrica.createEntidade();
			LivroEntidade Livro = (LivroEntidade) fabricaLiv.createEntidade();
			List<String> matriculaAlunos = new ArrayList<String>();
			
				while(br.ready()) 
				{
					String linha = br.readLine();
					
					//id
					if(linha.contains("~")) 
					{
						
						String array[] = linha.split("~");
						emprestimo= (EmprestimoEntidade) fabrica.createEntidade();
						emprestimo.setId(Integer.parseInt(array[1]));
						emprestimos.add(emprestimo);
					}
					//Nome do Livro
					if(linha.contains("&")) 
					{
						String array[] = linha.split("&");
						Livro = (LivroEntidade) fabricaLiv.createEntidade();
						Livro.setNomeLivro(array[1]);
						emprestimo.addLivro(Livro);
						
					}
					//Matricula do Aluno
					if(linha.contains("#")) 
					{
						String array[] = linha.split("#");
						emprestimo.setMatriculaAluno(array[1]);
						
					}
				}
			/*Integer tamanho = nomeLivros.size();
			
			
			for(int i = 0; i < tamanho; i++) {
				
				EmprestimoEntidade emprestimo = (EmprestimoEntidade) fabrica.createEntidade();
				
				emprestimo.setId(Integer.parseInt(ids.get(i)));
				emprestimo.setNomeLivro(nomeLivros.get(i));
				emprestimo.setMatriculaAluno(matriculaAlunos.get(i));
				emprestimos.add(emprestimo);
			}*/

			br.close();
			fr.close();
			arquivo.delete();
			
	}
  }
}
