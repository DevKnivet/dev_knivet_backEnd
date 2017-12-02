package mains_trello;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import trello.TrelloPostBoard;
import trello.TrelloPostList;
import trello.TrelloPostCard;

//https://api.trello.com/1/boards/?name=TesteLINKDireto&desc=FeitoAPartirDeLinkGTTP&prefs_permissionLevel=private&key=fae4acfcba958d16f9af4bef4f58156c&token=850099ea061f8e06087f2a3fa4b2281b

public class MAIN__TESTE_TRELLO {

	public static void main(String[] args) throws ClientProtocolException, IOException
	{		
		TrelloPostBoard postboard = new TrelloPostBoard();
		TrelloPostCard postcard = new TrelloPostCard();
		TrelloPostList postlist = new TrelloPostList();
		String idb;
		String idl;
		idb = postboard.PostBoard("Teste", "", "fae4acfcba958d16f9af4bef4f58156c", "b82e489a106bfe0032a01eb540b5f85b3a729d345a00f2b85ee633665f12c3f6");
		idl = postlist.PostList("TesteLista", idb, "fae4acfcba958d16f9af4bef4f58156c", "b82e489a106bfe0032a01eb540b5f85b3a729d345a00f2b85ee633665f12c3f6");
		postcard.PostCard("TesteCard", ":)", "", idl, "fae4acfcba958d16f9af4bef4f58156c", "b82e489a106bfe0032a01eb540b5f85b3a729d345a00f2b85ee633665f12c3f6");

	}
	
}
