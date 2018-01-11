package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.BDConnection;
import outputs.trello.TrelloTokenKey;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Escavador_usuario;
import tabelas.Usuario;

public class Get {
	public ArrayList<Usuario> Usuario() throws Exception 
	{		
        Connection conn = BDConnection.abrir();     
        PreparedStatement comando = conn.prepareStatement("SELECT id, email, senha, usuario, emailRec FROM usuario ORDER BY id");        
        ResultSet resultado = comando.executeQuery();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        while (resultado.next()) {
            Usuario linha = new Usuario();
            linha.setEmail(resultado.getString("email"));
            linha.setEmailRec(resultado.getString("emailRec"));
            linha.setId(resultado.getInt("id"));
            linha.setNomeUsr(resultado.getString("usr"));
            linha.setSenha(resultado.getString("senha"));
            lista.add(linha);
        }
        resultado.close();
        comando.close();
        conn.close();
        return lista;
	}	
	public ArrayList<Escavador_id_movimentacoes> Escavador_Id_Movimentacoes() throws Exception
	{
		Connection conn = BDConnection.abrir();
		PreparedStatement comando = conn.prepareStatement("SELECT id_usuario, num_processo, num_movimentacao FROM escavador_movimentacoes_id ORDER BY id_usuario");
		ResultSet resultado = comando.executeQuery();
		ArrayList<Escavador_id_movimentacoes> lista = new ArrayList<Escavador_id_movimentacoes>();
		while (resultado.next()) {        	
            Escavador_id_movimentacoes linha = new Escavador_id_movimentacoes();
            linha.setId_usr(resultado.getInt("id_usuario"));
            linha.setNum_processo(resultado.getString("num_processo"));
            linha.setNum_movimentacao(resultado.getInt("num_Movimentacao"));
            lista.add(linha);
		}
		resultado.close();        
        comando.close();        
        conn.close();        
        return lista;	
	}
	public ArrayList<Escavador_usuario> Escavador_token() throws Exception
	{
		Connection conn = BDConnection.abrir();
		PreparedStatement comando = conn.prepareStatement("SELECT id_usuario, token, email, senha, chamadas_total, erros_total, minutos_salvos ,antigas_movimentacoes FROM escavador_usuario ORDER BY id_usuario");
		ResultSet resultado = comando.executeQuery();
		ArrayList<Escavador_usuario> lista = new ArrayList<Escavador_usuario>();
		while (resultado.next()) {        	
			Escavador_usuario linha = new Escavador_usuario();
            linha.setId_usuario(resultado.getInt("id_usuario"));
            linha.setToken(resultado.getString("token"));
            linha.setEmail(resultado.getString("email"));
            linha.setSenha(resultado.getString("senha"));
            linha.setChamadas_total(resultado.getInt("chamadas_total"));
            linha.setErros_total(resultado.getInt("erros_total"));
            linha.setMinutos_total(resultado.getInt("minutos_salvos"));
            linha.setAntigasMovimentacoes(resultado.getInt("antigas_movimentacoes"));
            lista.add(linha);
		}
		resultado.close();        
        comando.close();        
        conn.close();        
        return lista;
	}
	 
	public TrelloTokenKey getTokenKey(int id_usuario) throws Exception{
		
		
		
		Connection conn = BDConnection.abrir();
		PreparedStatement comando = conn.prepareStatement("SELECT id_usuario, KeyT, token FROM trello_usuario WHERE id_usuario = "+id_usuario);
		ResultSet resultado = comando.executeQuery();
		TrelloTokenKey trello = new TrelloTokenKey();
		while (resultado.next()) {     
			trello.setToken(resultado.getString("token"));
			trello.setKey(resultado.getString("KeyT"));			
		}
		resultado.close();        
        comando.close();        
        conn.close();
		return trello;
		
	}
	
	
}
