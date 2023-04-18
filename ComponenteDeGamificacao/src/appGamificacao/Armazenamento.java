package appGamificacao;

import java.util.List;
import java.util.ArrayList;

public class Armazenamento {
	private static List<RegistroDePontuacao> registros = new ArrayList<RegistroDePontuacao>();

	public Integer recuperarPontos(String tipoDePontuacao, String nomeUsuario) {
		return somaTotalDePontosDoUsuario(nomeUsuario, tipoDePontuacao);
	}

	public List<String> usuariosComPontuacao() {
		List<String> usuarios = new ArrayList<String>();
		for (RegistroDePontuacao registroPontuacao: registros) {
			if (!usuarios.contains(registroPontuacao.getNomeUsuario()))
				usuarios.add(registroPontuacao.getNomeUsuario());
		}
		return usuarios;
	}

	public List<String> tiposPontuacoesRegistradas() {
		List<String> pontuacoesRegistradas = new ArrayList<String>();
		for (RegistroDePontuacao registroPontuacao: registros) {
			if (!pontuacoesRegistradas.contains(registroPontuacao.getTipoDePontuacao()))
				pontuacoesRegistradas.add(registroPontuacao.getTipoDePontuacao());
		}
		return pontuacoesRegistradas;
	}

	public void armazenarPonto(String tipoDePontuacao, int pontuacao, String nomeUsuario) {
		registros.add(construaRegistro(tipoDePontuacao, pontuacao, nomeUsuario));
	}
	
	private Integer somaTotalDePontosDoUsuario(String nomeUsuario, String tipoDePontuacao) {
		Integer pontuacaoTotal = 0;
		for (RegistroDePontuacao registroPontuacao: registros) {
			if (registroPontuacao.getNomeUsuario() == nomeUsuario & registroPontuacao.getTipoDePontuacao() == tipoDePontuacao)
				pontuacaoTotal += registroPontuacao.getPontuacao();
		}
		return pontuacaoTotal;
	}
	
	private RegistroDePontuacao construaRegistro(String tipoDePontuacao, int pontuacao, String nomeUsuario) {
		RegistroDePontuacao registroPontuacao = new RegistroDePontuacao();
		registroPontuacao.setTipoDePontuacao(tipoDePontuacao);
		registroPontuacao.setPontuacao(pontuacao);
		registroPontuacao.setNomeUsuario(nomeUsuario);
		return registroPontuacao;
	}
}
