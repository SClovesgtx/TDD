package appGamificacao;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Armazenamento {
	private static List<RegistroDePontuacao> registros = new ArrayList<RegistroDePontuacao>();

	public Integer recuperarPontos(String nomeUsuario, String tipoDePontuacao) {
		Integer pontuacaoTotal = 0;
		for (RegistroDePontuacao registroPontuacao: registros) {
			if (registroPontuacao.getNomeUsuario() == nomeUsuario & registroPontuacao.getTipoDePontuacao() == tipoDePontuacao)
				pontuacaoTotal += registroPontuacao.getPontuacao();
		}
		return pontuacaoTotal;
	}

	public List<String> usuariosComPontuacao() {
		List<String> usuarios = Arrays.asList("Cloves", "Guerra", "Dani", "Alex");
		return usuarios;
	}

	public List<String> tiposPontuacoesRegistradas() {
		List<String> pontuacoesRegistradas = Arrays.asList("moeda", "estrela");
		return pontuacoesRegistradas;
	}

	public void armazenarPonto(String tipoDePontuacao, int pontuacao, String nomeUsuario) {
		RegistroDePontuacao registroPontuacao = new RegistroDePontuacao();
		registroPontuacao.setTipoDePontuacao(tipoDePontuacao);
		registroPontuacao.setPontuacao(pontuacao);
		registroPontuacao.setNomeUsuario(nomeUsuario);
		registros.add(registroPontuacao);
	}
}
