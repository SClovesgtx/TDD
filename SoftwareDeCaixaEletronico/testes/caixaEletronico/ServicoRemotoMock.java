package caixaEletronico;

import java.util.ArrayList;

public class ServicoRemotoMock implements ServicoRemoto {
	
	ArrayList<ContaCorrente> contasCorrentes;

	@Override
	public ContaCorrente recuperarConta(String numeroDaConta) {
		for (ContaCorrente conta: contasCorrentes) {
			if (conta.getNumeroDaConta() == numeroDaConta)
				return conta;
		}
			
		return null;
	}

	@Override
	public void persistirConta(float valor) {
		// TODO Auto-generated method stub

	}

	public void setContasCorrentes(ArrayList<ContaCorrente> contasCorrentes) {
		this.contasCorrentes = contasCorrentes;
	}

}
