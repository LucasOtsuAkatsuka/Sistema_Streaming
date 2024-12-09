package trabalhoengsoftware;

import java.util.List;

public abstract class Conteudo {
    private String titulo;
    private int anoDeProducao;
    private List<String> legendasDisponiveis;
    private List<String> audiosDisponiveis;
    private String descricao;
    private List<String> nomeAtores;
    private String nomeDiretor;
    private int vizualizacoes;
    private List<String> generos;

    public Conteudo(String titulo, int anoDeProducao, List<String> legendasDisponiveis, List<String> audiosDisponiveis,
                    String descricao, List<String> nomeAtores, String nomeDiretor, List<String> generos) {
        this.titulo = titulo;
        this.anoDeProducao = anoDeProducao;
        this.legendasDisponiveis = legendasDisponiveis;
        this.audiosDisponiveis = audiosDisponiveis;
        this.descricao = descricao;
        this.nomeAtores = nomeAtores;
        this.nomeDiretor = nomeDiretor;
        this.generos = generos;
        this.vizualizacoes = 0;
    }

    // Getters para todos os atributos
    public String getTitulo() {
        return titulo;
    }

    public int getAnoDeProducao() {
        return anoDeProducao;
    }

    public List<String> getLegendasDisponiveis() {
        return legendasDisponiveis;
    }

    public List<String> getAudiosDisponiveis() {
        return audiosDisponiveis;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getNomeAtores() {
        return nomeAtores;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public int getVizualizacoes() {
        return vizualizacoes;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setAudiosDisponiveis(List<String> audiosDisponiveis) {
        this.audiosDisponiveis = audiosDisponiveis;
    }

    public void setLegendasDisponiveis(List<String> legendasDisponiveis) {
        this.legendasDisponiveis = legendasDisponiveis;
    }
    

    // Método para incrementar as visualizações
    public void somarVizualizacoes() {
        vizualizacoes++;
    }
}
