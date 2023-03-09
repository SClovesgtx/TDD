import java.util.HashMap;
import java.util.Map;

public class Tradutor {

	private Map<String, String> traducoes = new HashMap<>();
	
	public boolean estaVazio() {
		return traducoes.size()==0;
	}

	public void adicionaTraducao(String palavra, String traducao) {
		this.traducoes.put(palavra, traducao);
	}

	public Object traduzir(String palavra) {
		return traducoes.get(palavra);
	}

}
