package update;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.BDConnection;
import tabelas.Escavador_usuario;

public class Update {
	public void Escavador_usuario(Escavador_usuario movimentacao) throws Exception
	{		  
	 String sql = "UPDATE escavador_usuario SET token=?,email=?,senha=?,chamadas_total=?,erros_total=?,minutos_salvos=?,antigas_movimentacoes=? WHERE id_usuario=?";
	 Connection conn = BDConnection.abrir();
	 PreparedStatement stmt = conn.prepareStatement(sql);	 
	 stmt.setString(1,movimentacao.getToken());
	 stmt.setString(2,movimentacao.getEmail());
	 stmt.setString(3,movimentacao.getSenha());
	 stmt.setInt(4,movimentacao.getChamadas_total());
	 stmt.setInt(5,movimentacao.getErros_total());
	 stmt.setInt(6,movimentacao.getMinutos_total());
	 stmt.setInt(7,movimentacao.getAntigasMovimentacoes());
	 stmt.setInt(8, movimentacao.getId_usuario());
	 stmt.execute();  
	 stmt.close();	
	 conn.close();
	}
	public static void main (String[] args) throws Exception
	{
		Escavador_usuario movimentacao = new Escavador_usuario();
		movimentacao.setId_usuario(28);
		movimentacao.setToken("");
		movimentacao.setEmail("morg.guilherme@gmail.com");
		movimentacao.setSenha("AnnaBeth10");
		movimentacao.setChamadas_total(0);
		movimentacao.setErros_total(0);
		movimentacao.setMinutos_total(0);
		movimentacao.setAntigasMovimentacoes(1);
//		Escavador_usuario(movimentacao);
	}
}
