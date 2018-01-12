package escavadorProcesso;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import get.Get;
import set.Set;
import tabelas.Chamadas_feitas_temp;
import tabelas.Escavador_id_movimentacoes;
import tabelas.Escavador_usuario;
import tabelas.Usuario;
import update.Update;


public class ChamarEscavador {
	Get get = new Get();
	Set set = new Set();
	Update update = new Update();
	ArrayList<CardSaida> cardTotal = new ArrayList<CardSaida>();
	public ArrayList<CardSaida> receberAtualizacoes()
	{
		MonitoramentoDiario diario = new MonitoramentoDiario();		
		try 
		{	
			
			ArrayList<Escavador_usuario> tabelaEscavador_usuario =get.Escavador_token(); //id - token
			ArrayList<Escavador_id_movimentacoes> movimentacoes = get.Escavador_Id_Movimentacoes();
			ArrayList<Integer> idDiario = new ArrayList<Integer>();
			ArrayList<Integer> idDiarioDiferente = new ArrayList<Integer>();
			AparicoesProcesso aparicoes = new AparicoesProcesso();
			MovimentacaoProcesso processo = new MovimentacaoProcesso();
//			ArrayList<CardTrelloEscavador> card = new ArrayList<CardTrelloEscavador>();
			Escavador_id_movimentacoes movimentacao = new Escavador_id_movimentacoes();			
			System.out.println("Usuários cadastrados -> "+tabelaEscavador_usuario.size());
			System.out.println("------------------------------------------------------------------------------------------------------------");
			for(int i=0;i<tabelaEscavador_usuario.size();i++)
			{				
				ArrayList<CardTrelloEscavador> card = new ArrayList<CardTrelloEscavador>();
				Escavador_usuario local = tabelaEscavador_usuario.get(i);
				ReceberToken token = new ReceberToken();
				local.setToken(token.getToken(local.getEmail(),local.getSenha()));
				idDiario = (diario.monitoramentoDiario(local.getToken()));
				
				System.out.println(i+" -> Email cadastrado -> "+local.getEmail());
				System.out.println(i+" -> id do usuário -> "+local.getId_usuario());
				System.out.println("------------------------------------------------------------------------------------------------------------");
				
				for(int k=0;k<idDiario.size();k++)
				{
//					idDiarioDiferente.add(idDiario.get(k));						
					ArrayList<Integer> IdAparicoes = aparicoes.getAparicoesMonitoramento(tabelaEscavador_usuario.get(i).getToken(), idDiario.get(k));
					for(int l=0;l<IdAparicoes.size();l++)
					{
						
						card.add(processo.getMovimentacao(tabelaEscavador_usuario.get(i).getToken(), IdAparicoes.get(l)));
						
																		
						System.out.println("------------------------------------------------------------------------------------------------------------");
					}					
//					set.Escavador_id_movimentacoes(movimentacao);
					System.out.println("------------------------------------------------------------------------------------------------------------");
				}
//				for(int k=0;k<card.size();k++)
//				{
//					boolean salvo = false;
//					for(int l=0;l<movimentacoes.size();l++)
//					{
//						if(card.get(k).getIdMovimentacao() == movimentacoes.get(l).getNum_movimentacao())
//						{
//							salvo = true;
//							break;
//						}
//					}
//					if(salvo == false)
//					{
//						movimentacao.setId_usr(tabelaEscavador_usuario.get(i).getId_usuario());
//						movimentacao.setNum_movimentacao(card.get(k).getIdMovimentacao());
//						movimentacao.setNum_processo(card.get(k).getProcesso());
//						set.Escavador_id_movimentacoes(movimentacao);
//						//Enviar p trello
//					}					
//				}				
				CardSaida cardTratamento = new CardSaida();
				cardTratamento.setCard(card);
				cardTratamento.setId_usuario(local.getId_usuario());
				cardTotal.add(cardTratamento);								
			}
			return cardTotal;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("erro");
		}
		return null;
	}
	
