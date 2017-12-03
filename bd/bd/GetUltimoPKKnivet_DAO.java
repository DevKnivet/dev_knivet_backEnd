package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bdClasses.Knivet;
import bdConnectionKnivetUmbler.BDConnection;

public class GetUltimoPKKnivet_DAO {

	public int maiorPK() throws Exception {
	 	//Cria a conexão com o BD (configurado em BDConnection)
        Connection conn = BDConnection.abrir();
        //Rodar script que será enviado para o banco de dados em SQL
        PreparedStatement comando = conn.prepareStatement("SELECT idknivet, email, senha, nomeUsr, emailRec FROM knivet ORDER BY idknivet ");
        //Receber o resultado do script enviado
        ResultSet resultado = comando.executeQuery();
        //Criar Array do tipo Knivet (com as mesmas variáveis da tabela)
        ArrayList<Integer> pk = new ArrayList<Integer>();
        //Enquanto houver resultados a serem pesquisados faça...
        while (resultado.next()) {
            //Capturar os dados no seguinte modelo (variável da Arrey . setVariávelASerPega (variável da resposta do BD . get Tipo da Variável a ser salva (" nome da coluna que salva essa variável no BD "));
            pk.add(resultado.getInt("idknivet"));
        }
        int maiorPK = 0;
        if(pk.size()>=1)
        {
        	maiorPK = pk.get(0);
        }        
        for(int i=0;i<pk.size();i++)
        {
        	  if(pk.get(i)>maiorPK)
        	  {
        		  maiorPK = pk.get(i);
        	  }
        }
        
        //Fechar o resultado
        resultado.close();
        //Fechar o script
        comando.close();
        //Fechar comunicação (Para liberar memoria e num de usuários ativos para performance)
        conn.close();
        //Retornar lista de objetos Knivet com os dados
        return maiorPK;
    }
	
}
