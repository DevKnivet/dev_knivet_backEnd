package digestoData4;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
public class DataDigesto4 {
	public ArrayList<Data4> data(JSONArray dataArray)
	{
		ArrayList<Data4> data = new ArrayList<Data4>();
		ArrayList<Anexos> anexos = new ArrayList<Anexos>();
		ArrayList<Movs> movs = new ArrayList<Movs>();
		ArrayList<Parte> partes = new ArrayList<Parte>();
		ArrayList<Advogado> advogados = new ArrayList<Advogado>();
		System.out.println(dataArray.length());
		for(int i=0;i<dataArray.length();i++)
		{		
			JSONObject dataObj = new JSONObject();
			dataObj = dataArray.getJSONObject(i);
			Data4 dataClasse = new Data4();
			dataClasse.setRegional_cnj(dataObj.optBoolean("regional_cnj"));
			dataClasse.setNumero(dataObj.optString("numeroAlternativo"));
			JSONArray anexosArray = dataObj.getJSONArray("anexos");
			for(int j=0;j<anexosArray.length();j++)
			{				
				JSONArray anexosObj = new JSONArray();
				anexosObj = anexosArray.getJSONArray(j);				
				Anexos anexosClasse = new Anexos();
				anexosClasse.setIdAnexo(anexosObj.optInt(0));
				anexosClasse.setEndDown(anexosObj.optString(1));
				anexosClasse.setTipoAnexo(anexosObj.optInt(2));
				anexosClasse.setData(anexosObj.optString(3));
				anexosClasse.setConteudo(anexosObj.optString(4));
				anexosClasse.setDataObt(anexosObj.optString(5));
				anexosClasse.setIdMov(anexosObj.optInt(6));
				anexosClasse.setTitulo(anexosObj.optString(7));
				anexos.add(anexosClasse);				
			}
			dataClasse.setAnexos(anexos);
			dataClasse.setVara(dataObj.optInt("vara"));
			dataClasse.setClasseNatureza(dataObj.optString("classeNatureza"));
			JSONArray movsArray = dataObj.getJSONArray("movs");
			for(int k=0;k<movsArray.length();k++)
			{				
				JSONArray movsObj = new JSONArray();
				movsObj = movsArray.getJSONArray(k);				
				Movs movsClasse = new Movs();
				movsClasse.setData(movsObj.optString(0));
				movsClasse.setTipo(movsObj.optString(1));
				movsClasse.setTexto(movsObj.optString(2));
				movsClasse.setNomeJuiz(movsObj.optString(3));
				movsClasse.setIdInterno(movsObj.optString(4));
				movsClasse.setTipoInteligente(movsObj.optString(5));
				movsClasse.setSubTipoInteligente(movsObj.optString(6));	
				movs.add(movsClasse);		
			}			
			dataClasse.setMovs(movs);
			dataClasse.setDistribuicaoTipo(dataObj.optString("distribuicaoTipo"));
			dataClasse.setSituacao(dataObj.optString("situacao"));
			dataClasse.setJuiz(dataObj.optString("juiz"));
			dataClasse.setArea(dataObj.optString("area"));
			dataClasse.setAssuntoExtra(dataObj.optString("assuntoExtra"));
//			dataClasse.setAudiencias(audiencias);
			dataClasse.setVara_original(dataObj.optString("vara_original"));
			dataClasse.setExtinto(dataObj.optInt("extinto"));
			dataClasse.setValor(dataObj.optInt("valor"));
			dataClasse.setAlteradoEm(dataObj.optString("alteradoEm"));
			dataClasse.setFonte_sistema(dataObj.optString("fonte_sistema"));
			dataClasse.setForo(dataObj.optString("foro"));
			dataClasse.setSituacao_situacaoID(dataObj.optInt("situacao_situacaoID"));
			dataClasse.setInstancia(dataObj.optInt("instancia"));
			dataClasse.setSentencaData(dataObj.optString("sentencaData"));
			dataClasse.setNumero(dataObj.optString("numero"));
//			Customs
			dataClasse.setFlag(dataObj.optInt("flag"));
			dataClasse.setComarca_cnj(dataObj.optString("comarca_cnj"));
			dataClasse.setComarca(dataObj.optString("comarca"));
			dataClasse.setTribunalID(dataObj.optInt("tribunalID"));
			dataClasse.setForo_cnj(dataObj.optString("foro_cnj"));
			dataClasse.setTribunal(dataObj.optString("tribunal"));
			dataClasse.setProcessoID(dataObj.optInt("processoID"));
			dataClasse.setDistribuiçãoData(dataObj.optString("distribuicaoData"));
			dataClasse.setArquivado(dataObj.optBoolean("arquivado"));
//			Classes
			dataClasse.setAcessos(dataObj.optString("acessos"));
			dataClasse.setUf(dataObj.optString("uf"));
			dataClasse.setCriadoEm(dataObj.optString("criadoEm"));
			
			JSONArray partesArray = dataObj.getJSONArray("partes");			
			for(int l=0;l<partesArray.length();l++)
			{				
				JSONArray partesObj = new JSONArray();
				partesObj = partesArray.getJSONArray(l);				
				Parte partesClasse = new Parte();
				partesClasse.setIdParticipacao(partesObj.optInt(0));
				partesClasse.setIdParte(partesObj.optInt(1));
				partesClasse.setNome(partesObj.optString(2));
				partesClasse.setNomeNormalizado(partesObj.optString(3));
				partesClasse.setCnpj(partesObj.optInt(4));
				partesClasse.setCpf(partesObj.optInt(5));
				partesClasse.setDocFormatado(partesObj.optString(6));
				partesClasse.setParteRelacaoID(partesObj.optInt(7));
				partesClasse.setRelacaoNorm(partesObj.optString(8));
				JSONArray advogadosArray = partesObj.getJSONArray(9);
				for(int m=0;m<advogadosArray.length();m++)
				{
					JSONArray advogadosObj = new JSONArray();
					advogadosObj = advogadosArray.getJSONArray(m);				
					Advogado advogadoClasse = new Advogado();
					advogadoClasse.setAdvogadoId(advogadosObj.optString(0));
					advogadoClasse.setNome(advogadosObj.optString(1));
					advogadoClasse.setOab(advogadosObj.optString(2));
					advogadoClasse.setCpf(advogadosObj.optString(3));
					advogadoClasse.setUf(advogadosObj.optString(4));
					advogados.add(advogadoClasse);
				}
				partesClasse.setAdvogados(advogados);
				partesClasse.setParteAut(partesObj.optBoolean(10));
				partesClasse.setParteCo(partesObj.optBoolean(11));
				partesClasse.setParteRe(partesObj.optBoolean(12));
				partesClasse.setParteNeutra(partesObj.optBoolean(13));
				partesClasse.setCepPart(partesObj.optInt(14));
				partesClasse.setIdEntidade(partesObj.optInt(15));
				partesClasse.setParteFisica(partesObj.optBoolean(16));
				partes.add(partesClasse);		
			}
			dataClasse.setPartes(partes);		
			data.add(dataClasse);			
		}
		return data;		
	}
}
