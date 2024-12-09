package trabalhoengsoftware;

import java.util.List;

public class Filme extends Conteudo {
    private int duracao;

    public Filme(String titulo, int anoDeProducao, List<String> legendasDisponiveis, List<String> audiosDisponiveis,
            String descricao, List<String> nomeAtores, String nomeDiretor, List<String> generos, int duracao) {
        super(titulo, anoDeProducao, legendasDisponiveis, audiosDisponiveis, descricao, nomeAtores, nomeDiretor,
                generos);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }
}
