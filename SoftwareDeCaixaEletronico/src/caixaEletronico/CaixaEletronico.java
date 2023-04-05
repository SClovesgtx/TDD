package caixaEletronico;

public class CaixaEletronico {
	
	private static Hardware hardware;
	private String numeroDaContaDoCartao;
	
	public CaixaEletronico(Hardware hard) {
		hardware = hard;
	}
	
	public String logar() {
		try {
			numeroDaContaDoCartao = hardware.pegarNumeroDaContaCartao();
			return "Usuário Autenticado";
		} catch (ProblemaNoHardware e) {
			return "Não foi possível autenticar o usuário";
		}
	}
}
