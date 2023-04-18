package appGamificacao;

public class RegistroDePontuacao {
	
	private String nomeUsuario;
	private String tipoDePontuacao;
	private Integer pontuacao;
	
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
	public Integer getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
}
