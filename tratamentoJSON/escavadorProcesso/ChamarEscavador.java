package escavadorProcesso;

import java.io.IOException;
import java.util.ArrayList;

import get.Get;
import tabelas.Escavador_usuario;

public class ChamarEscavador {
	Get get = new Get();
	public void receberAtualizacoes()
	{
		MonitoramentoDiario diario = new MonitoramentoDiario();
		try 
		{	
			
			ArrayList<Escavador_usuario> tabelaEscavador_usuario = get.Escavador_token(); //id - token
			for(int i=0;i<tabelaEscavador_usuario.size();i++)
			{
				Escavador_usuario local = tabelaEscavador_usuario.get(i);
				ArrayList<String>postCard = diario.monitoramentoDiario(local.getToken());
				System.out.println(postCard.get(i));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("erro");
		}
	}
//	public ArrayList<Escavador_usuario> recuperarTokens()
//	{
//		ReceberToken token = new ReceberToken();
//		try 
//		{
////			String tokenString = token.getToken(email, senha);
//			ArrayList<Escavador_usuario> tabelaEscavador_usuario = get.Escavador_token(); //id - token
//			return tabelaEscavador_usuario;
//		} catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
}
