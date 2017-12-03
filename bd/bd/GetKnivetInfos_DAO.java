package bd;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bdClasses.Knivet;
import bdConnectionKnivetUmbler.BDConnection;

public class GetKnivetInfos_DAO {

	 public ArrayList<Knivet> buscar() throws Exception {
		 	//Cria a conex�o com o BD (configurado em BDConnection)
	        Connection conn = BDConnection.abrir();
	        //Rodar script que ser� enviado para o banco de dados em SQL
	        PreparedStatement comando = conn.prepareStatement("SELECT idknivet, email, senha, nomeUsr, emailRec FROM knivet ORDER BY idknivet ");
	        //Receber o resultado do script enviado
	        ResultSet resultado = comando.executeQuery();
	        //Criar Array do tipo Knivet (com as mesmas vari�veis da tabela)
	        ArrayList<Knivet> lista = new ArrayList<Knivet>();
	        //Enquanto houver resultados a serem pesquisados fa�a...
	        while (resultado.next()) {
	        	//Criar uma vari�vel do tipo Knivet para ser adicionado no ArrayList ap�s salvar todos os dados
	            Knivet linha = new Knivet();
	            //Capturar os dados no seguinte modelo (vari�vel da Arrey . setVari�velASerPega (vari�vel da resposta do BD . get Tipo da Vari�vel a ser salva (" nome da coluna que salva essa vari�vel no BD "));
	            linha.setEmail(resultado.getString("email"));
	            linha.setEmailRec(resultado.getString("emailRec"));
	            linha.setIdknivet(resultado.getInt("idknivet"));
	            linha.setNomeUsr(resultado.getString("nomeUsr"));
	            linha.setSenha(resultado.getString("senha"));
	            //Adicionar a nova vari�vel do tipo Knivet na lista (que ser� retornada futuramente)
	            lista.add(linha);
	        }
	        
	        //Fechar o resultado
	        resultado.close();
	        //Fechar o script
	        comando.close();
	        //Fechar comunica��o (Para liberar memoria e num de usu�rios ativos para performance)
	        conn.close();
	        //Retornar lista de objetos Knivet com os dados
	        return lista;
	    }
}
