import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCarrinhoCompras {

	@Test
	void totalCarrinho() {
		CarrinhoDeCompra c = new CarrinhoDeCompra();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObervador(mock);
		c.adionaProduto(new Produto("tenis", 100));
		c.adionaProduto(new Produto("camieta", 50));
		c.adionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}
	
	@Test
	void escutaAdicaoDeProduto() {
		CarrinhoDeCompra c = new CarrinhoDeCompra();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObervador(mock);
		c.adionaProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis", 100);
	}

}
