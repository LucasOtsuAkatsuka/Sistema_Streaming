package trabalhoengsoftware;
import java.util.List;

public class Conteudo {
    
    private String titulo;
    private int anoDeProducao;
    private List<String> legendasDisponiveis;
    private List<String> audiosDisponiveis;
    private String descricao;
    private List<String> nomeAtores;
    private String nomeDiretor;
    private int visualizacoes = 0;
    private List<String> generos;
    

    public int somarVizualizacoes(){
        visualizacoes++;
        return visualizacoes;
    };
    
    // Gets
    public String getTitulo(){
        return this.titulo;
    }
    public int getAnoDeProducao(){
        return this.anoDeProducao;
    }
    public List<String> getLegendasDisponiveis(){
        return this.legendasDisponiveis;
    }
    public List<String> getAudiosDisponiveis(){
        return this.audiosDisponiveis;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public List<String> getNomeAtores(){
        return this.nomeAtores;
    }
    public String getNomeDiretor(){
        return this.nomeDiretor;
    }
    public List<String> getGeneros(){
        
        return this.generos;
    }

    //Sets
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAnoDeProducao(int anoDeProducao){
        this.anoDeProducao = anoDeProducao;
    }
    public void setLegendasDisponiveis(List<String> legendasDisponiveis){
        this.legendasDisponiveis = legendasDisponiveis;
    }
    public void setAudiosDisponiveis(List<String> audiosDisponiveis){
        this.audiosDisponiveis = audiosDisponiveis;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setNomeAtores(List<String> nomeAtores){
        this.nomeAtores = nomeAtores;
    }
    public void setNomeDiretor(String nomeDiretor){
        this.nomeDiretor = nomeDiretor;
    }
    public void setGeneros(List<String> generos){
        this.generos = generos;
    }
    
}
