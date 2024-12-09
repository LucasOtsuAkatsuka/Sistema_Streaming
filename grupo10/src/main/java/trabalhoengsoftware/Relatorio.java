package trabalhoengsoftware;

import java.util.List;

public class Relatorio {
    private List<Conteudo> conteudoAssistido;
    private int tempoTotalAssistido;

    public Relatorio(List<Conteudo> conteudoAssistido, int tempoTotalAssistido) {
        // this.usuario = usuario;
        this.conteudoAssistido = conteudoAssistido;
        this.tempoTotalAssistido = tempoTotalAssistido;
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Conteúdo Assistido: \n");
        for (Conteudo conteudo : conteudoAssistido) {
            relatorio.append(" - ").append(conteudo.getTitulo()).append(" (").append(conteudo.getAnoDeProducao())
                    .append(")\n");
        }
        relatorio.append("Tempo Total Assistido: ").append(tempoTotalAssistido).append(" minutos\n");
        return relatorio.toString();
    }
}
