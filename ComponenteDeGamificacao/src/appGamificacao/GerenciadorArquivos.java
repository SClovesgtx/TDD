package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface GerenciadorArquivos {
	public List<PontuacaoUsuario> lerArquivo() throws FileNotFoundException, IOException, ParseException;
	public void atualizarArquivo(List<PontuacaoUsuario> registros) throws FileNotFoundException, IOException, ParseException;
}
