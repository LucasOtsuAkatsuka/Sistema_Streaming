package trabalhoengsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetodoPagamentoTest {

    private MetodoPagamento metodoPagamento;

    @BeforeEach
    public void setUp() {
        // Criando uma instância de MetodoPagamento para realizar os testes
        metodoPagamento = new MetodoPagamento("Cartão de Crédito");
    }

    @Test
    public void testToString() {
        // Testa se o método toString retorna o valor correto do tipo de pagamento
        assertEquals("Cartão de Crédito", metodoPagamento.getTipoPagamento(),
                "O tipo de pagamento não foi retornado corretamente.");
    }

    @Test
    public void testGetTipoPagamento() {
        // Testa se o tipo de pagamento é retornado corretamente
        assertEquals("Cartão de Crédito", metodoPagamento.getTipoPagamento(),
                "O tipo de pagamento não foi retornado corretamente.");
    }

    @Test
    public void testMetodoPagamentoConstructor() {
        // Testa se o construtor funciona corretamente
        MetodoPagamento novoMetodo = new MetodoPagamento("Boleto");
        assertEquals("Boleto", novoMetodo.getTipoPagamento(), "O tipo de pagamento não foi atribuído corretamente.");
    }
}