package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SerieTest {

    @Test
    public void testDuracaoTotalSerie() {
        Serie serie = new Serie("Série A", 2020, List.of("Inglês"), List.of("Inglês"), 
                "Descrição da série", List.of("Ator 1", "Ator 2"), "Diretor 1", List.of("Suspense"), 
                3, new int[]{10, 12, 8});

        assertEquals(300, serie.duracaoTotalSerie(10)); // 10 minutos por episódio
    }

    @Test
    public void testGetNumeroTemporadas() {
        Serie serie = new Serie("Série B", 2021, List.of("Português"), List.of("Português"), 
                "Descrição teste", List.of("Ator 3"), "Diretor 2", List.of("Ação"), 2, new int[]{5, 6});

        assertEquals(2, serie.getNumeroTemporadas());
    }
}
