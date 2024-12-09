package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        // Criando uma instância de Pessoa para realizar os testes
        pessoa = new Pessoa("João Silva", "joao@example.com", "senha123", true);
    }

    @Test
    public void testPessoaConstructor() {
        // Testa se o nome, email e senha são atribuídos corretamente ao criar a
        // instância de Pessoa
        assertEquals("João Silva", pessoa.getNome(), "O nome não foi atribuído corretamente.");
        assertEquals("joao@example.com", pessoa.getEmail(), "O email não foi atribuído corretamente.");
        assertEquals("senha123", pessoa.getSenha(), "A senha não foi atribuída corretamente.");
        assertTrue(pessoa.isEhAdm(), "A pessoa não foi registrada como administrador corretamente.");
    }

    @Test
    public void testLoginSuccess() {
        // Testa se o login é bem-sucedido com as credenciais corretas
        assertTrue(pessoa.login("joao@example.com", "senha123"), "O login não foi realizado corretamente.");
    }

    @Test
    public void testLoginFailure() {
        // Testa se o login falha com credenciais incorretas
        assertFalse(pessoa.login("joao@example.com", "senhaErrada"),
                "O login foi realizado com credenciais incorretas.");
        assertFalse(pessoa.login("emailErrado@example.com", "senha123"), "O login foi realizado com email incorreto.");
    }

    @Test
    public void testLogout() {
        System.out.println("Testando o logout...");
        pessoa.logout();
    }
}