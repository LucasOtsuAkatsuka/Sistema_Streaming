package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testFazerAssinatura() {
        Usuario usuario = new Usuario("Lucas", "lucas@example.com", "1234");
        MetodoPagamento metodoPagamento = new MetodoPagamento("Cartão");
        usuario.fazerAssinatura(metodoPagamento, "Premium");

        assertTrue(usuario.isAssinante());
        assertNotNull(usuario.getAssinatura());
        assertEquals("Premium", usuario.getAssinatura().getTipoAssinatura());
    }

    @Test
    public void testCancelarAssinatura() {
        Usuario usuario = new Usuario("Lucas", "lucas@example.com", "1234");
        MetodoPagamento metodoPagamento = new MetodoPagamento("Pix");
        usuario.fazerAssinatura(metodoPagamento, "Comum");

        usuario.cancelarAssinatura();

        assertFalse(usuario.isAssinante());
        assertNull(usuario.getAssinatura());
    }

    @Test
    public void testGerenciarPerfis() {
        Usuario usuario = new Usuario("Lucas", "lucas@example.com", "1234");
        usuario.gerenciarPerfis("criar", "Perfil 1", false, List.of("Ação", "Comédia"));

        assertEquals(1, usuario.getPerfis().size());
        assertEquals("Perfil 1", usuario.getPerfis().get(0).getNome());

        usuario.gerenciarPerfis("deletar", "Perfil 1", false, null);

        assertEquals(0, usuario.getPerfis().size());
    }

    @Test
    public void testPesquisarConteudo() {
        Usuario usuario = new Usuario("Lucas", "lucas@example.com", "1234");
        assertDoesNotThrow(() -> usuario.pesquisarConteudo("Filme A"));
    }
}
