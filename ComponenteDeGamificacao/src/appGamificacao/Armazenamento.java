package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.json.simple.parser.ParseException;

public interface Armazenamento {

	void armazenarPonto(String tipoDePontuacao, Long pontuacao, String nomeUsuario)
			throws FileNotFoundException, IOException, ParseException;

	Long recuperarPontos(String tipoDePontuacao, String nomeUsuario);

	Set<String> usuariosComPontuacao();

	Set<String> tiposPontuacoesRegistradas();

}