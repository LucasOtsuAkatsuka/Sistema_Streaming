package trabalhoengsoftware;

import java.util.List;

public class Serie extends Conteudo {
    private int numeroTemporadas;
    private int[] episodiosPorTemporadas; // Cada posição representa o número de episódios por temporada.

    public Serie(String titulo, int anoDeProducao, List<String> legendasDisponiveis, List<String> audiosDisponiveis,
                 String descricao, List<String> nomeAtores, String nomeDiretor, List<String> generos,
                 int numeroTemporadas, int[] episodiosPorTemporadas) {
        super(titulo, anoDeProducao, legendasDisponiveis, audiosDisponiveis, descricao, nomeAtores, nomeDiretor, generos);
        this.numeroTemporadas = numeroTemporadas;
        this.episodiosPorTemporadas = episodiosPorTemporadas;
    }

    // Getter para o número de temporadas
    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    // Calcula a duração total da série (em minutos)
    public int duracaoTotalSerie(int duracaoMediaPorEpisodio) {
        int totalMinutos = 0;
        for (int episodios : episodiosPorTemporadas) {
            totalMinutos += episodios * duracaoMediaPorEpisodio;
        }
        return totalMinutos;
    }
}
