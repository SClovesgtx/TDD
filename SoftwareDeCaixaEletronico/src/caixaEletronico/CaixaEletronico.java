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

	public String sacar(int valorASerSacado) throws ProblemaNoHardware {
		try {
			ContaCorrente conta = servicoRemoto.recuperarConta(numeroDaConta);
			float valorRestanteNaConta = conta.getSaldo() - valorASerSacado;
			if (valorRestanteNaConta < 0)
				return "Saldo insuficiente";
			hardware.entregarDinheiro();
			conta.persistirConta(valorRestanteNaConta);
			return "Retire seu dinheiro";
		} catch (ProblemaNoHardware e) {
			return "Não foi possível realizar a retirada do dinehiro neste caixa. Pedimos desculpas pelo transtorno.";
		}
	}

	public String depositar(float valorASerDepositado) {
		try {
			ContaCorrente conta = servicoRemoto.recuperarConta(numeroDaConta);
			float valorAtualNaConta = conta.getSaldo() + valorASerDepositado;
			hardware.lerEnvelope();
			conta.persistirConta(valorAtualNaConta);
			return "Depósito recebido com sucesso";
		} catch (Exception e) {
			return "Não foi possível fazer seu depósito. Retire seu envelope!";
		}
	}
}
