package caixaEletronico;

public class HardwareMockSucesso implements Hardware {
	
	private String numeroContaCartao = "";

	@Override
	public String pegarNumeroDaContaCartao() throws ProblemaNoHardware {
		return numeroContaCartao;
	}

	public void setNumeroContaCartao(String string) {
		numeroContaCartao = string;
	}

	@Override
	public void entregarDinheiro() throws ProblemaNoHardware {
		// Não faz nada, está aqui apenas para atender interface	
	}

	@Override
	public void lerEnvelope() throws ProblemaNoHardware {
		// Não faz nada, está aqui apenas para atender interface
	}

}
