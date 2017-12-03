package rsa;

public class EspacoBranco {
	public String tirarEspacos(String texto)
	{
		String[] textoArray = texto.split(" ");
		int primeiroEsp = 0;
		String saida = "";
		for(int i=textoArray.length-1;i>=0;i--){
			if(textoArray[i].equals(" "))
			{
				System.out.println("Espaço em branco");
			}
			else
			{
				primeiroEsp = i;
				break;
			}
		for(int j=0;j<=primeiroEsp;j++)
		{
			saida = saida + textoArray[j];
		}
		}
		return saida;
	}
	
	public static void main (String[] args)
	{
		EspacoBranco e = new EspacoBranco();
		System.out.println(e.tirarEspacos("A B C"));
	}
}
