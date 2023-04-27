package appGamificacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;

public class MockArmazenadorDePontuacoes implements Armazenamento {
	
	private final static  List<PontuacaoUsuario> registros = new ArrayList<>();
	
	@Override
	public void armazenarPonto(String tipoDePontuacao, Long pontuacao, String nomeUsuario)
			throws FileNotFoundException, IOException, ParseException {
		registros.add(new PontuacaoUsuario(tipoDePontuacao, pontuacao, nomeUsuario));
	}

	@Override
	public Long recuperarPontos(String tipoDePontuacao, String nomeUsuario) {
		return registros.stream()
                .filter(r -> r.getTipoDePontuacao().equals(tipoDePontuacao) && r.getNomeUsuario().equals(nomeUsuario))
                .mapToLong(PontuacaoUsuario::getPontuacao)
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
	
	public void setRegistros(List<PontuacaoUsuario> registros) {
		MockArmazenadorDePontuacoes.registros.clear();
		MockArmazenadorDePontuacoes.registros.addAll(registros);
    }

}
