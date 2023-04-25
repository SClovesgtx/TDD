package appGamificacao;

import java.util.List;
import java.util.ArrayList;

public class Armazenamento {
	private static List<RegistroDePontuacao> registros = new ArrayList<RegistroDePontuacao>();
	private GerenciadorArquivos gerenciadorArquivoJson = new GerenciadorArquivosJson(
			"/home/cloves-paiva/Documentos/personal-projects/TDD/ComponenteDeGamificacao/src/appGamificacao/dadosDePontuacaoUsuario.json"
	);

	public Long recuperarPontos(String tipoDePontuacao, String nomeUsuario) {
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

	public void armazenarPonto(String tipoDePontuacao, Long pontuacao, String nomeUsuario) {
		registros.add(construaRegistro(tipoDePontuacao, pontuacao, nomeUsuario));
	}
	
	private Long somaTotalDePontosDoUsuario(String nomeUsuario, String tipoDePontuacao) {
		@SuppressWarnings("removal")
		Long pontuacaoTotal = new Long(0);
		for (RegistroDePontuacao registroPontuacao: registros) {
			if (registroPontuacao.getNomeUsuario() == nomeUsuario & registroPontuacao.getTipoDePontuacao() == tipoDePontuacao)
				pontuacaoTotal += registroPontuacao.getPontuacao();
		}
		return pontuacaoTotal;
	}
	
	private RegistroDePontuacao construaRegistro(String tipoDePontuacao, Long pontuacao, String nomeUsuario) {
		RegistroDePontuacao registroPontuacao = new RegistroDePontuacao(tipoDePontuacao, pontuacao, nomeUsuario);
		return registroPontuacao;
	}

	public static List<RegistroDePontuacao> getRegistros() {
		return registros;
	}

	public static void setRegistros(List<RegistroDePontuacao> registros) {
		Armazenamento.registros = registros;
	}
}
