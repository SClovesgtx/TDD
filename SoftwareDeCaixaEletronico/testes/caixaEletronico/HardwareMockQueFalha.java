package caixaEletronico;

public class HardwareMockQueFalha implements Hardware {

	private String numeroContaCartao = "";

	@Override
	public String pegarNumeroDaContaCartao() throws ProblemaNoHardware {
		if (numeroContaCartao.length() == 0)
			throw new ProblemaNoHardware();
		return numeroContaCartao;
	}

	@Override
	public void entregarDinheiro() throws ProblemaNoHardware {
		throw new ProblemaNoHardware();
	}

	@Override
	public void lerEnvelope() throws ProblemaNoHardware {
		throw new ProblemaNoHardware();
	}

	public void setNumeroContaCartao(String string) {
		numeroContaCartao = string;
	}

}
