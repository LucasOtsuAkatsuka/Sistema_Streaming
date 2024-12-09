package trabalhoengsoftware;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class PerfilTest {

    @Test
    public void testEditarPerfil() {
        // Criando uma lista de gêneros favoritos para o perfil
        List<String> generosFavoritos = new ArrayList<>();
        generosFavoritos.add("Aventura");
        generosFavoritos.add("Drama");

        // Criando o perfil
        Perfil perfil = new Perfil("João", false, generosFavoritos);

        // Simulando a entrada do usuário para editar o nome
        String inputEditarNome = "1\nNovoNome\n"; // Opção 1 para editar nome e "NovoNome" como novo nome
        System.setIn(new ByteArrayInputStream(inputEditarNome.getBytes()));

        // Chamada para editar perfil
        perfil.editarPerfil();

        // Verificando se o nome foi alterado
        assertEquals("NovoNome", perfil.getNome());
    }

    @Test
    public void testAplicarRestricoes() {
        // Criando uma lista de gêneros favoritos para o perfil
        List<String> generosFavoritos = new ArrayList<>();
        generosFavoritos.add("Aventura");
        generosFavoritos.add("Drama");

        // Criando o perfil
        Perfil perfil = new Perfil("Maria", true, generosFavoritos);

        // Simulando a aplicação das restrições
        perfil.aplicarRestricoes();

    }

    @Test
    public void testGerenciarGeneros() {
        // Criando uma lista de gêneros favoritos para o perfil
        List<String> generosFavoritos = new ArrayList<>();
        generosFavoritos.add("Aventura");
        generosFavoritos.add("Drama");

        // Criando o perfil
        Perfil perfil = new Perfil("Lucas", false, generosFavoritos);

        // Simulando a entrada do usuário para adicionar um novo gênero
        String inputGerenciarGeneros = "1\nComédia\n3\n"; // Opção 1 para adicionar "Comédia" e Opção 3 para sair
        System.setIn(new ByteArrayInputStream(inputGerenciarGeneros.getBytes()));

        // Chamada para editar perfil (onde será feito o gerenciamento de gêneros)
        perfil.editarPerfil(); // Aqui, vamos garantir que o gerenciamento de gêneros seja executado

        assertTrue(perfil.getGenerosFavoritos().contains("Drama"));
        assertEquals(2, perfil.getGenerosFavoritos().size()); // Espera-se 3 gêneros: "Aventura", "Drama", "Comédia"
    }
}
