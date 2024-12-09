package trabalhoengsoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario extends Pessoa {
    private boolean assinante;
    private Assinatura assinatura;
    private List<Perfil> perfis;

    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.assinante = false;
        this.perfis = new ArrayList<>();
    }

    public boolean isAssinante() {
        return assinante;
    }

    public void fazerAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
        this.assinante = true;
        System.out.println(this.getNome() + " agora é assinante do tipo: " + assinatura.getTipoAssinatura());
    }

    public void cancelarAssinatura() {
        this.assinante = false;
        this.assinatura = null;
        System.out.println("Assinatura Cancelada");
    }

    public void gerenciarPerfis() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nGerenciamento de Perfis:");
        System.out.println("1. Adicionar um perfil");
        System.out.println("2. Editar um perfil existente");
        System.out.println("3. Listar perfis existentes");
        System.out.println("4. Deletar perfil");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            // Adicionar novo Perfil
            case 1:
                if (perfis.size() >= 4) {
                    System.out.println("Máximo de 4 perfis alcançado.");
                    return;
                }
                System.out.print("\nDigite o nome do perfil: ");
                String nomePerfil = scanner.nextLine();
                System.out.print("É infantil? (1 - Sim, 0 - Não): ");
                int ehInfantilEscolha = scanner.nextInt();
                boolean ehInfantil = (ehInfantilEscolha == 1);
                scanner.nextLine();
                System.out.println("Digite os gêneros favoritos (separados por vírgula): ");
                String generosInput = scanner.nextLine();

                List<String> generosFavoritos = new ArrayList<>(List.of(generosInput.split(",\\s*")));

                Perfil novoPerfil = new Perfil(nomePerfil, ehInfantil, generosFavoritos);
                perfis.add(novoPerfil);
                System.out.println("Perfil " + nomePerfil + " criado com sucesso.");
                break;

            // Editar Perfil
            case 2:
                if (perfis.isEmpty()) {
                    System.out.println("\nNenhum perfil disponível para editar.");
                    return;
                }
                System.out.println("\nPerfis disponíveis:");
                for (int i = 0; i < perfis.size(); i++) {
                    System.out.println((i + 1) + ". " + perfis.get(i).getNome());
                }
                System.out.print("Escolha o número do perfil que deseja editar: ");
                int indicePerfil = scanner.nextInt() - 1;
                scanner.nextLine();

                if (indicePerfil < 0 || indicePerfil >= perfis.size()) {
                    System.out.println("Perfil inválido.");
                    return;
                }

                Perfil perfilSelecionado = perfis.get(indicePerfil);

                perfilSelecionado.editarPerfil();

                break;

            // Listar Perfis
            case 3:
                if (perfis.isEmpty()) {
                    System.out.println("\nNenhum perfil cadastrado.");
                } else {
                    System.out.println("\nPerfis cadastrados:");
                    for (Perfil perfil : perfis) {
                        System.out.println(perfil.getNome() + " (Infantil: " + perfil.isEhInfantil() + ")");
                    }
                }
                break;

            // Deletar Perfil
            case 4:
                if (perfis.isEmpty()) {
                    System.out.println("\nNenhum perfil disponível para deletar.");
                    return;
                }
                System.out.println("\nPerfis disponíveis:");
                for (int i = 0; i < perfis.size(); i++) {
                    System.out.println((i + 1) + ". " + perfis.get(i).getNome());
                }
                System.out.print("Escolha o número do perfil que deseja deletar: ");
                int indicePerfilDeletar = scanner.nextInt() - 1;
                scanner.nextLine();

                if (indicePerfilDeletar < 0 || indicePerfilDeletar >= perfis.size()) {
                    System.out.println("Perfil inválido.");
                } else {
                    Perfil perfilDeletado = perfis.remove(indicePerfilDeletar);
                    System.out.println("\nPerfil " + perfilDeletado.getNome() + " deletado com sucesso.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void pesquisarConteudo(List<Conteudo> conteudos, String titulo) {
        boolean encontrado = false;

        for (Conteudo conteudo : conteudos) {
            if (conteudo.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                System.out.println("Conteúdo encontrado!");
                System.out.println("Título: " + conteudo.getTitulo());
                System.out.println("Ano de Produção: " + conteudo.getAnoDeProducao());
                System.out.println("Legendas Disponíveis: " + String.join(", ", conteudo.getLegendasDisponiveis()));
                System.out.println("Áudios Disponíveis: " + String.join(", ", conteudo.getAudiosDisponiveis()));
                System.out.println("Descrição: " + conteudo.getDescricao());
                System.out.println("Atores: " + String.join(", ", conteudo.getNomeAtores()));
                System.out.println("Diretor: " + conteudo.getNomeDiretor());
                System.out.println("Gêneros: " + String.join(", ", conteudo.getGeneros()));

                // Caso seja um Filme, mostre a duração
                if (conteudo instanceof Filme) {
                    Filme filme = (Filme) conteudo;
                    System.out.println("Duração: " + filme.getDuracao() + " minutos");
                }

                // Caso seja uma Série, mostre as temporadas e episódios
                if (conteudo instanceof Serie) {
                    Serie serie = (Serie) conteudo;
                    System.out.println("Temporadas: " + serie.getNumeroTemporadas());
                    System.out.println("Episódios por Temporada: " + serie.getEpisodiosPorTemporadas());
                }

                System.out.println("------------------------------------");
            }
        }

        if (!encontrado) {
            System.out.println("Conteúdo com o título \"" + titulo + "\" não encontrado.");
        }
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
}
