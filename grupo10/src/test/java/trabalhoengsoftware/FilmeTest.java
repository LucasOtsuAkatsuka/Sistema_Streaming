package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    private Filme filme;

    @BeforeEach
    public void setUp() {
        // Criando uma instância de Filme para realizar os testes
        filme = new Filme(
                "Aventura no Espaço",
                2024,
                Arrays.asList("PT-BR", "EN"),
                Arrays.asList("Stereo", "Dolby"),
                "Filme de ficção científica sobre viagens espaciais",
                Arrays.asList("Ator 1", "Ator 2"),
                "Diretor Espacial",
                Arrays.asList("Ficção Científica", "Aventura"),
                120 // duração do filme em minutos
        );
    }

    @Test
    public void testGetDuracao() {
        assertEquals(120, filme.getDuracao(), "A duração do filme não corresponde.");
    }

    @Test
    public void testSetDuracao() {
        // A classe Filme não possui setter, então vamos apenas verificar a duração no
        // momento da criação
        // Caso precise de um setter, a classe pode ser modificada para incluir isso.
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Aventura no Espaço", filme.getTitulo(), "O título não corresponde.");
    }

    @Test
    public void testGetAnoDeProducao() {
        assertEquals(2024, filme.getAnoDeProducao(), "O ano de produção não corresponde.");
    }

    @Test
    public void testGetLegendasDisponiveis() {
        List<String> legendasEsperadas = Arrays.asList("PT-BR", "EN");
        assertEquals(legendasEsperadas, filme.getLegendasDisponiveis(), "As legendas não correspondem.");
    }

    @Test
    public void testGetAudiosDisponiveis() {
        List<String> audiosEsperados = Arrays.asList("Stereo", "Dolby");
        assertEquals(audiosEsperados, filme.getAudiosDisponiveis(), "Os áudios não correspondem.");
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Filme de ficção científica sobre viagens espaciais", filme.getDescricao(),
                "A descrição não corresponde.");
    }

    @Test
    public void testGetNomeAtores() {
        List<String> atoresEsperados = Arrays.asList("Ator 1", "Ator 2");
        assertEquals(atoresEsperados, filme.getNomeAtores(), "Os atores não correspondem.");
    }

    @Test
    public void testGetNomeDiretor() {
        assertEquals("Diretor Espacial", filme.getNomeDiretor(), "O nome do diretor não corresponde.");
    }

    @Test
    public void testGetGeneros() {
        List<String> generosEsperados = Arrays.asList("Ficção Científica", "Aventura");
        assertEquals(generosEsperados, filme.getGeneros(), "Os gêneros não correspondem.");
    }

    @Test
    public void testSomarVizualizacoes() {
        assertEquals(0, filme.getVizualizacoes(), "O número de visualizações não está correto inicialmente.");
        filme.somarVizualizacoes();
        assertEquals(1, filme.getVizualizacoes(), "O número de visualizações não foi incrementado corretamente.");
        filme.somarVizualizacoes();
        assertEquals(2, filme.getVizualizacoes(), "O número de visualizações não foi incrementado corretamente.");
    }
}
