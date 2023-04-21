package appGamificacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class GerenciadorArquivosJson {
	
	private String caminhoParaOArquivoJson;
	
	public GerenciadorArquivosJson(String caminhoParaOArquivoJson) {
		this.caminhoParaOArquivoJson = caminhoParaOArquivoJson;
	}
	
	public List<RegistroDePontuacao> lerArquivo() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object jsonObj = parser.parse(new FileReader(caminhoParaOArquivoJson));
		JSONArray registrosDePontuacao = (JSONArray) jsonObj;
	    List<RegistroDePontuacao> registrosDePontuacaoParseados = new ArrayList<RegistroDePontuacao>();
	    for(int i = 0 ; i < registrosDePontuacao.size() ; i++){
	    	JSONObject registro = (JSONObject) registrosDePontuacao.get(i);
            String nomeUsuario = (String) registro.get("nomeUsuario");
            String tipoDePontuacao = (String) registro.get("tipoDePontuacao");
            Long pontuacao = (Long) registro.get("pontuacao");
            RegistroDePontuacao registroPontuacao = new RegistroDePontuacao(tipoDePontuacao, pontuacao, nomeUsuario);
    		registrosDePontuacaoParseados.add(registroPontuacao);
	    }
		return registrosDePontuacaoParseados;
	}
}
