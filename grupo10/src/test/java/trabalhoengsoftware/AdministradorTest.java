package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    @Test
    public void testGerenciarUsuarios() {
        Administrador admin = new Administrador("Admin", "admin@example.com", "admin123", "Gerente");

        // Simulando a interação com a função gerenciar usuários
        assertDoesNotThrow(admin::gerenciarUsuarios);
    }

    @Test
    public void testGerenciarConteudo() {
        Administrador admin = new Administrador("Admin", "admin@example.com", "admin123", "Gerente");

        // Simulando a interação com a função gerenciar conteúdos
        assertDoesNotThrow(admin::gerenciarConteudo);
    }

    @Test
    public void testGetCargo() {
        Administrador admin = new Administrador("Admin", "admin@example.com", "admin123", "Gerente");
        assertEquals("Gerente", admin.getCargo());
    }
}
