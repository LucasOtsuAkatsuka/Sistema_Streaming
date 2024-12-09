package trabalhoengsoftware;
import java.util.List;

public class Relatorio {
    
    private Usuario usuario;
    private List<Conteudo> conteudoAssistido;
    private int tempoTotalAssistidos;

    public String printRelatorio(){
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório do Usuário: ").append(usuario).append("\n");
        relatorio.append("Conteúdo Assistido: \n");

        // Percorre a lista de Conteudo e acessa os detalhes
        for (Conteudo conteudo : this.conteudoAssistido) {
            relatorio.append(" - Título: ").append(conteudo.getTitulo())
                     .append(", Ano de Produção: ").append(conteudo.getAnoDeProducao())
                     .append(", Visualizações: ").append(conteudo.getVizualizacoes()).append("\n");
        }

        relatorio.append("Tempo Total Assistido: ").append(tempoTotalAssistido).append(" minutos\n");

        return relatorio.toString();
    }
}
