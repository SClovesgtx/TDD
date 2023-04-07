package caixaEletronico;

public class CaixaEletronico {
	
	private Hardware hardware;
	private String numeroDaConta;
	private ServicoRemoto servicoRemoto;
	
	public CaixaEletronico(Hardware hard, ServicoRemoto servico) {
		hardware = hard;
		servicoRemoto = servico;
	}
	
	public String logar() {
		try {
			numeroDaConta = hardware.pegarNumeroDaContaCartao();
			return "Usuário Autenticado";
		} catch (ProblemaNoHardware e) {
			return "Não foi possível autenticar o usuário";
		}
	}

	public String saldo() {
		ContaCorrente conta = servicoRemoto.recuperarConta(numeroDaConta);
		return String.format("O saldo é R$%.2f", conta.getSaldo());
	}
}
