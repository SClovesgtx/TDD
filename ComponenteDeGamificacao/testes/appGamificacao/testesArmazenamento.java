package appGamificacao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class testesArmazenamento {

	@Test
	public void metodoRecuperarPontosRetornaInteiroPositivo() {
		Armazenamento armazenador = new Armazenamento();
		armazenador.armazenarPonto("estrela", 5, "guerra");
		armazenador.armazenarPonto("estrela", 15, "guerra");
		assertEquals((Integer)20, armazenador.recuperarPontos("estrela", "guerra"));
		assertTrue((Integer)0 <= armazenador.recuperarPontos("estrela", "guerra"));
	}
	
	@Test
	public void metodoUsuariosComPontuacaoRetornaListaUsuarios() {
		Armazenamento armazenador = new Armazenamento();
		List<String> usuariosComPontuacao = Arrays.asList("Cloves", "Guerra", "Dani", "Alex");
		assertEquals(usuariosComPontuacao, armazenador.usuariosComPontuacao());
	}
	
	@Test
	public void metodoTiposPontuacoesRegistradasRetornaListaDeTiposDePontuacaoRegistradas() {
		Armazenamento armazenador = new Armazenamento();
		List<String> pontuacoesRegistradas = Arrays.asList("moeda", "estrela");
		assertEquals(pontuacoesRegistradas, armazenador.tiposPontuacoesRegistradas());
	}

}
