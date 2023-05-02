package appGamificacao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testesPlacar {

    private Placar placar;
    private Armazenamento mockArmazenador;
    
    @Before
	public void inicializarPlacar() {
    	mockArmazenador = new MockArmazenadorDePontuacoes();
        placar = new Placar(mockArmazenador);
    }

    @Test
    public void testRegistrarPontos() throws Exception {
        
        // Registra 10 pontos do tipo "moeda" para o usuário "guerra"
        placar.registrarPontos("moeda", (long) 10, "guerra");

        // Verifica se o ponto "moeda" foi registrado
        Map<String, Long> pontos = placar.pontosDoUsuario("guerra");
        Assert.assertEquals(Long.valueOf(10), pontos.get("moeda"));
    }

    @Test
    public void testRegistrarPontosDeVariosTipos() throws Exception {
    	
    	// Esvazia registros estáticos
    	List<PontuacaoUsuario> registrosVazio = new ArrayList<PontuacaoUsuario>();
    	Armazenamento.setRegistros(registrosVazio);
    	
        // Registra 10 pontos do tipo "moeda" para o usuário "guerra"
        placar.registrarPontos("moeda", (long) 10, "guerra");

        // Registra 5 pontos do tipo "estrela" para o usuário "guerra"
        placar.registrarPontos("estrela", (long) 5, "guerra");

        // Verifica se os pontos foram registrados corretamente
        Map<String, Long> pontos = placar.pontosDoUsuario("guerra");
        Assert.assertEquals(Long.valueOf(20), pontos.get("moeda"));
        Assert.assertEquals(Long.valueOf(5), pontos.get("estrela"));
    }
    
    @Test
    public void testPontosDoUsuario() throws Exception {
        
        // Registra 10 pontos do tipo "moeda" para o usuário "joão"
        placar.registrarPontos("moeda", (long) 10, "joão");
        
        // Registra 5 pontos do tipo "estrela" para o usuário "joão"
        placar.registrarPontos("estrela", (long) 5, "joão");

        // Verifica se os pontos foram registrados corretamente
        Map<String, Long> pontosJoao = placar.pontosDoUsuario("joão");
        Assert.assertEquals(Long.valueOf(10), pontosJoao.get("moeda"));
        Assert.assertEquals(Long.valueOf(5), pontosJoao.get("estrela"));
        
        // Registra 15 pontos do tipo "moeda" para o usuário "maria"
        placar.registrarPontos("moeda", (long) 15, "maria");
        
        // Verifica se os pontos foram registrados corretamente
        Map<String, Long> pontosMaria = placar.pontosDoUsuario("maria");
        Assert.assertEquals(Long.valueOf(15), pontosMaria.get("moeda"));
        Assert.assertNull(pontosMaria.get("estrela"));
    }

    
    @Test
    public void testRanking() throws Exception {
        // Registra 10 pontos do tipo "moeda" para o usuário "alexandre"
        placar.registrarPontos("moeda", (long) 10, "alexandre");

        // Registra 5 pontos do tipo "estrela" para o usuário "alexandre"
        placar.registrarPontos("estrela", (long) 5, "alexandre");

        // Registra 19 pontos do tipo "estrela" para o usuário "fernandes"
        placar.registrarPontos("estrela", (long) 19, "fernandes");

        // Registra 25 pontos do tipo "estrela" para o usuário "rodrigo"
        placar.registrarPontos("estrela", (long) 25, "rodrigo");

        // Verifica o ranking de usuários com mais pontos do tipo "estrela"
        List<Map.Entry<String, Long>> ranking = placar.ranking("estrela");
        assertEquals(3, ranking.size());

        // Primeiro lugar: "rodrigo" com 25 pontos
        assertEquals("rodrigo", ranking.get(0).getKey());
        assertEquals(Long.valueOf(25), ranking.get(0).getValue());

        // Segundo lugar: "fernandes" com 19 pontos
        assertEquals("fernandes", ranking.get(1).getKey());
        assertEquals(Long.valueOf(19), ranking.get(1).getValue());

        // Terceiro lugar: "alexandre" com 5 pontos
        assertEquals("alexandre", ranking.get(2).getKey());
        assertEquals(Long.valueOf(5), ranking.get(2).getValue());
    }

}
