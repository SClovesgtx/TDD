package caixaEletronico;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
		Hardware hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		assertEquals("Usuário Autenticado", caixa.logar()); 
	}
	
	@Test
	public void loginFalha() {
		Hardware hardWareMock = new HardwareMockQueFalha();
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		assertEquals("Não foi possível autenticar o usuário", caixa.logar()); 
	}
	
	@Test
	public void consultaSaldo() {
		
		Hardware hardWareMock1 = new HardwareMockSucesso();
		hardWareMock1.setNumeroContaCartao("12345678");
		
		Hardware hardWareMock2 = new HardwareMockSucesso();
		hardWareMock2.setNumeroContaCartao("22345678");
		
		CaixaEletronico caixa1 = new CaixaEletronico(hardWareMock1, servicoRemotoMock);
		caixa1.logar();
		
		CaixaEletronico caixa2 = new CaixaEletronico(hardWareMock2, servicoRemotoMock);
		caixa2.logar();
		
		assertEquals("O saldo é R$100,50", caixa1.saldo()); 
		assertEquals("O saldo é R$500,00", caixa2.saldo()); 
	}
	
	@Test
	public void sacarDinheiroComSucesso() throws ProblemaNoHardware {
		
		Hardware hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		assertEquals("Retire seu dinheiro", caixa.sacar(50)); 
	}
	
	@Test
	public void consuldaSaldoDepoisDeSacar() throws ProblemaNoHardware {
		
		HardwareMockSucesso hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		caixa.sacar(50); 
		
		assertEquals("O saldo é R$50,50", caixa.saldo()); 
	}
	
	@Test
	public void sacarDinheiroSaldoInsuficiente() throws ProblemaNoHardware {
		
		HardwareMockSucesso hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		assertEquals("Saldo insuficiente", caixa.sacar(150));
	}
	
	@Test
	public void sacarDinheiroFalha() throws ProblemaNoHardware {
		
		Hardware hardWareMock = new HardwareMockQueFalha();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		assertEquals("Não foi possível realizar a retirada do dinehiro neste caixa. Pedimos desculpas pelo transtorno.", caixa.sacar(10));
	}
	
	@Test
	public void persistirContaApenasEmCasoDeSaqueComSucesso() throws ProblemaNoHardware {
		
		Hardware hardWareMock = new HardwareMockQueFalha();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		caixa.sacar(50);
		assertEquals("O saldo é R$100,50", caixa.saldo()); 
	}
	
	@Test
	public void persistirContaApenasEmCasoDeDepositoComSucesso() throws ProblemaNoHardware {
		
		Hardware hardWareMock = new HardwareMockQueFalha();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		caixa.depositar(150);
		
		assertEquals("O saldo é R$100,50", caixa.saldo()); 
	}
	
	@Test
	public void depositarDinheiroComSucesso() {
		
		Hardware hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		assertEquals("Depósito recebido com sucesso", caixa.depositar(50)); 
	}
	
	@Test
	public void consuldaSaldoDepoisDeDepositar() {
		
		Hardware hardWareMock = new HardwareMockSucesso();
		hardWareMock.setNumeroContaCartao("12345678");
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		caixa.depositar(50);
		
		assertEquals("O saldo é R$150,50", caixa.saldo()); 
	}
	
	@Test
	public void depositarDinheiroFalhou() {
		
		Hardware hardWareMock = new HardwareMockQueFalha();
		
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock, servicoRemotoMock);
		caixa.logar();
		
		assertEquals("Não foi possível fazer seu depósito. Retire seu envelope!", caixa.depositar(50)); 
	}
	
	
}