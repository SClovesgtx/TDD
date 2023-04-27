package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

public class Placar {

    private final Armazenamento armazenamento;

    public Placar(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void registrarPontos(String tipoDePontuacao, Long pontuacao, String nomeUsuario) throws FileNotFoundException, IOException, ParseException {
        armazenamento.armazenarPonto(tipoDePontuacao, pontuacao, nomeUsuario);
    }

    public Map<String, Long> pontosDoUsuario(String nomeUsuario) {
        Set<String> tiposPontuacoes = armazenamento.tiposPontuacoesRegistradas();
        Map<String, Long> pontos = new HashMap<>();
        for (String tipo : tiposPontuacoes) {
            Long pontosUsuario = armazenamento.recuperarPontos(tipo, nomeUsuario);
            if (pontosUsuario > 0) {
                pontos.put(tipo, pontosUsuario);
            }
        }
        return pontos;
    }

    public List<PontuacaoUsuario> ranking(String tipoDePontuacao) {
        Set<String> usuariosComPontuacao = armazenamento.usuariosComPontuacao();
        List<PontuacaoUsuario> ranking = usuariosComPontuacao.stream()
                .map(nomeUsuario -> new PontuacaoUsuario(tipoDePontuacao, armazenamento.recuperarPontos(tipoDePontuacao, nomeUsuario), nomeUsuario))
                .filter(up -> up.getPontuacao() > 0)
                .sorted((up1, up2) -> Long.compare(up2.getPontuacao(), up1.getPontuacao()))
                .collect(Collectors.toList());
        return ranking;
    }

}
