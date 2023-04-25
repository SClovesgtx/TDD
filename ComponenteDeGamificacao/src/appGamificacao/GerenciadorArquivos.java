package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface GerenciadorArquivos {
	public List<RegistroDePontuacao> lerArquivo() throws FileNotFoundException, IOException, ParseException;
	public List<RegistroDePontuacao> escreverArquivo() throws FileNotFoundException, IOException, ParseException;
	public List<RegistroDePontuacao> atualizarArquivo() throws FileNotFoundException, IOException, ParseException;
}
