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
		//Cria a conexão com o BD (configurado em BDConnection)
        Connection conn = BDConnection.abrir();
        //Rodar script que será enviado para o banco de dados em SQL
        PreparedStatement comando = conn.prepareStatement("SELECT id, email, senha, usuario, emailRec FROM usuario ORDER BY id");
        //Receber o resultado do script enviado
        ResultSet resultado = comando.executeQuery();
        //Criar Array do tipo Knivet (com as mesmas variáveis da tabela)
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        //Enquanto houver resultados a serem pesquisados faça...
        while (resultado.next()) {
        	//Criar uma variável do tipo Knivet para ser adicionado no ArrayList após salvar todos os dados
            Usuario linha = new Usuario();
            //Capturar os dados no seguinte modelo (variável da Arrey . setVariávelASerPega (variável da resposta do BD . get Tipo da Variável a ser salva (" nome da coluna que salva essa variável no BD "));
            linha.setEmail(resultado.getString("email"));
            linha.setEmailRec(resultado.getString("emailRec"));
            linha.setId(resultado.getInt("id"));
            linha.setNomeUsr(resultado.getString("usr"));
            linha.setSenha(resultado.getString("senha"));
            //Adicionar a nova variável do tipo Knivet na lista (que será retornada futuramente)
            lista.add(linha);
        }
        
        //Fechar o resultado
        resultado.close();
        //Fechar o script
        comando.close();
        //Fechar comunicação (Para liberar memoria e num de usuários ativos para performance)
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
