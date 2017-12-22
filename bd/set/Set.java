package set;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.BDConnection;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Usuario;

public class Set {
	public void setUsuario(Usuario user,int id) throws Exception
	{		  
	 String sql = "INSERT INTO usuario(id,email,senha,usuario,emailRec) VALUES(?,?,?,?,?)";    
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);
	 String maiorPK_S = String.valueOf(id+1);
	 stmt.setString(1, maiorPK_S);
	 stmt.setString(2, user.getEmail());
	 stmt.setString(3, user.getSenha());
	 stmt.setString(4, user.getNomeUsr());
	 stmt.setString(5, user.getEmailRec());  
	 stmt.execute();  
	 stmt.close();		
	}
	public void setEscavador_id_movimentacoes(Escavador_id_movimentacoes movimentacao ,int id) throws Exception
	{		  
	 String sql = "INSERT INTO escavador_movimentacoes_id(id_usuario,num_processo) VALUES(?,?)";    
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);
	 String maiorPK_S = String.valueOf(id+1);
	 stmt.setString(1, maiorPK_S);
	 stmt.setInt(2, movimentacao.getNum_processo());
	 stmt.execute();  
	 stmt.close();		
	}
}