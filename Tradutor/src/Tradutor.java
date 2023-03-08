import java.util.function.BooleanSupplier;

public class Tradutor {

	private String traducao;
	
	public boolean estaVazio() {
		return traducao==null;
	}

	public void adicionaTraducao(String palavra, String traducao) {
		this.traducao = traducao;
	}

	public Object traduzir(String palavra) {
		// TODO Auto-generated method stub
		return this.traducao;
	}

}
