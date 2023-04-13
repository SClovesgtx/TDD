package caixaEletronico;

public interface Hardware {
	public String pegarNumeroDaContaCartao() throws ProblemaNoHardware;
	public void entregarDinheiro() throws ProblemaNoHardware;
	public void lerEnvelope() throws ProblemaNoHardware;
	public void setNumeroContaCartao(String string);
}
