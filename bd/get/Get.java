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
import tabelas.Chamadas_feitas_temp;

public class Get {
	public ArrayList<Usuario> Usuario() throws Exception 
	{		
        Connection conn = BDConnection.abrir();     
        PreparedStatement comando = conn.prepareStatement("SELECT id, email, senha, usuario, emailRec,automacoes_ativas,automacoes_max,num_automatizacoes_total,minutos_salvos_total,erros_total FROM usuario ORDER BY id");        
        ResultSet resultado = comando.executeQuery();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        while (resultado.next()) {
            Usuario linha = new Usuario();
            linha.setEmail(resultado.getString("email"));
            linha.setEmailRec(resultado.getString("emailRec"));
            linha.setId(resultado.getInt("id"));
            linha.setNomeUsr(resultado.getString("usuario"));
            linha.setSenha(resultado.getString("senha"));
            linha.setAutomacoes_ativas(resultado.getInt("automacoes_ativas"));
            linha.setAutomacoes_max(resultado.getInt("automacoes_max"));
            linha.setNum_automatizacoes_total(resultado.getInt("num_automatizacoes_total"));
            linha.setMinutos_salvos_total(resultado.getInt("minutos_salvos_total"));
            linha.setErros_total(resultado.getInt("erros_total"));
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
	
	
	public ArrayList<Chamadas_feitas_temp>  Chamadas_feitas_temp() throws Exception{
		Connection conn = BDConnection.abrir();
		PreparedStatement comando = conn.prepareStatement("SELECT id_usuario, vl1, vl2, vl3, vl4, vl5, vl6, vl7, alterado FROM chamadas_feitas_temp ORDER BY id_usuario");
		ResultSet resultado = comando.executeQuery();		
		ArrayList<Chamadas_feitas_temp> lista = new ArrayList<Chamadas_feitas_temp>();
		while (resultado.next()) {     
			Chamadas_feitas_temp temp = new Chamadas_feitas_temp();
			temp.setId_usuario(resultado.getInt("id_usuario"));
			temp.setVl1(resultado.getInt("vl1"));
			temp.setVl2(resultado.getInt("vl2"));
			temp.setVl3(resultado.getInt("vl3"));
			temp.setVl4(resultado.getInt("vl4"));
			temp.setVl5(resultado.getInt("vl5"));
			temp.setVl6(resultado.getInt("vl6"));
			temp.setV7(resultado.getInt("vl7"));
			temp.setAlterado(resultado.getString("alterado"));
			lista.add(temp);
		}
		resultado.close();        
        comando.close();        
        conn.close();
		return lista;
	}
	
}
