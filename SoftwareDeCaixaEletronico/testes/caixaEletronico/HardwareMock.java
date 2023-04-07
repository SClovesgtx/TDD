package caixaEletronico;

public class HardwareMock implements Hardware {
	
	private String numeroContaCartao = "";

	@Override
	public String pegarNumeroDaContaCartao() throws ProblemaNoHardware {
		if (numeroContaCartao.length() == 0)
			throw new ProblemaNoHardware();
		return numeroContaCartao;
	}

	public void setNumeroContaCartao(String string) {
		numeroContaCartao = string;
	}

}
