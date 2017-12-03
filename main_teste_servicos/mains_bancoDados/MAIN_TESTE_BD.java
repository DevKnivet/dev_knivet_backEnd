package mains_bancoDados;

import java.sql.SQLException;
import java.util.ArrayList;

import bd.GetKnivetInfos_DAO;
import bd.GetUltimoPKKnivet_DAO;
import bd.SetKnivetInfos_DAO;
import bdClasses.Knivet;
import bdConnectionKnivetUmbler.BDConnection;

public class MAIN_TESTE_BD {

	public static void main (String[] args) throws Exception
	{
		//Criar classe do tipo que se comunica pedindo os dados da tabela Knivet
		GetKnivetInfos_DAO tabelaKnivetDAO = new GetKnivetInfos_DAO();
		//Criar arrayList do tipo Knivet para receber o retorno da busca da tabela
		ArrayList<Knivet> knivet = tabelaKnivetDAO.buscar();
		//Andar por todos os objetos na lista pegando os dados
		SetKnivetInfos_DAO insertTabelaKnivetDAO = new SetKnivetInfos_DAO();
		Knivet knivetC = new Knivet();
		knivetC.setEmail("joao.pedro.dezembro@uol.com.br");
		knivetC.setEmailRec("dezembro@knivet.com.br");
		knivetC.setNomeUsr("João Pedro Dezembro");
		knivetC.setSenha("knivet2017");
		GetUltimoPKKnivet_DAO ultimoPK = new GetUltimoPKKnivet_DAO();
		int maiorPK = ultimoPK.maiorPK();
		insertTabelaKnivetDAO.adiciona(knivetC, maiorPK);
		
		for(int i=0;i<knivet.size();i++)
		{
			//Pegar id (PrimaryKey)
			int id = knivet.get(i).getIdknivet();
			//Pegar Nome do usuario e outras infos)
			String email = knivet.get(i).getEmail();
			String senha = knivet.get(i).getSenha();
			String nomeUsr = knivet.get(i).getNomeUsr();
			String emailRec = knivet.get(i).getEmailRec();
			//Print de teste para saber que funciona
			System.out.println(id+" - "+nomeUsr+" - "+email+" - "+senha+" - "+emailRec);
		}
		
	}
		
}
