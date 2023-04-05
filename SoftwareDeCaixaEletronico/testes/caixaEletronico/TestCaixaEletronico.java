package caixaEletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import caixaEletronico.CaixaEletronico;

public class TestCaixaEletronico {
	
	@Test
	public void loginComSucesso() {
		HardwareMock hardWareMock = new HardwareMock();
		hardWareMock.setNumeroContaCartao("12345678");
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock);
		assertEquals(caixa.logar(), "Usuário Autenticado"); 
	}
	
	@Test
	public void loginFalha() {
		HardwareMock hardWareMock = new HardwareMock();
		CaixaEletronico caixa = new CaixaEletronico(hardWareMock);
		assertEquals(caixa.logar(), "Não foi possível autenticar o usuário"); 
	}
}
