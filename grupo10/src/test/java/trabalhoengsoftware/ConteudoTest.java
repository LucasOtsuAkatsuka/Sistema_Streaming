package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConteudoTest {

    private Conteudo conteudo;

    // Classe concreta para testar Conteudo (já que Conteudo é uma classe abstrata)
    private static class ConteudoConcreto extends Conteudo {
        public ConteudoConcreto(String titulo, int anoDeProducao, List<String> legendasDisponiveis,
                List<String> audiosDisponiveis, String descricao, List<String> nomeAtores,
                String nomeDiretor, List<String> generos) {
            super(titulo, anoDeProducao, legendasDisponiveis, audiosDisponiveis, descricao, nomeAtores,
                    nomeDiretor, generos);
        }
    }

    @BeforeEach
    public void setUp() {
        // Criando um objeto ConteudoConcreto para realizar os testes
        conteudo = new ConteudoConcreto(
                "Filme Exemplo",
                2024,
                Arrays.asList("PT-BR", "EN"),
                Arrays.asList("Stereo", "Dolby"),
                "Descrição do filme",
                Arrays.asList("Ator 1", "Ator 2"),
                "Diretor Exemplo",
                Arrays.asList("Ação", "Aventura"));
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Filme Exemplo", conteudo.getTitulo(), "O título não corresponde.");
    }

    @Test
    public void testSetTitulo() {
        conteudo.setTitulo("Novo Título");
        assertEquals("Novo Título", conteudo.getTitulo(), "O título não foi atualizado.");
    }

    @Test
    public void testGetAnoDeProducao() {
        assertEquals(2024, conteudo.getAnoDeProducao(), "O ano de produção não corresponde.");
    }

    @Test
    public void testSetAnoDeProducao() {
        conteudo.setAnoDeProducao(2025);
        assertEquals(2025, conteudo.getAnoDeProducao(), "O ano de produção não foi atualizado.");
    }

    @Test
    public void testGetLegendasDisponiveis() {
        List<String> legendasEsperadas = Arrays.asList("PT-BR", "EN");
        assertEquals(legendasEsperadas, conteudo.getLegendasDisponiveis(), "As legendas não correspondem.");
    }

    @Test
    public void testSetLegendasDisponiveis() {
        List<String> novasLegendas = Arrays.asList("ES", "FR");
        conteudo.setLegendasDisponiveis(novasLegendas);
        assertEquals(novasLegendas, conteudo.getLegendasDisponiveis(), "As legendas não foram atualizadas.");
    }

    @Test
    public void testGetAudiosDisponiveis() {
        List<String> audiosEsperados = Arrays.asList("Stereo", "Dolby");
        assertEquals(audiosEsperados, conteudo.getAudiosDisponiveis(), "Os áudios não correspondem.");
    }

    @Test
    public void testSetAudiosDisponiveis() {
        List<String> novosAudios = Arrays.asList("5.1", "Surround");
        conteudo.setAudiosDisponiveis(novosAudios);
        assertEquals(novosAudios, conteudo.getAudiosDisponiveis(), "Os áudios não foram atualizados.");
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição do filme", conteudo.getDescricao(), "A descrição não corresponde.");
    }

    @Test
    public void testSetDescricao() {
        conteudo.setDescricao("Nova descrição");
        assertEquals("Nova descrição", conteudo.getDescricao(), "A descrição não foi atualizada.");
    }

    @Test
    public void testGetNomeAtores() {
        List<String> atoresEsperados = Arrays.asList("Ator 1", "Ator 2");
        assertEquals(atoresEsperados, conteudo.getNomeAtores(), "Os atores não correspondem.");
    }

    @Test
    public void testSetNomeAtores() {
        List<String> novosAtores = Arrays.asList("Ator 3", "Ator 4");
        conteudo.setNomeAtores(novosAtores);
        assertEquals(novosAtores, conteudo.getNomeAtores(), "Os atores não foram atualizados.");
    }

    @Test
    public void testGetNomeDiretor() {
        assertEquals("Diretor Exemplo", conteudo.getNomeDiretor(), "O nome do diretor não corresponde.");
    }

    @Test
    public void testSetNomeDiretor() {
        conteudo.setNomeDiretor("Novo Diretor");
        assertEquals("Novo Diretor", conteudo.getNomeDiretor(), "O nome do diretor não foi atualizado.");
    }

    @Test
    public void testGetGeneros() {
        List<String> generosEsperados = Arrays.asList("Ação", "Aventura");
        assertEquals(generosEsperados, conteudo.getGeneros(), "Os gêneros não correspondem.");
    }

    @Test
    public void testSetGeneros() {
        List<String> novosGeneros = Arrays.asList("Comédia", "Drama");
        conteudo.setGeneros(novosGeneros);
        assertEquals(novosGeneros, conteudo.getGeneros(), "Os gêneros não foram atualizados.");
    }

    @Test
    public void testSomarVizualizacoes() {
        assertEquals(0, conteudo.getVizualizacoes(), "O número de visualizações não está correto inicialmente.");
        conteudo.somarVizualizacoes();
        assertEquals(1, conteudo.getVizualizacoes(), "O número de visualizações não foi incrementado corretamente.");
        conteudo.somarVizualizacoes();
        assertEquals(2, conteudo.getVizualizacoes(), "O número de visualizações não foi incrementado corretamente.");
    }
}
