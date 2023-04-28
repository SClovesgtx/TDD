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

//    @Test
//    public void testPontosDoUsuarioComZero() throws Exception {
//        // Verifica se pontos de um tipo que o usuário não possui são retornados como zero
//    	Map<String, Long> pontos = placar.pontosDoUsuario("guerra");
//    	
//    	placar.registrarPontos("moeda", (long) 10, "guerra");
//        Assert.assertEquals(1, pontos.size());
//        Assert.assertEquals(Long.valueOf(20), pontos.get("moeda"));
//    }
//
//    @Test
//    public void testGetRanking() throws Exception {
//        placar.registrarPonto("estrela", 10, "guerra");
//        placar.registrarPonto("moeda", 20, "guerra");
//        placar.registrarPonto("estrela", 5, "fernandes");
//        placar.registrarPonto("estrela", 17, "rodrigo");
//        placar.registrarPonto("moeda", 15, "fernandes");
//        placar.registrarPonto("estrela", 8, "rodrigo");
//
//        Map<String, Long> rankingEstrela = placar.getRanking("estrela");
//        assertEquals(3, rankingEstrela.size());
//        assertEquals(17L, (long) rankingEstrela.get("rodrigo"));
//        assertEquals(10L, (long) rankingEstrela.get("guerra"));
//        assertEquals(5L, (long) rankingEstrela.get("fernandes"));
//
//        Map<String, Long> rankingMoeda = placar.getRanking("moeda");
//        assertEquals(2, rankingMoeda.size());
//        assertEquals(20L, (long) rankingMoeda.get("guerra"));
//        assertEquals(15L, (long) rankingMoeda.get("fernandes"));
//    }
//
    
    @Test
    public void testRankingTipoDePontuacaoNaoRegistrada() throws Exception {
    	List<PontuacaoUsuario> ranking =  placar.ranking("energia");
        Assert.assertTrue(ranking.isEmpty());
    }
}
