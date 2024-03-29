package appGamificacao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
 
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class testesArmazenamento {
	
	private Armazenamento armazenador = new ArnazenadorDePontuacoes();

	@Before
	public void inicializaArmazenador() {
		
		PontuacaoUsuario r1 = new PontuacaoUsuario("estrela", (long) 5, "Guerra");
		PontuacaoUsuario r2 = new PontuacaoUsuario("moeda", (long) 15, "Guerra");
		PontuacaoUsuario r3 = new PontuacaoUsuario("estrela", (long) 10, "Cloves");
		PontuacaoUsuario r4 = new PontuacaoUsuario("moeda", (long) 40, "Dani");
		PontuacaoUsuario r5 = new PontuacaoUsuario("curtida", (long) 7, "Alex");
		
		List<PontuacaoUsuario> registros = new ArrayList<PontuacaoUsuario>();
		registros.add(r1);
		registros.add(r2);
		registros.add(r3);
		registros.add(r4);
		registros.add(r5);
		
		ArnazenadorDePontuacoes.setRegistros(registros);
	}

	@SuppressWarnings("removal")
	@Test
	public void metodoRecuperarPontosRetornaLongPositivo() {
		assertEquals(new Long(5), armazenador.recuperarPontos("estrela", "Guerra"));
		assertTrue(new Long(0) <= armazenador.recuperarPontos("estrela", "Guerra"));
	}
	
	@Test
	public void metodoUsuariosComPontuacaoRetornaListaUsuarios() {
		Set<String>usuariosComPontuacao = new HashSet<>(Arrays.asList("Guerra", "Cloves", "Dani", "Alex"));
		assertEquals(usuariosComPontuacao, armazenador.usuariosComPontuacao());
	}
	
	@Test
	public void metodoTiposPontuacoesRegistradasRetornaListaDeTiposDePontuacaoRegistradas() {
		Set<String> pontuacoesRegistradas = new HashSet<>(Arrays.asList("estrela", "moeda", "curtida"));
		assertEquals(pontuacoesRegistradas, armazenador.tiposPontuacoesRegistradas());
	}
	
	@Test
	public void conteudoRegistradoEmArquivoJSONEstaNaClasseArmazenamento() throws FileNotFoundException, IOException, ParseException {
		String caminhoParaOArquivoJson = "/home/cloves-paiva/Documentos/personal-projects/TDD/ComponenteDeGamificacao/src/appGamificacao/dadosDePontuacaoUsuario.json";
		GerenciadorArquivosJson gerenciadorDeArquivosJson = new GerenciadorArquivosJson(caminhoParaOArquivoJson);
		List<PontuacaoUsuario> pontuacoesRegistradasNoArquivo = gerenciadorDeArquivosJson.lerArquivo();
		List<PontuacaoUsuario> pontuacoesRegistradasNaClasse = ArnazenadorDePontuacoes.getRegistros();
		assertEquals(pontuacoesRegistradasNaClasse.size(), pontuacoesRegistradasNoArquivo.size());
		for(Integer i=0; i < pontuacoesRegistradasNaClasse.size(); i++) {
			PontuacaoUsuario r1 = pontuacoesRegistradasNaClasse.get(i);
			PontuacaoUsuario r2 = pontuacoesRegistradasNoArquivo.get(i);
			assertEquals(r1.getNomeUsuario(), r2.getNomeUsuario());
			assertEquals(r1.getPontuacao(), r2.getPontuacao());
			assertEquals(r1.getTipoDePontuacao(), r2.getTipoDePontuacao());
		}
	}
	
	@Test
	public void aoAdicionarNovasPontuacoesNaClasseArmazenamentoOArquivoSeraAtualizado() throws FileNotFoundException, IOException, ParseException {
		String caminhoParaOArquivoJson = "/home/cloves-paiva/Documentos/personal-projects/TDD/ComponenteDeGamificacao/src/appGamificacao/dadosDePontuacaoUsuario.json";
		armazenador.armazenarPonto("moeda", (long) 590, "Milene");
		List<PontuacaoUsuario> pontuacoesRegistradasNaClasse = ArnazenadorDePontuacoes.getRegistros();
		GerenciadorArquivosJson gerenciadorDeArquivosJson = new GerenciadorArquivosJson(caminhoParaOArquivoJson);
		List<PontuacaoUsuario> pontuacoesRegistradasNoArquivo = gerenciadorDeArquivosJson.lerArquivo();
		assertEquals(pontuacoesRegistradasNaClasse.size(), pontuacoesRegistradasNoArquivo.size());
		for(Integer i=0; i < pontuacoesRegistradasNaClasse.size(); i++) {
			PontuacaoUsuario r1 = pontuacoesRegistradasNaClasse.get(i);
			PontuacaoUsuario r2 = pontuacoesRegistradasNoArquivo.get(i);
			assertEquals(r1.getNomeUsuario(), r2.getNomeUsuario());
			assertEquals(r1.getPontuacao(), r2.getPontuacao());
			assertEquals(r1.getTipoDePontuacao(), r2.getTipoDePontuacao());
		}
	}

}
