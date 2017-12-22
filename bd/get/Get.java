package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.BDConnection;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Usuario;

public class Get {
	public ArrayList<Usuario> buscarUsuario() throws Exception 
	{
		//Cria a conex�o com o BD (configurado em BDConnection)
        Connection conn = BDConnection.abrir();
        //Rodar script que ser� enviado para o banco de dados em SQL
        PreparedStatement comando = conn.prepareStatement("SELECT id, email, senha, usuario, emailRec FROM usuario ORDER BY id");
        //Receber o resultado do script enviado
        ResultSet resultado = comando.executeQuery();
        //Criar Array do tipo Knivet (com as mesmas vari�veis da tabela)
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        //Enquanto houver resultados a serem pesquisados fa�a...
        while (resultado.next()) {
        	//Criar uma vari�vel do tipo Knivet para ser adicionado no ArrayList ap�s salvar todos os dados
            Usuario linha = new Usuario();
            //Capturar os dados no seguinte modelo (vari�vel da Arrey . setVari�velASerPega (vari�vel da resposta do BD . get Tipo da Vari�vel a ser salva (" nome da coluna que salva essa vari�vel no BD "));
            linha.setEmail(resultado.getString("email"));
            linha.setEmailRec(resultado.getString("emailRec"));
            linha.setId(resultado.getInt("id"));
            linha.setNomeUsr(resultado.getString("usr"));
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
	public ArrayList<Escavador_id_movimentacoes> buscarEscavador_Id_Movimentacoes() throws Exception
	{
		Connection conn = BDConnection.abrir();
		PreparedStatement comando = conn.prepareStatement("SELECT id_usuario, num_processo FROM escavador_movimentacoes_id ORDER BY id_usuario");
		ResultSet resultado = comando.executeQuery();
		ArrayList<Escavador_id_movimentacoes> lista = new ArrayList<Escavador_id_movimentacoes>();
		while (resultado.next()) {        	
            Escavador_id_movimentacoes linha = new Escavador_id_movimentacoes();
            linha.setId_usr(resultado.getInt("id_usuario"));
            linha.setNum_processo(resultado.getInt("num_processo"));
            lista.add(linha);
		}
		resultado.close();        
        comando.close();        
        conn.close();        
        return lista;	
	}
}