	public ArrayList<CardSaida> verificarExistenciaBD(ArrayList<CardSaida> cardsEntrada)
	{	
		try 
		{	
			ArrayList<Escavador_id_movimentacoes> movimentacoes = get.Escavador_Id_Movimentacoes();
			ArrayList<CardSaida> movimentacoesExistentes = new ArrayList<CardSaida>();
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("CardsEntrada Size -> "+cardsEntrada.size());
			for(int i=0;i<cardsEntrada.size();i++)
			{
				int id = cardsEntrada.get(i).getId_usuario();
				System.out.println("CardsEntrada ("+i+") Size -> "+cardsEntrada.get(i).getCard().size());
				for(int j=0;j<cardsEntrada.get(i).getCard().size();j++)
				{
					for(int l=0;l<movimentacoes.size();l++)
					{
						if(movimentacoes.get(l).getId_usr() == id)
						{
							
							System.out.println("Comparando card de entrada da mov -> "+cardsEntrada.get(i).getCard().get(j).getIdMovimentacao()+" com movimentação de número "+movimentacoes.get(l).getNum_movimentacao()+" do usuário -> "+id);
							if(cardsEntrada.get(i).getCard().get(j).getIdMovimentacao() == movimentacoes.get(l).getNum_movimentacao())
							{
								CardTrelloEscavador repetido = new CardTrelloEscavador("");
								repetido = cardsEntrada.get(i).getCard().get(j);
								ArrayList<CardTrelloEscavador> aux = new ArrayList<>();
								aux.add(repetido);
								CardSaida cardAux = new CardSaida();
								cardAux.setCard(aux);
								cardAux.setId_usuario(id);
								movimentacoesExistentes.add(cardAux);
							}
						}
					}
				}
			}			
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println("Total de movimentações já existentes -> "+movimentacoesExistentes.size());
			for(int i=0;i<movimentacoesExistentes.size();i++)
			{
				System.out.println("Id do usuario -> "+movimentacoesExistentes.get(i).getId_usuario()+" / id da movimentação -> "+movimentacoesExistentes.get(i).getCard().get(0).getIdMovimentacao());
			}
			System.out.println("------------------------------------------------------------------------------------------------------------");
			return movimentacoesExistentes;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<CardSaida> retirarDuplicados(ArrayList<CardSaida> cardTotal, ArrayList<CardSaida> cardExistente)
	{
		for(int i=0;i<cardTotal.size();i++)
		{
			for(int j=0;j<cardExistente.size();j++)
			{
				if(cardTotal.get(i).getId_usuario() == cardExistente.get(j).getId_usuario())
				{
					for(int l=0;l<cardTotal.get(i).getCard().size();l++)
					{
						if(cardTotal.get(i).getCard().get(l).getIdMovimentacao() == cardExistente.get(j).getCard().get(0).getIdMovimentacao())
						{
							cardTotal.get(i).getCard().remove(l);
						}
					}					
				}
			}
		}
		
		for(int i=0;i<cardTotal.size();i++)
		{
			System.out.println("Número de cards ainda não existentes no BD do id ("+i+") -> "+cardTotal.get(i).getCard().size());
		}
		return cardTotal;
	}
	
	public void adicionarMovimentacaoBD(ArrayList<CardSaida> cardsNovos)
	{
		System.out.println("Adicionando movimentações ao BD");
		try 
		{
			ArrayList<Usuario> usuario = get.Usuario();
			ArrayList<Escavador_usuario> tabelaEscavador_usuario = get.Escavador_token();			
			int antigas_movimentacoes = 1;
			int id_na_tabela = 0;
			for(int i=0;i<cardsNovos.size();i++)
			{
				for(int k=0;k<tabelaEscavador_usuario.size();k++)
				{
					
					if(tabelaEscavador_usuario.get(k).getId_usuario() == cardsNovos.get(i).getId_usuario())
					{
						System.out.println("Id na tabela escavador ("+tabelaEscavador_usuario.get(k).getId_usuario()+") -> Id do card a ser salvo ("+cardsNovos.get(i).getId_usuario()+")");
						antigas_movimentacoes = tabelaEscavador_usuario.get(k).getAntigasMovimentacoes();
						id_na_tabela = tabelaEscavador_usuario.get(k).getId_usuario();
					}
				}
				
				for(int j=0;j<cardsNovos.get(i).getCard().size();j++)
				{
					Escavador_id_movimentacoes movimentacao = new Escavador_id_movimentacoes();
					movimentacao.setId_usr(cardsNovos.get(i).getId_usuario());
					movimentacao.setNum_movimentacao(cardsNovos.get(i).getCard().get(j).getIdMovimentacao());
					movimentacao.setNum_processo(cardsNovos.get(i).getCard().get(j).getProcesso());
					System.out.println("Adicionando ao BD nova movimentação de usuário ("+movimentacao.getId_usr()+") com o número da movimentação -> "+movimentacao.getNum_movimentacao());
					if(antigas_movimentacoes == 1)
					{			
						System.out.println("Antigas movimentações = 1");
						System.out.println("Usuario vai adicionar Card");
						try {
							
							for(int k=0;k<usuario.size();k++)
							{
								System.out.println("Ids na Tabela ("+usuario.get(k).getId()+") -> local ("+id_na_tabela+")");
								if(usuario.get(k).getId() == id_na_tabela)
								{
									System.out.println("Usuário reuperado ("+usuario.get(k).getId()+")");
									for(int l=0;l<tabelaEscavador_usuario.size();l++)
									{	
										if(tabelaEscavador_usuario.get(l).getId_usuario() == id_na_tabela)
										{
											System.out.println("Usuario Escavador Recuperado");
											ArrayList<Chamadas_feitas_temp> chamadasTemp = get.Chamadas_feitas_temp();
											for(int m=0;m<chamadasTemp.size();m++)
											{
												System.out.println(id_na_tabela+" -> "+chamadasTemp.get(m).getId_usuario());
												if(id_na_tabela == chamadasTemp.get(m).getId_usuario())
												{
													System.out.println("Enviando ao Trello o novo Card");
													Escavador_usuario esc_usuario = tabelaEscavador_usuario.get(l);
													esc_usuario.setChamadas_total(esc_usuario.getChamadas_total() + 1);
													esc_usuario.setMinutos_total(esc_usuario.getMinutos_total() + 10);
													update.Escavador_usuario(esc_usuario);
													ChamarTrello chamarTrello = new ChamarTrello();													
													set.Escavador_id_movimentacoes(movimentacao);
													usuario.get(k).setMinutos_salvos_total(usuario.get(k).getMinutos_salvos_total() + 10);
													usuario.get(k).setNum_automatizacoes_total(usuario.get(k).getNum_automatizacoes_total() + 1);
													update.Usuario(usuario.get(k));
													chamarTrello.postTrello(cardsNovos.get(i).getCard().get(j).getTitulo(), cardsNovos.get(i).getCard().get(j).getDescricao(), cardsNovos.get(i).getId_usuario());
													System.out.println("Chamadas -> "+chamadasTemp.get(m).getVl1());
													chamadasTemp.get(m).setVl1(chamadasTemp.get(m).getVl1()+1);
													update.Chamadas_feitas_temp(chamadasTemp.get(m));
													System.out.println("Nova chamadas ->"+chamadasTemp.get(m).getVl1());
													System.out.println("------------------------------------------------------------------------------------------------------------");
												}
											}
										}
									}
								}
							}
							
							
						} catch (Exception e) {					
							e.printStackTrace();
						}
					}
					if(antigas_movimentacoes == 0)
					{			
						System.out.println("Antigas movimentações = 0");
						try {							
							set.Escavador_id_movimentacoes(movimentacao);
//							tabelaEscavador_usuario.get(id_na_tabela).setAntigasMovimentacoes(antigasMovimentacoes);
							System.out.println("Id na tabela = "+id_na_tabela);
							for(int k=0;k<tabelaEscavador_usuario.size();k++)
							{
								if(tabelaEscavador_usuario.get(k).getId_usuario() == id_na_tabela)
								{
									System.out.println("Usuario encontrado na tabela escavador usuario");
									ArrayList<Chamadas_feitas_temp> chamadasTemp = get.Chamadas_feitas_temp();
									for(int l=0;i<chamadasTemp.size();l++)
									{
										if(id_na_tabela == chamadasTemp.get(l).getId_usuario())
										{
											System.out.println("Usuario encontrado na tabela chamdas temp");
											Escavador_usuario usuarioUpdate = tabelaEscavador_usuario.get(k);
											usuarioUpdate.setAntigasMovimentacoes(1);
											update.Escavador_usuario(usuarioUpdate);
											chamadasTemp.get(l).setVl1(chamadasTemp.get(l).getVl1()+1);
											update.Chamadas_feitas_temp(chamadasTemp.get(l));
											System.out.println("------------------------------------------------------------------------------------------------------------");
										}
									}
								}
							}
							
							
						} catch (Exception e) {					
							e.printStackTrace();
						}
					}
					
				}
			}
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		}		
	}
	
//	public void adicionarMovimentacaoPrimeiraVez(ArrayList<CardSaida> cardsNovos)
//	{
//		for(int i=0;i<cardsNovos.size();i++)
//		{
//			for(int j=0;j<cardsNovos.get(i).getCard().size();j++)
//			{
//				Escavador_id_movimentacoes movimentacao = new Escavador_id_movimentacoes();
//				movimentacao.setId_usr(cardsNovos.get(i).getId_usuario());
//				movimentacao.setNum_movimentacao(cardsNovos.get(i).getCard().get(j).getIdMovimentacao());
//				movimentacao.setNum_processo(cardsNovos.get(i).getCard().get(j).getProcesso());
//				System.out.println("Adicionando ao BD nova movimentação de usuário ("+movimentacao.getId_usr()+") com o número da movimentação -> "+movimentacao.getNum_movimentacao());
//				try {
//					set.Escavador_id_movimentacoes(movimentacao);					
//				} catch (Exception e) {					
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	public void antigas_movs()
	{
		try 
		{
			ArrayList<Escavador_usuario> tabelaEscavador_usuario = get.Escavador_token();
			for(int i=0;i<tabelaEscavador_usuario.size();i++)
			{				
				if(tabelaEscavador_usuario.get(i).getAntigasMovimentacoes() == 0)
				{
					tabelaEscavador_usuario.get(i).setAntigasMovimentacoes(1);
					update.Escavador_usuario(tabelaEscavador_usuario.get(i));
					System.out.println("Usuário ("+tabelaEscavador_usuario.get(i).getId_usuario()+") não possui nenhuma movimentação e está como adicionar antigas movimentações. Abortando e atualizando para como adicionado");
				}
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void estatistica()
	{
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		Locale brasil = new Locale("pt", "BR");
		String dayName = dow.getDisplayName(TextStyle.FULL, brasil);
		dayName = dayName.toLowerCase();
		System.out.println(dayName);
		try {
			ArrayList<Chamadas_feitas_temp> chamadas = get.Chamadas_feitas_temp();
			for(int i=0;i<chamadas.size();i++)
			{
				if(chamadas.get(i).getAlterado() != dayName)
				{					
					chamadas.get(i).setV7(chamadas.get(i).getVl6());
					chamadas.get(i).setVl6(chamadas.get(i).getVl5());
					chamadas.get(i).setVl5(chamadas.get(i).getVl4());
					chamadas.get(i).setVl4(chamadas.get(i).getVl3());
					chamadas.get(i).setVl3(chamadas.get(i).getVl2());
					chamadas.get(i).setVl2(chamadas.get(i).getVl1());
					chamadas.get(i).setVl1(0);
					chamadas.get(i).setAlterado(dayName);
					update.Chamadas_feitas_temp(chamadas.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run ()
	{
		ChamarEscavador teste = new ChamarEscavador();
		teste.estatistica();
		ArrayList<CardSaida> cards = teste.receberAtualizacoes();
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Usuários totais com movimentações -> "+cards.size());
		System.out.println("------------------------------------------------------------------------------------------------------------");
		ArrayList<CardSaida> cardExistentes = teste.verificarExistenciaBD(cards);
		ArrayList<CardSaida> cardsNovos = teste.retirarDuplicados(cards, cardExistentes);
		teste.adicionarMovimentacaoBD(cardsNovos);
		teste.antigas_movs();
	}
	
	public static void main (String [] args)
	{
		ChamarEscavador teste = new ChamarEscavador();
		teste.run();
//		teste.estatistica();
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
