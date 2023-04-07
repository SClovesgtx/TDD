package caixaEletronico;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numeroDaConta);
	public void persistirConta(float valor);
}
