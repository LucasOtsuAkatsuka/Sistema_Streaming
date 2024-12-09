package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RelatorioTest {

    @Test
    public void testGerarRelatorio() {
        Usuario usuario = new Usuario("Lucas", "lucas@example.com", "1234");
        List<Conteudo> conteudos = List.of(
                new Filme("Filme A", 2022, List.of("Português"), List.of("Português"), 
                        "Descrição filme", List.of("Ator A"), "Diretor A", List.of("Ação"), 120),
                new Serie("Série A", 2020, List.of("Inglês"), List.of("Inglês"), 
                        "Descrição série", List.of("Ator B"), "Diretor B", List.of("Comédia"), 2, new int[]{10, 12})
        );

        Relatorio relatorio = new Relatorio(usuario, conteudos, 300);
        String textoRelatorio = relatorio.gerarRelatorio();

        assertTrue(textoRelatorio.contains("Lucas"));
        assertTrue(textoRelatorio.contains("Filme A"));
        assertTrue(textoRelatorio.contains("300 minutos"));
    }
}
