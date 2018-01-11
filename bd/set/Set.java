package set;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.BDConnection;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Escavador_usuario;
import tabelas.Usuario;

public class Set {
	public void Usuario(Usuario user,int id) throws Exception
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
	public void Escavador_usuario(Escavador_usuario movimentacao) throws Exception
	{		  
	 String sql = "INSERT INTO escavador_usuario(id_usuario,token,email,senha,chamadas_total,erros_total,minutos_salvos,antigas_movimentacoes) VALUES(?,?,?,?,?,?,?,?)";	 
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);
	 stmt.setInt(1, movimentacao.getId_usuario());
	 stmt.setString(2,movimentacao.getToken());
	 stmt.setString(3,movimentacao.getEmail());
	 stmt.setString(4,movimentacao.getSenha());
	 stmt.setInt(5,movimentacao.getChamadas_total());
	 stmt.setInt(6,movimentacao.getErros_total());
	 stmt.setInt(7,movimentacao.getMinutos_total());
	 stmt.setInt(8,movimentacao.getAntigasMovimentacoes());
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
//	}
	public static void main (String [] args)
	{
	}
}