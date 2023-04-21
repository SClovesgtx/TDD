package appGamificacao;

public class RegistroDePontuacao {
	
	private String nomeUsuario;
	private String tipoDePontuacao;
	private Long pontuacao;
	
	public RegistroDePontuacao(String tipoDePontuacao, Long pontuacao, String nomeUsuario) {
		this.tipoDePontuacao = tipoDePontuacao;
		this.pontuacao = pontuacao;
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getTipoDePontuacao() {
		return tipoDePontuacao;
	}
	public void setTipoDePontuacao(String tipoDePontuacao) {
		this.tipoDePontuacao = tipoDePontuacao;
	}
	public Long getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}
}
