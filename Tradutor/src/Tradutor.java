import java.util.HashMap;
import java.util.Map;

public class Tradutor {

	private Map<String, String> traducoes = new HashMap<>();
	
	public boolean estaVazio() {
		return traducoes.size()==0;
	}

	public void adicionaTraducao(String palavra, String traducao) {
		if(traducoes.containsKey(palavra))
			traducao = traduzir(palavra) + ", " + traducao;
		traducoes.put(palavra, traducao);
	}

	public Object traduzir(String palavra) {
		return traducoes.get(palavra);
	}

	public String traduzirFraze(String frase) {
		String[] palavras = frase.split(" ");
		String fraseTraduzida = "";
		for (String palavra : palavras) {
			String traducao = (String) traduzir(palavra);
			fraseTraduzida += " " + traducao;
		}
		return fraseTraduzida.trim();
	}

}
