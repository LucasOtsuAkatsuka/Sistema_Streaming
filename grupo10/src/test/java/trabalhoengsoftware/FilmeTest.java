package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    @Test
    public void testGetDuracao() {
        Filme filme = new Filme("Filme A", 2021, List.of("Português"), List.of("Português"), 
                "Descrição do filme", List.of("Ator X", "Ator Y"), "Diretor Z", List.of("Drama"), 120);

        assertEquals(120, filme.getDuracao());
    }
}
