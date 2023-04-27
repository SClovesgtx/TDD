package appGamificacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class GerenciadorArquivosJson implements GerenciadorArquivos {
	
	private String caminhoParaOArquivoJson;
	
	public GerenciadorArquivosJson(String caminhoParaOArquivoJson) {
		this.caminhoParaOArquivoJson = caminhoParaOArquivoJson;
	}
	
	public List<PontuacaoUsuario> lerArquivo() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object jsonObj = parser.parse(new FileReader(caminhoParaOArquivoJson));
		JSONArray registrosDePontuacao = (JSONArray) jsonObj;
	    List<PontuacaoUsuario> registrosDePontuacaoParseados = parsearRegistrosDePontuacao(registrosDePontuacao);
		return registrosDePontuacaoParseados;
	}

	private List<PontuacaoUsuario> parsearRegistrosDePontuacao(JSONArray registrosDePontuacao) {
		List<PontuacaoUsuario> registrosDePontuacaoParseados = new ArrayList<PontuacaoUsuario>();
	    for(int i = 0 ; i < registrosDePontuacao.size() ; i++){
	    	JSONObject registro = (JSONObject) registrosDePontuacao.get(i);
            String nomeUsuario = (String) registro.get("nomeUsuario");
            String tipoDePontuacao = (String) registro.get("tipoDePontuacao");
            Long pontuacao = (Long) registro.get("pontuacao");
            PontuacaoUsuario registroPontuacao = new PontuacaoUsuario(tipoDePontuacao, pontuacao, nomeUsuario);
    		registrosDePontuacaoParseados.add(registroPontuacao);
	    }
		return registrosDePontuacaoParseados;
	}

	@Override
	public void atualizarArquivo(List<PontuacaoUsuario> registros) throws FileNotFoundException, IOException, ParseException {
		JSONArray jsonArray = new JSONArray();

        for (PontuacaoUsuario registro : registros) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nomeUsuario", registro.getNomeUsuario());
            jsonObject.put("tipoDePontuacao", registro.getTipoDePontuacao());
            jsonObject.put("pontuacao", registro.getPontuacao());
            jsonArray.add(jsonObject);
        }

        FileWriter fileWriter = new FileWriter(caminhoParaOArquivoJson);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.close();
	}
}
