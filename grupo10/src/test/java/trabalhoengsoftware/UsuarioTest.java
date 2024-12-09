package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuario;
    private Assinatura assinatura;
    private Perfil perfil1;
    private Perfil perfil2;

    @BeforeEach
    void setUp() {
        // Configuração antes de cada teste
        usuario = new Usuario("João", "joao@exemplo.com", "senha123");
        assinatura = new Assinatura(new MetodoPagamento("Cartão"), "Premium");

        // Criando perfis de exemplo
        perfil1 = new Perfil("Perfil Infantil", true, List.of("Ação", "Aventura"));
        perfil2 = new Perfil("Perfil Adulto", false, List.of("Drama", "Comédia"));
    }

    @Test
    void testFazerAssinatura() {
        assertFalse(usuario.isAssinante(), "O usuário não deveria ser assinante inicialmente.");

        usuario.fazerAssinatura(assinatura);

        assertTrue(usuario.isAssinante(), "O usuário deveria ser assinante após realizar a assinatura.");
        assertEquals("Premium", usuario.getAssinatura().getTipoAssinatura(),
                "O tipo da assinatura deveria ser Premium.");
    }

    @Test
    void testCancelarAssinatura() {
        usuario.fazerAssinatura(assinatura);
        assertTrue(usuario.isAssinante(), "O usuário deveria ser assinante.");

        usuario.cancelarAssinatura();

        assertFalse(usuario.isAssinante(), "O usuário não deveria ser assinante após cancelar.");
        assertNull(usuario.getAssinatura(), "A assinatura deveria ser nula após o cancelamento.");
    }

    @Test
    void testPesquisarConteudo() {
        // Testando o método de pesquisa de conteúdo
        usuario.pesquisarConteudo("Aventura");
    }

}
