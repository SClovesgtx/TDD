import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

	private List<Produto> itens = new ArrayList<>();
	private ObservadorCarrinho observer;
	
	public void adionaProduto(Produto p) {
		itens.add(p);
		this.observer.produtoAdicionado(p.getNome(), p.getValor());
	}
	
	public int total() {
		int total = 0;
		for(Produto p : itens)
			total += p.getValor();
		return total;
	}

	public void adicionarObervador(ObservadorCarrinho observador) {
		this.observer = observador;
	}
}
