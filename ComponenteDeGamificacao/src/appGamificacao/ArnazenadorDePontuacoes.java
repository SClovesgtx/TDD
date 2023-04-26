package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;

public class ArnazenadorDePontuacoes implements Armazenamento {

    private static final String JSON_FILE_PATH = "/home/cloves-paiva/Documentos/personal-projects/TDD/ComponenteDeGamificacao/src/appGamificacao/dadosDePontuacaoUsuario.json";

    private static final GerenciadorArquivos gerenciadorArquivoJson = new GerenciadorArquivosJson(JSON_FILE_PATH);

    private final static List<RegistroDePontuacao> registros = new ArrayList<>();

    @Override
	public void armazenarPonto(String tipoDePontuacao, Long pontuacao, String nomeUsuario)
            throws FileNotFoundException, IOException, ParseException {
        registros.add(new RegistroDePontuacao(tipoDePontuacao, pontuacao, nomeUsuario));
        gerenciadorArquivoJson.atualizarArquivo(registros);
    }

    @Override
	public Long recuperarPontos(String tipoDePontuacao, String nomeUsuario) {
        return registros.stream()
                .filter(r -> r.getTipoDePontuacao().equals(tipoDePontuacao) && r.getNomeUsuario().equals(nomeUsuario))
                .mapToLong(RegistroDePontuacao::getPontuacao)
                .sum();
    }

    @Override
	public Set<String> usuariosComPontuacao() {
        Set<String> usuarios = new HashSet<>();
        registros.forEach(r -> usuarios.add(r.getNomeUsuario()));
        return usuarios;
    }

    @Override
	public Set<String> tiposPontuacoesRegistradas() {
        Set<String> tiposPontuacoes = new HashSet<>();
        registros.forEach(r -> tiposPontuacoes.add(r.getTipoDePontuacao()));
        return tiposPontuacoes;
    }

    public static void setRegistros(List<RegistroDePontuacao> registros) {
        ArnazenadorDePontuacoes.registros.clear();
        ArnazenadorDePontuacoes.registros.addAll(registros);
        try {
            gerenciadorArquivoJson.atualizarArquivo(registros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<RegistroDePontuacao> getRegistros() {
        return new ArrayList<>(registros);
    }

}
