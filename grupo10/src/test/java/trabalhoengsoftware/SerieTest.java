package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SerieTest {

    private Serie serie;

    @BeforeEach
    public void setUp() {
        // Criando uma instância de Serie para realizar os testes
        serie = new Serie(
                "Minha Série",
                2020,
                Arrays.asList("Português", "Inglês"),
                Arrays.asList("PT-BR", "EN"),
                "Descrição da série",
                Arrays.asList("Ator1", "Ator2"),
                "Diretor1",
                Arrays.asList("Ação", "Drama"),
                5, // Número de temporadas
                10 // Episódios por temporada
        );
    }

    @Test
    public void testSerieConstructor() {
        // Testa se a instância de Série foi criada corretamente com os valores
        // esperados
        assertEquals("Minha Série", serie.getTitulo(), "O título da série não foi atribuído corretamente.");
        assertEquals(2020, serie.getAnoDeProducao(), "O ano de produção da série não foi atribuído corretamente.");
        assertEquals(5, serie.getNumeroTemporadas(), "O número de temporadas não foi atribuído corretamente.");
        assertEquals(10, serie.duracaoTotalSerie(30) / (5 * 30),
                "O número de episódios por temporada não foi atribuído corretamente.");
    }

    @Test
    public void testDuracaoTotalSerie() {
        // Testa se o cálculo da duração total da série está correto
        // Vamos usar a duração média de 30 minutos por episódio
        int duracaoMediaPorEpisodio = 30;
        int duracaoTotalEsperada = 5 * 10 * duracaoMediaPorEpisodio; // 5 temporadas x 10 episódios x 30 minutos
        assertEquals(duracaoTotalEsperada, serie.duracaoTotalSerie(duracaoMediaPorEpisodio),
                "A duração total da série não foi calculada corretamente.");
    }

    @Test
    public void testGetNumeroTemporadas() {
        // Testa o getter para o número de temporadas
        assertEquals(5, serie.getNumeroTemporadas(), "O número de temporadas não está correto.");
    }
}
