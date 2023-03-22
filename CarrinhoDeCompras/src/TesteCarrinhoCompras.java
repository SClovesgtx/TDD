import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCarrinhoCompras {

	@Test
	void totalCarrinho() {
		CarrinhoDeCompra c = new CarrinhoDeCompra();
		c.adionaProduto(new Produto("tenis", 100));
		c.adionaProduto(new Produto("camieta", 50));
		c.adionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}

}
