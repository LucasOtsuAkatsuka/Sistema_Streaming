package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PerfilTest {

    @Test
    public void testEditarPerfil() {
        Perfil perfil = new Perfil("Perfil 1", false, List.of("Ação", "Comédia"));
        perfil.editarPerfil("Novo Perfil", true, List.of("Animação", "Fantasia"));

        assertEquals("Novo Perfil", perfil.getNome());
        assertTrue(perfil.isEhInfantil());
        assertEquals(List.of("Animação", "Fantasia"), perfil.getGenerosFavoritos());
    }

    @Test
    public void testAplicarRestricoes() {
        Perfil perfil = new Perfil("Infantil", true, List.of("Animação"));
        assertDoesNotThrow(perfil::aplicarRestricoes);
    }
}
