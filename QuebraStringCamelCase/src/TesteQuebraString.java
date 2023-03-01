import java.util.List;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class TesteQuebraString {
	
	@Test
	void retornaListaStrings() {
		List<String> listaStrings = QuebradorStringCamelCase.converterCamelCase("nome");
        assertThat(listaStrings, instanceOf(List.class));
        assertThat(listaStrings.get(0), instanceOf(String.class));
	}
	
}
