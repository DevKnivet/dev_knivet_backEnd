package escavadorProcesso;

import get.Get;
import outputs.trello.TrelloExistenteList;
import outputs.trello.TrelloGetMemberID;
import outputs.trello.TrelloPostBoard;
import outputs.trello.TrelloPostCard;
import outputs.trello.TrelloPostExistingBoard;
import outputs.trello.TrelloPostList;
import outputs.trello.TrelloTokenKey;

public class ChamarTrello {
	
	
	public void postTrello(String nomeCard, String descCard, int idUsuario) throws Exception{
		
		Get get = new Get();
		TrelloTokenKey tokenKey = get.getTokenKey(18);
//		TrelloTokenKey tokenKey = get.getTokenKey(idUsuario);
		TrelloGetMemberID getMember = new TrelloGetMemberID();
		String memberId = getMember.getMemberId(tokenKey.getToken(), tokenKey.getKey());
		TrelloPostExistingBoard boardExistente = new TrelloPostExistingBoard();
		String board = boardExistente.ProcurarBoardExistente(tokenKey.getKey(), tokenKey.getToken(), memberId, "Knivet - MVP");
						
		if(board.equals("board não encontrada")){
			TrelloPostBoard postBoard = new TrelloPostBoard();
			String idNewBoard = postBoard.PostBoard("Knivet - MVP","Trello MVP da Plataforma Knivet", tokenKey.getKey(), tokenKey.getToken());			
			TrelloPostList postList = new TrelloPostList();
			String idNewList = postList.PostList("Knivet - New Cards",  idNewBoard, tokenKey.getKey(), tokenKey.getToken());
			TrelloPostCard postCard = new TrelloPostCard();
			postCard.PostCard(nomeCard, descCard, idNewList,  tokenKey.getKey(), tokenKey.getToken());
						
		}else{
			String list = new TrelloExistenteList().getIdList(tokenKey.getKey(), tokenKey.getToken(),"Knivet - New Cards" , board);
			if(list.equals("list não encontrada")){
				TrelloPostList postList = new TrelloPostList();
				String idNewList = postList.PostList("Knivet - New Cards",board, tokenKey.getKey(), tokenKey.getToken());
				TrelloPostCard postCard = new TrelloPostCard();
				postCard.PostCard(nomeCard, descCard, idNewList,  tokenKey.getKey(), tokenKey.getToken());
			}else{
				TrelloPostCard postCard = new TrelloPostCard();
				postCard.PostCard(nomeCard, descCard, list,  tokenKey.getKey(), tokenKey.getToken());
			}
									
		}
		
	}

}
