import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteTradutor {
	
	private static Tradutor t;
	
	@BeforeEach
	public void criarTradutor() {
		t = new Tradutor();
	}

	@Test
	void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	void umaTraducao() {
		t.adicionaTraducao("bom", "good");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}
	
	@Test
	void duasTraducoes() {
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("mau", "bad");
		assertEquals("good", t.traduzir("bom"));
		assertEquals("bad", t.traduzir("mau"));
	}
	
	@Test
	void duasTraducoesMesmaPalavra() {
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		assertEquals("good, nice", t.traduzir("bom"));
	}
	
	@Test
	void traduzirFrase() {
		t.adicionaTraducao("guerra", "war");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("ruim", "bad");
		assertEquals("war is bad", t.traduzirFraze("guerra é ruim"));
	}

}
