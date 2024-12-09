package trabalhoengsoftware;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetodoPagamentoTest {

    @Test
    public void testValidarMetodo() {
        MetodoPagamento cartao = new MetodoPagamento("Cartão");
        MetodoPagamento pix = new MetodoPagamento("Pix");
        MetodoPagamento invalido = new MetodoPagamento("Cheque");

        assertTrue(cartao.validarMetodo());
        assertTrue(pix.validarMetodo());
        assertFalse(invalido.validarMetodo());
    }
}
