import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

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
//    	args.add( Arguments.of("NomeComposto", (Object) Arrays.asList("nome", "composto")) ) ;
//    	args.add( Arguments.of("ClovesAdriano", (Object) Arrays.asList("cloves", "adriano")) ) ;
    	
    	return args.stream();
    }
    
	
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
	
}
