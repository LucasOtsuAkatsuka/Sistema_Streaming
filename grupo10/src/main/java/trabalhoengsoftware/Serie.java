package trabalhoengsoftware;

public class Serie extends Conteudo{
    
    //Atributos
    private int numeroTemporadas;
    private int episodiosPorTemporada;
    private int duracaoEpisodio;

    //Métodos
    Serie(int numeroTemporadas, int episodiosPorTemporada, int duracaoEpisodio){
        this.numeroTemporadas = numeroTemporadas;
        this.episodiosPorTemporada = episodiosPorTemporada;
        this.duracaoEpisodio = duracaoEpisodio;
    }
    public int duracaoTotalSerie(){
        int total = 0;
        total = this.duracaoEpisodio*this.episodiosPorTemporada*this.numeroTemporadas;
        return (total);
    }
}
