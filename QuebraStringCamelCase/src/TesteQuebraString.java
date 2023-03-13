import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
class TesteQuebraString {
    
    @Parameters
    private static Stream<Arguments> stringsUmaPalavra() {
    	
    	ArrayList<Arguments> args = new ArrayList<Arguments>();

    	args.add( Arguments.of("nome", (Object) Arrays.asList("nome")) ) ;
    	args.add( Arguments.of("Nome", (Object) Arrays.asList("nome")) ) ;
    	args.add( Arguments.of("Cloves", (Object) Arrays.asList("cloves")) ) ;
    	
    	return args.stream();
    }
    
    @Parameters
    private static Stream<Arguments> stringsMaiusculas() {
    	
    	ArrayList<Arguments> args = new ArrayList<Arguments>();

    	args.add( Arguments.of("CPF", (Object) Arrays.asList("CPF")) ) ;
    	args.add( Arguments.of("CNPJ", (Object) Arrays.asList("CNPJ")) ) ;
    	args.add( Arguments.of("MAIÚSCULO", (Object) Arrays.asList("MAIÚSCULO")) ) ;
    	
    	return args.stream();
    }
    
    @Parameters
    private static Stream<Arguments> stringsMultiplasPalavras() {
    	
    	ArrayList<Arguments> args = new ArrayList<Arguments>();

    	args.add( Arguments.of("nomeComposto", (Object) Arrays.asList("nome", "composto")) ) ;
    	args.add( Arguments.of("NomeComposto", (Object) Arrays.asList("nome", "composto")) ) ;
    	args.add( Arguments.of("ClovesAdriano", (Object) Arrays.asList("cloves", "adriano")) ) ;
    	args.add( Arguments.of("ClovesAdrianoPaivaSousa", (Object) Arrays.asList("cloves", "adriano", "paiva", "sousa")) ) ;
    	args.add( Arguments.of("numeroCPF", (Object) Arrays.asList("numero", "CPF")) ) ;
    	args.add( Arguments.of("numeroCPFContribuinte", (Object) Arrays.asList("numero", "CPF", "contribuinte")) ) ;
    	args.add( Arguments.of("CNPJUsuario", (Object) Arrays.asList("CNPJ", "usuario")) ) ;
    	args.add( Arguments.of("CidadeCEPBairro", (Object) Arrays.asList("cidade", "CEP", "bairro")) ) ;
    	
    	return args.stream();
    }
    
//    @Parameters
//    private static Stream<Arguments> stringsComecamComNumeros() {
//    	
//    	ArrayList<Arguments> args = new ArrayList<Arguments>();
//
//    	args.add(Arguments.of("10Primeiros", "não deve começar com números"));
//    	args.add(Arguments.of("1Primeiros", "não deve começar com números"));
//    	
//    	return args.stream();
//    }
    
	
    @ParameterizedTest
    @MethodSource("stringsUmaPalavra")
	void retornaListaStrings(String inputString, List<String> expectedOutPut) {
		List<String> listaStrings = QuebradorStringCamelCase.converterCamelCase(inputString);
        assertThat(listaStrings, instanceOf(List.class));
        assertThat(listaStrings.get(0), instanceOf(String.class));
	}
	
    @ParameterizedTest
    @MethodSource("stringsUmaPalavra")
	void retornaPrimeiraLetraDaPalavraMinusculo(String inputString, List<String> expectedOutPut) {
    	
		List<String> listaStrings = QuebradorStringCamelCase.converterCamelCase(inputString);
		
        assertEquals(listaStrings.get(0), expectedOutPut.get(0));
	}
    
    @ParameterizedTest
    @MethodSource("stringsMaiusculas")
    void palavraTudoMaisuculoRetornaTudoMaiusculo(String inputString, List<String> expectedOutPut) {
    	
		List<String> listaStrings = QuebradorStringCamelCase.converterCamelCase(inputString);
		
        assertEquals(listaStrings.get(0), expectedOutPut.get(0));
        
	}
    
    @ParameterizedTest
    @MethodSource("stringsMultiplasPalavras")
    void quebraStringsEmListaDePalavras(String inputString, List<String> expectedOutPut) {
    	
		List<String> listaStrings = QuebradorStringCamelCase.converterCamelCase(inputString);
		assertEquals(listaStrings, expectedOutPut);
	}
    
    @Test
    public void stringNaoPodeComecaComNumeros() {
		Throwable exception = assertThrows(StringInvalida.class, () -> QuebradorStringCamelCase.converterCamelCase("10Primeiros"));
		assertEquals(exception.getMessage(), "não deve começar com números");
	}
	
}
