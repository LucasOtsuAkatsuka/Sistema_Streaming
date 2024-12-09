package trabalhoengsoftware;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.ByteArrayInputStream;

class AdministradorTest {

    @Test
    void testAdicionarConteudo() {
        Administrador administrador = new Administrador("Administrador", "admin@example.com", "admin123");
        List<Conteudo> conteudos = new ArrayList<>();

        String simulatedInput = "Filme Teste\n" + // Título
                "2024\n" + // Ano de Produção
                "Legenda1,Legenda2\n" + // Legendas Disponíveis
                "Audio1,Audio2\n" + // Áudios Disponíveis
                "Descrição do filme\n" + // Descrição
                "Ator1,Ator2\n" + // Nomes dos Atores
                "Diretor1\n" + // Nome do Diretor
                "Ação,Comédia\n" + // Gêneros
                "1\n" + // Tipo de Conteúdo (1 = Filme)
                "120\n"; // Duração (apenas para Filme)

        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        administrador.adicionarConteudo(scanner, conteudos);

        assertEquals(1, conteudos.size(), "Conteúdo não foi adicionado.");
        assertEquals("Filme Teste", conteudos.get(0).getTitulo(), "Título do conteúdo está incorreto.");
        assertEquals(2024, conteudos.get(0).getAnoDeProducao(), "Ano de produção está incorreto.");
        assertEquals("Descrição do filme", conteudos.get(0).getDescricao(), "Descrição do conteúdo está incorreta.");
        assertEquals("Diretor1", conteudos.get(0).getNomeDiretor(), "Nome do diretor está incorreto.");
        assertEquals(120, ((Filme) conteudos.get(0)).getDuracao(), "Duração do filme está incorreta.");
    }

    @Test
    void testDeletarConteudo() {
        Administrador administrador = new Administrador("Administrador", "admin@example.com", "admin123");
        List<Conteudo> conteudos = new ArrayList<>();
        Filme filme = new Filme("Filme Teste", 2024, Arrays.asList("Legenda1", "Legenda2"),
                Arrays.asList("Audio1", "Audio2"),
                "Descrição do filme", Arrays.asList("Ator1", "Ator2"), "Diretor1", Arrays.asList("Ação", "Comédia"),
                120);
        conteudos.add(filme);

        // Entrada simulada para deletar um conteúdo
        String simulatedInput = "1\n" + // Escolher deletar conteúdo
                "1\n" + // Escolher o conteúdo
                "0"; // Voltar

        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        administrador.deletarConteudo(scanner, conteudos);

        // Verificar se o conteúdo foi deletado
        assertEquals(0, conteudos.size(), "Conteúdo não foi deletado.");
    }

    // Testa o método listarConteudos
    @Test
    void testListarConteudos() {
        Administrador administrador = new Administrador("Administrador", "admin@example.com", "admin123");
        List<Conteudo> conteudos = new ArrayList<>();
        Filme filme = new Filme("Filme Teste", 2024, Arrays.asList("Legenda1", "Legenda2"),
                Arrays.asList("Audio1", "Audio2"),
                "Descrição do filme", Arrays.asList("Ator1", "Ator2"), "Diretor1", Arrays.asList("Ação", "Comédia"),
                120);
        conteudos.add(filme);

        // Não há entrada do usuário, apenas chamamos o método para listar conteúdos
        administrador.listarConteudos(conteudos);

    }

    @Test
    public void testGerenciarUsuarios_DeletarUsuarioComConfirmacao() {
        // Configuração inicial
        List<Pessoa> pessoas = new ArrayList<>();
        Usuario usuario1 = new Usuario("João", "joao@example.com", "senha123");
        Usuario usuario2 = new Usuario("Maria", "maria@example.com", "senha456");

        pessoas.add(usuario1);
        pessoas.add(usuario2);

        // Simular a entrada do usuário
        String inputSimulado = "1\n" + // Escolher o usuário João
                "sim\n"; // Confirmar a exclusão
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStream);

        // Chamar o método de gerenciamento de usuários
        Administrador admin = new Administrador("Admin", "admin@example.com", "adminpass");
        admin.gerenciarUsuarios(pessoas);

        // Verificar se o usuário foi deletado
        assertFalse(pessoas.contains(usuario1), "O usuário João deveria ter sido deletado");
        assertTrue(pessoas.contains(usuario2), "O usuário Maria não deveria ter sido deletado");
    }

    @Test
    public void testGerenciarUsuarios_CancelarDeletacao() {
        // Configuração inicial
        List<Pessoa> pessoas = new ArrayList<>();
        Usuario usuario1 = new Usuario("João", "joao@example.com", "senha123");
        Usuario usuario2 = new Usuario("Maria", "maria@example.com", "senha456");

        pessoas.add(usuario1);
        pessoas.add(usuario2);

        // Simular a entrada do usuário para cancelar
        String inputSimulado = "1\n" + // Escolher o usuário João
                "nao\n"; // Cancelar a exclusão
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStream);

        // Chamar o método de gerenciamento de usuários
        Administrador admin = new Administrador("Admin", "admin@example.com", "adminpass");
        admin.gerenciarUsuarios(pessoas);

        // Verificar se o usuário NÃO foi deletado
        assertTrue(pessoas.contains(usuario1), "O usuário João não deveria ter sido deletado");
        assertTrue(pessoas.contains(usuario2), "O usuário Maria não deveria ter sido deletado");
    }

    @Test
    public void testGerenciarUsuarios_IndiceInvalido() {
        // Configuração inicial
        List<Pessoa> pessoas = new ArrayList<>();
        Usuario usuario1 = new Usuario("João", "joao@example.com", "senha123");
        Usuario usuario2 = new Usuario("Maria", "maria@example.com", "senha456");

        pessoas.add(usuario1);
        pessoas.add(usuario2);

        // Simular a entrada do usuário para um índice inválido
        String inputSimulado = "3\n" + // Índice inválido (não existe usuário 3)
                "sim\n"; // Confirmar a exclusão (mas o índice é inválido)
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStream);

        // Chamar o método de gerenciamento de usuários
        Administrador admin = new Administrador("Admin", "admin@example.com", "adminpass");
        admin.gerenciarUsuarios(pessoas);

        // Verificar que a lista de usuários não foi alterada
        assertTrue(pessoas.contains(usuario1), "O usuário João deveria estar na lista");
        assertTrue(pessoas.contains(usuario2), "O usuário Maria deveria estar na lista");
    }

    @Test
    public void testGerenciarUsuarios_UsuarioNaoEncontrado() {
        // Configuração inicial
        List<Pessoa> pessoas = new ArrayList<>();
        Usuario usuario1 = new Usuario("João", "joao@example.com", "senha123");

        pessoas.add(usuario1);

        // Simular a entrada do usuário para tentar deletar um usuário inexistente
        String inputSimulado = "2\n" + // Índice inválido (não existe usuário 2)
                "sim\n"; // Confirmar a exclusão (mas o índice é inválido)
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStream);

        // Chamar o método de gerenciamento de usuários
        Administrador admin = new Administrador("Admin", "admin@example.com", "adminpass");
        admin.gerenciarUsuarios(pessoas);

        // Verificar que a lista de usuários não foi alterada
        assertTrue(pessoas.contains(usuario1), "O usuário João deveria estar na lista");
    }

}