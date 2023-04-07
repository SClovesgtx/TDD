package caixaEletronico;

public class ContaCorrente {
	String numeroDaConta = "";
	float saldo = 0;
	
	public ContaCorrente(String numeroConta, float saldoConta) {
		numeroDaConta = numeroConta;
		saldo = saldoConta;
	}
	
	public String getNumeroDaConta() {
		return numeroDaConta;
	}
	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
