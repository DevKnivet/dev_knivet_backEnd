package bdConnectionKnivetUmbler;

import java.sql.*;

public class BDConnection {
	
	//Usu�rio do BD
	private static final String USUARIO = "knivet";
	//Senha do BD
    private static final String SENHA = "knivet2017";
    //URL do BD (Site do umbler, link externo)
    private static final String URL = "jdbc:mysql://mysql762.umbler.com:41890/knivet";
    //Driver do MySQL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    //Abrir conex�o com o BD e acessar o mesmo
    public static Connection abrir() throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        //Essa � a vari�vel de comunica��o com o BD
        return conn;
    }
}
