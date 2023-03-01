import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestePilha {
	
	private Pilha p;
	
	@BeforeEach
	public void inicializaPilha() {
		this.p = new Pilha(10);
	}

	@Test
	void pilhaVazia() {
		assertTrue(p.esta_vazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	void empilhaUmElemento() {
		p.empilha("primeiro");
		assertFalse(p.esta_vazia());
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
	}
	
	@Test
	void empilhaEDesempilha() {
		p.empilha("primeiro");
		p.empilha("segundo");
		assertEquals(2, p.tamanho());
		assertEquals("segundo", p.topo());
		Object desempilhado = p.desempilha();
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);
	}
	
	@Test
	public void removeDaPilhaVazia() {
		Throwable exception = assertThrows(PilhaVaziaException.class, () -> p.desempilha());
		assertEquals("Não é possível desempilhar.", exception.getMessage());
	}

}
