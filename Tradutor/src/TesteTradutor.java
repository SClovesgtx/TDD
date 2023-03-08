import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteTradutor {

	@Test
	void tradutorSemPalavras() {
		Tradutor t = new Tradutor();
		assertTrue(t.estaVazio());
	}
	
	@Test
	void umaTraducao() {
		Tradutor t = new Tradutor();
		t.adicionaTraducao("bom", "good");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}

}
