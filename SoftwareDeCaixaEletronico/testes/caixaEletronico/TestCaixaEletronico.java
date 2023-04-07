package caixaEletronico;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.CaixaEletronico;

public class TestCaixaEletronico {
	
	ArrayList<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
	ServicoRemoto servicoRemotoMock;
	
	@Before
	public void inicializaContasCorrentesMocadas() {
		ContaCorrente conta1 = new ContaCorrente("12345678", (float) 100.5);
		ContaCorrente conta2 = new ContaCorrente("22345678", (float) 500.0);
		contasCorrentes.add(conta1);
		contasCorrentes.add(conta2);
		servicoRemotoMock = new ServicoRemotoMock();
		((ServicoRemotoMock) servicoRemotoMock).setContasCorrentes(contasCorrentes);
	}
	
	@Test
	public void loginComSucesso() {
		HardwareMock hardWareMock = new HardwareMock();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		assertEquals("Usuário Autenticado", caixa.logar()); 
	}
	
	@Test
	public void loginFalha() {
		HardwareMock hardWareMock = new HardwareMock();
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		assertEquals("Não foi possível autenticar o usuário", caixa.logar()); 
	}
	
	@Test
	public void consultaSaldo() {
		
		HardwareMock hardWareMock1 = new HardwareMock();
		hardWareMock1.setNumeroContaCartao("12345678");
		
		HardwareMock hardWareMock2 = new HardwareMock();
		hardWareMock2.setNumeroContaCartao("22345678");
		
		CaixaEletronico caixa1 = new CaixaEletronico(hardWareMock1, servicoRemotoMock);
		caixa1.logar();
		
		CaixaEletronico caixa2 = new CaixaEletronico(hardWareMock2, servicoRemotoMock);
		caixa2.logar();
		
		assertEquals("O saldo é R$100,50", caixa1.saldo()); 
		assertEquals("O saldo é R$500,00", caixa2.saldo()); 
	}
	
	
}