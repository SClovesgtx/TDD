package appGamificacao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
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
		assertTrue((Integer)0 <= armazenador.recuperarPontos("estrela", "Guerra"));
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
	
	@Test
	public void conteudoEstaSendoRegistradoEmArquivoJSON() throws FileNotFoundException, IOException, ParseException {
		List<RegistroDePontuacao> pontuacoesRegistradas = this.lerArquivoJson();
		assertEquals(pontuacoesRegistradas, armazenador.getRegistros());
	}
	
	@SuppressWarnings("unused")
	private List<RegistroDePontuacao> lerArquivoJson() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		ArrayList<RegistroDePontuacao> json = (ArrayList) parser.parse(new FileReader("/home/cloves-paiva/Documentos/personal-projects/TDD/ComponenteDeGamificacao/src/appGamificacao/dadosDePontuacaoUsuario.json"));
	    List<RegistroDePontuacao> result = new ArrayList<RegistroDePontuacao>();
	    for(int i = 0 ; i < json.size() ; i++){
//	    	JSONObject jsonObject = (JSONObject) json.get(i);
//            String nomeUsuario = (String) jsonObject.get("nomeUsuario");
//            String tipoDePontuacao = (String) jsonObject.get("tipoDePontuacao");
//            Integer pontuacao = (Integer) jsonObject.get("pontuacao");
//            RegistroDePontuacao registroPontuacao = new RegistroDePontuacao();
//    		registroPontuacao.setTipoDePontuacao(tipoDePontuacao);
//    		registroPontuacao.setPontuacao(pontuacao);
//    		registroPontuacao.setNomeUsuario(nomeUsuario);
	        result.add(json.get(i));
	    }
		return result;
	}

}
