package trabalhoengsoftware;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class RelatorioTest {

    @Test
    public void testGerarRelatorio() {
        // Criar alguns conteúdos fictícios para teste
        Conteudo filme = new Filme("O Senhor dos Anéis", 2001, Arrays.asList("Português", "Inglês"),
                Arrays.asList("Dublado", "Legendado"), "A jornada épica", Arrays.asList("Elijah Wood", "Ian McKellen"),
                "Peter Jackson", Arrays.asList("Aventura", "Fantasia"), 180);

        Conteudo serie = new Serie("Breaking Bad", 2008, Arrays.asList("Português", "Inglês"),
                Arrays.asList("Dublado", "Legendado"), "A história de um professor de química",
                Arrays.asList("Bryan Cranston", "Aaron Paul"),
                "Vince Gilligan", Arrays.asList("Crime", "Drama"), 5, 13);

        // Adicionar os conteúdos à lista
        Relatorio relatorio = new Relatorio(Arrays.asList(filme, serie), 1000);

        // Gerar o relatório
        String resultadoEsperado = "Conteúdo Assistido: \n" +
                " - O Senhor dos Anéis (2001)\n" +
                " - Breaking Bad (2008)\n" +
                "Tempo Total Assistido: 1000 minutos\n";

        // Verificar se o resultado do método gerarRelatorio está correto
        assertEquals(resultadoEsperado, relatorio.gerarRelatorio());
    }
}
