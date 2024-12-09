package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuario;
    private Assinatura assinatura;
    private Perfil perfil1;
    private Perfil perfil2;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Configuração antes de cada teste
        usuario = new Usuario("João", "joao@exemplo.com", "senha123");
        assinatura = new Assinatura(new MetodoPagamento("Cartão"), "Premium");
        System.setOut(new PrintStream(outputStreamCaptor));

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

    }

    @Test
    public void testGerenciarPerfis_AdicionarPerfil() {
        // Simula a entrada de dados para adicionar um perfil
        String input = "1\n" + // Escolha adicionar um perfil
                "Perfil1\n" + // Nome do perfil
                "1\n" + // Se é infantil
                "Ação, Comédia\n"; // Gêneros favoritos

        System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula a entrada no Scanner

        usuario.gerenciarPerfis();

        // Verifica se a saída contém a mensagem correta após a criação do perfil
        assertTrue(outputStreamCaptor.toString().contains("Perfil Perfil1 criado com sucesso."));
        assertEquals(1, usuario.getPerfis().size(), "Deveria haver 1 perfil após a adição.");
    }

    @Test
    public void testGerenciarPerfis_EditarPerfil() {
        // Simula a entrada de dados para adicionar um perfil
        String inputAdicionar = "1\n" + // Escolha adicionar um perfil
                "Perfil2\n" + // Nome do perfil
                "0\n" + // Se não é infantil
                "Drama, Aventura\n"; // Gêneros favoritos
        System.setIn(new ByteArrayInputStream(inputAdicionar.getBytes()));
        usuario.gerenciarPerfis();
    }

    @Test
    public void testGerenciarPerfis_ListarPerfis() {
        // Simula a entrada de dados para adicionar um perfil
        String inputAdicionar = "1\n" + // Escolha adicionar um perfil
                "Perfil3\n" + // Nome do perfil
                "1\n" + // Se é infantil
                "Ação, Aventura\n"; // Gêneros favoritos
        System.setIn(new ByteArrayInputStream(inputAdicionar.getBytes()));
        usuario.gerenciarPerfis();

        // Simula a entrada para listar os perfis
        String inputListar = "3\n"; // Escolha listar os perfis
        System.setIn(new ByteArrayInputStream(inputListar.getBytes()));
        usuario.gerenciarPerfis();

        // Verifica se a saída contém o nome do perfil
        assertTrue(outputStreamCaptor.toString().contains("Perfil3"));
    }

    @Test
    public void testGerenciarPerfis_DeletarPerfil() {
        // Simula a entrada de dados para adicionar um perfil
        String inputAdicionar = "1\n" + // Escolha adicionar um perfil
                "Perfil4\n" + // Nome do perfil
                "0\n" + // Se não é infantil
                "Comédia, Ação\n"; // Gêneros favoritos
        System.setIn(new ByteArrayInputStream(inputAdicionar.getBytes()));
        usuario.gerenciarPerfis();

        // Simula a entrada para deletar o perfil
        String inputDeletar = "4\n" + // Escolha deletar o perfil
                "1\n"; // Escolher o perfil "Perfil4" para deletar
        System.setIn(new ByteArrayInputStream(inputDeletar.getBytes()));
        usuario.gerenciarPerfis();

        // Verifica se o perfil foi deletado corretamente
        assertTrue(outputStreamCaptor.toString().contains("Perfil Perfil4 deletado com sucesso."));
        assertEquals(0, usuario.getPerfis().size(), "Deveria haver 0 perfis após a deleção.");
    }
}
