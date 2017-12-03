package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bdClasses.Knivet;
import bdConnectionKnivetUmbler.BDConnection;

public class GetUltimoPKKnivet_DAO {

	public int maiorPK() throws Exception {
	 	//Cria a conex�o com o BD (configurado em BDConnection)
        Connection conn = BDConnection.abrir();
        //Rodar script que ser� enviado para o banco de dados em SQL
        PreparedStatement comando = conn.prepareStatement("SELECT idknivet, email, senha, nomeUsr, emailRec FROM knivet ORDER BY idknivet ");
        //Receber o resultado do script enviado
        ResultSet resultado = comando.executeQuery();
        //Criar Array do tipo Knivet (com as mesmas vari�veis da tabela)
        ArrayList<Integer> pk = new ArrayList<Integer>();
        //Enquanto houver resultados a serem pesquisados fa�a...
        while (resultado.next()) {
            //Capturar os dados no seguinte modelo (vari�vel da Arrey . setVari�velASerPega (vari�vel da resposta do BD . get Tipo da Vari�vel a ser salva (" nome da coluna que salva essa vari�vel no BD "));
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
        //Fechar comunica��o (Para liberar memoria e num de usu�rios ativos para performance)
        conn.close();
        //Retornar lista de objetos Knivet com os dados
        return maiorPK;
    }
	
}
