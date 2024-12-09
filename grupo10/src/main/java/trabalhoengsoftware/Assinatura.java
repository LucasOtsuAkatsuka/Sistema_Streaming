package trabalhoengsoftware;

import java.time.LocalDate;

public class Assinatura {
    private MetodoPagamento metodoPagamento;
    private LocalDate dataInicio;
    private String tipoAssinatura;

    public Assinatura(MetodoPagamento metodoPagamento, String tipoAssinatura) {
        this.metodoPagamento = metodoPagamento;
        this.dataInicio = LocalDate.now();
        this.tipoAssinatura = tipoAssinatura;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }
}
