package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConteudoTest {

    @Test
    public void testSomarVizualizacoes() {
        Conteudo filme = new Filme("Filme A", 2022, List.of("Português"), List.of("Português"), 
                "Um filme emocionante", List.of("Ator A", "Ator B"), "Diretor A", List.of("Ação"), 120);

        assertEquals(0, filme.getVizualizacoes());
        filme.somarVizualizacoes();
        assertEquals(1, filme.getVizualizacoes());
    }

    @Test
    public void testGetLegendasAudios() {
        Conteudo filme = new Filme("Filme B", 2022, List.of("Inglês", "Espanhol"), List.of("Inglês"),
                "Descrição teste", List.of("Ator C"), "Diretor B", List.of("Comédia"), 90);

        assertEquals(List.of("Inglês", "Espanhol"), filme.getLegendasDisponiveis());
        assertEquals(List.of("Inglês"), filme.getAudiosDisponiveis());
    }
}
