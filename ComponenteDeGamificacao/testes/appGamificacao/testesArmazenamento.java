package appGamificacao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class testesArmazenamento {
	
	private Armazenamento armazenador;

	@Before
	public void inicializaArmazenador() {
		armazenador = new Armazenamento();
		armazenador.armazenarPonto("estrela", 5, "Guerra");
		armazenador.armazenarPonto("moeda", 15, "Guerra");
		armazenador.armazenarPonto("estrela", 10, "Cloves");
		armazenador.armazenarPonto("moeda", 40, "Dani");
		armazenador.armazenarPonto("curtida", 7, "Alex");
	}

	@Test
	public void metodoRecuperarPontosRetornaInteiroPositivo() {
		assertEquals((Integer)5, armazenador.recuperarPontos("estrela", "Guerra"));
		assertTrue((Integer)0 <= armazenador.recuperarPontos("estrela", "guerra"));
	}
	
	@Test
	public void metodoUsuariosComPontuacaoRetornaListaUsuarios() {
		List<String> usuariosComPontuacao = Arrays.asList("Guerra", "Cloves", "Dani", "Alex");
		assertEquals(usuariosComPontuacao, armazenador.usuariosComPontuacao());
	}
	
	@Test
	public void metodoTiposPontuacoesRegistradasRetornaListaDeTiposDePontuacaoRegistradas() {
		List<String> pontuacoesRegistradas = Arrays.asList("estrela", "moeda", "curtida");
		assertEquals(pontuacoesRegistradas, armazenador.tiposPontuacoesRegistradas());
	}

}
