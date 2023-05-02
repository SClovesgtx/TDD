package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    
    public List<Map.Entry<String, Long>> ranking(String tipoDePontuacao) {
        Set<String> usuarios = armazenamento.usuariosComPontuacao();
        Map<String, Long> pontosPorUsuario = new HashMap<>();
        for (String usuario : usuarios) {
            Long pontos = armazenamento.recuperarPontos(tipoDePontuacao, usuario);
            if (pontos > 0) {
                pontosPorUsuario.put(usuario, pontos);
            }
        }
        return pontosPorUsuario.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toList());
    }



}
