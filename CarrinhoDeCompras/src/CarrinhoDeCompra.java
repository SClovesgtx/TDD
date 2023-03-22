import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

	private List<Produto> itens = new ArrayList<>();
	
	public void adionaProduto(Produto p) {
		itens.add(p);
	}
	
	public int total() {
		int total = 0;
		for(Produto p : itens)
			total += p.getValor();
		return total;
	}
}
