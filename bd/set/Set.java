package set;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import conexao.BDConnection;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Usuario;

public class Set {
	public void Usuario(Usuario user) throws Exception
	{		  	     
	 String sql = "INSERT INTO usuario(email,senha,usuario,emailRec) VALUES(?,?,?,?)";
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);	 
	 stmt.setString(1, user.getEmail());
	 stmt.setString(2, user.getSenha());
	 stmt.setString(3, user.getNomeUsr());
	 stmt.setString(4, user.getEmailRec());
	 stmt.execute();
	 stmt.close();	
	 conn.close();
	}
	public void Escavador_id_movimentacoes(Escavador_id_movimentacoes movimentacao) throws Exception
	{		  
	 String sql = "INSERT INTO escavador_movimentacoes_id(id_usuario,num_processo,num_movimentacao) VALUES(?,?,?)";    
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);
	 stmt.setInt(1, movimentacao.getId_usr());
	 stmt.setString(2, movimentacao.getNum_processo());
	 stmt.setInt(3, movimentacao.getNum_movimentacao());
	 stmt.execute();  
	 stmt.close();
	 conn.close();
	}
//	public void Escavador_usuario(Escavador_usuario movimentacao) throws Exception
//	{		  
//	 String sql = "INSERT INTO escavador_usuario(id_usuario,token,email,senha) VALUES(?,?,?,?)";    
//	 Connection conn = BDConnection.abrir();
//	 PreparedStatement stmt = conn.prepareStatement(sql);
//	 stmt.setInt(1, movimentacao.getId_usr());
//	 stmt.setString(2, movimentacao.getNum_processo());
//	 stmt.setInt(3, movimentacao.getNum_movimentacao());
//	 stmt.execute();  
//	 stmt.close();	
//	 conn.close();
//	}
	public static void main (String [] args) throws Exception
	{
		Set set = new Set();
		Usuario user = new Usuario();
		user.setEmail("teste@knivet.com");
		user.setEmailRec("dezembro@knivet.com");
		user.setNomeUsr("Dezembro");
		user.setSenha("123");
		set.Usuario(user);
	}
}