package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bdClasses.Knivet;
import bdClasses.KnivetByte;
import bdConnectionKnivetUmbler.BDConnection;

public class SetKnivetInfos_DAO {

	public void adiciona(Knivet knivet,int maiorPK) throws Exception{  
        String sql = "INSERT INTO knivet(idknivet,email,senha,nomeUsr,emailRec) VALUES(?,?,?,?,?)";    
        Connection conn = BDConnection.abrir();
        PreparedStatement stmt = conn.prepareStatement(sql);
        String maiorPK_S = String.valueOf(maiorPK+1);
        stmt.setString(1, maiorPK_S);
        stmt.setString(2, knivet.getEmail());
        stmt.setString(3, knivet.getSenha());
        stmt.setString(4, knivet.getNomeUsr());
        stmt.setString(5, knivet.getEmailRec());  
        stmt.execute();  
        stmt.close(); 
	}	
}
