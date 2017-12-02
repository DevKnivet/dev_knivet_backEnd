package mains_bancoDados;

import java.sql.SQLException;
import java.util.ArrayList;

import bd.Knivet;
import bd.KnivetDAO;
import bdConnectionKnivetUmbler.BDConnection;

public class MAIN_TESTE_BD {

	public static void main (String[] args) throws Exception
	{
		//Criar classe do tipo que se comunica pedindo os dados da tabela Knivet
		KnivetDAO tabelaKnivetDAO = new KnivetDAO();
		//Criar arrayList do tipo Knivet para receber o retorno da busca da tabela
		ArrayList<Knivet> knivet = tabelaKnivetDAO.buscar();
		//Andar por todos os objetos na lista pegando os dados
		for(int i=0;i<knivet.size();i++)
		{
			//Pegar id (PrimaryKey)
			int id = knivet.get(i).getIdknivet();
			//Pegar Nome do usuario)
			String nome = knivet.get(i).getNomeUsr();
			//Print de teste para saber que funciona
			System.out.println(id+" "+nome);
		}
		
	}
		
}
