package trabalhoengsoftware;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Administrador extends Pessoa {
    private String cargo;

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha, true);
        this.cargo = "administrador";
    }

    public void gerenciarConteudos(List<Conteudo> conteudos) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean gerenciarConteudo = true;

        while (gerenciarConteudo) {
            System.out.println("\n********** Gerenciar Conteúdo **********");
            System.out.println("1. Adicionar Conteúdo");
            System.out.println("2. Deletar Conteúdo");
            System.out.println("3. Editar Conteúdo");
            System.out.println("4. Listar Conteúdos");
            System.out.println("0. Voltar");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarConteudo(scanner, conteudos);
                    break;
                case 2:
                    deletarConteudo(scanner, conteudos);
                    break;
                case 3:
                    editarConteudo(scanner, conteudos);
                    break;
                case 4:
                    listarConteudos(conteudos);
                    break;
                case 0:
                    gerenciarConteudo = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void gerenciarUsuarios(List<Pessoa> pessoas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuários Cadastrados:");
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Usuario) {
                System.out.println((i + 1) + ". " + pessoas.get(i).getNome());
            }
        }

        System.out.print("Escolha o número do usuário a ser deletado: ");
        int indexDeletar = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexDeletar >= 0 && indexDeletar < pessoas.size() && pessoas.get(indexDeletar) instanceof Usuario) {
            Usuario usuarioDeletar = (Usuario) pessoas.get(indexDeletar);
            System.out.println("\nDeletando o usuário: " + usuarioDeletar.getNome());

            System.out.print("Tem certeza que deseja deletar o usuário? (sim/nao): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("sim")) {
                pessoas.remove(usuarioDeletar);
                System.out.println("Usuário " + usuarioDeletar.getNome() + " deletado com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Índice inválido ou usuário não encontrado.");
        }
    }

    public void adicionarConteudo(Scanner scanner, List<Conteudo> conteudos) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ano de Produção: ");
        int anoDeProducao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Legendas Disponíveis (separadas por vírgula): ");
        List<String> legendasDisponiveis = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Áudios Disponíveis (separados por vírgula): ");
        List<String> audiosDisponiveis = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Nome dos Atores (separados por vírgula): ");
        List<String> nomeAtores = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Nome do Diretor: ");
        String nomeDiretor = scanner.nextLine();

        System.out.print("Gêneros (separados por vírgula): ");
        List<String> generos = Arrays.asList(scanner.nextLine().split(","));

        System.out.println("Tipo de Conteúdo: ");
        System.out.println("1. Filme");
        System.out.println("2. Série");

        int tipoConteudo = scanner.nextInt();
        scanner.nextLine();

        if (tipoConteudo == 1) {
            System.out.print("Duração do Filme (em minutos): ");
            int duracao = scanner.nextInt();
            scanner.nextLine();

            Filme filme = new Filme(titulo, anoDeProducao, legendasDisponiveis,
                    audiosDisponiveis, descricao,
                    nomeAtores, nomeDiretor, generos, duracao);
            conteudos.add(filme);
            System.out.println("Filme adicionado com sucesso!");
        } else if (tipoConteudo == 2) {
            System.out.print("Número de Temporadas: ");
            int temporadas = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Número de Episódios por Temporada: ");
            int episodiosPorTemporadas = scanner.nextInt();
            scanner.nextLine();

            Serie serie = new Serie(titulo, anoDeProducao, legendasDisponiveis,
                    audiosDisponiveis, descricao,
                    nomeAtores, nomeDiretor, generos, temporadas, episodiosPorTemporadas);
            conteudos.add(serie);
            System.out.println("Série adicionada com sucesso!");
        } else {
            System.out.println("Opção inválida. Conteúdo não adicionado.");
        }
    }

    public void deletarConteudo(Scanner scanner, List<Conteudo> conteudos) {
        System.out.println("\nConteúdos Disponíveis:");
        for (int i = 0; i < conteudos.size(); i++) {
            System.out.println((i + 1) + ". " + conteudos.get(i).getTitulo());
        }

        System.out.print("Escolha o número do conteúdo a ser deletado: ");
        int indexDeletar = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexDeletar >= 0 && indexDeletar < conteudos.size()) {
            System.out.println("Conteúdo " + conteudos.get(indexDeletar).getTitulo() + " deletado com sucesso.");
            conteudos.remove(indexDeletar);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void editarConteudo(Scanner scanner, List<Conteudo> conteudos) {
        System.out.println("Conteúdos Disponíveis:");
        for (int i = 0; i < conteudos.size(); i++) {
            System.out.println((i + 1) + ". " + conteudos.get(i).getTitulo());
        }

        System.out.print("Escolha o número do conteúdo a ser editado: ");
        int indexEditar = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexEditar >= 0 && indexEditar < conteudos.size()) {
            Conteudo conteudoEditar = conteudos.get(indexEditar);
            System.out.println("\nEditando o conteúdo: " + conteudoEditar.getTitulo());

            // Editar Título
            System.out.print("Novo Título (ou Enter para manter): ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isEmpty()) {
                conteudoEditar.setTitulo(novoTitulo);
            }

            // Editar Ano de Produção
            System.out.print("Novo Ano de Produção (ou 0 para manter): ");
            int novoAno = scanner.nextInt();
            scanner.nextLine();
            if (novoAno != 0) {
                conteudoEditar.setAnoDeProducao(novoAno);
            }

            // Editar Legendas Disponíveis
            System.out.print("Novas Legendas Disponíveis (separadas por vírgula, ou Enter para manter): ");
            String novasLegendas = scanner.nextLine();
            if (!novasLegendas.isEmpty()) {
                conteudoEditar.setLegendasDisponiveis(Arrays.asList(novasLegendas.split(",")));
            }

            // Editar Áudios Disponíveis
            System.out.print("Novos Áudios Disponíveis (separados por vírgula, ou Enter para manter): ");
            String novosAudios = scanner.nextLine();
            if (!novosAudios.isEmpty()) {
                conteudoEditar.setAudiosDisponiveis(Arrays.asList(novosAudios.split(",")));
            }

            // Editar Descrição
            System.out.print("Nova Descrição (ou Enter para manter): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) {
                conteudoEditar.setDescricao(novaDescricao);
            }

            // Editar Nome dos Atores
            System.out.print("Novos Nomes dos Atores (separados por vírgula, ou Enter para manter): ");
            String novosAtores = scanner.nextLine();
            if (!novosAtores.isEmpty()) {
                conteudoEditar.setNomeAtores(Arrays.asList(novosAtores.split(",")));
            }

            // Editar Nome do Diretor
            System.out.print("Novo Nome do Diretor (ou Enter para manter): ");
            String novoDiretor = scanner.nextLine();
            if (!novoDiretor.isEmpty()) {
                conteudoEditar.setNomeDiretor(novoDiretor);
            }

            // Editar Gêneros
            System.out.print("Novos Gêneros (separados por vírgula, ou Enter para manter): ");
            String novosGeneros = scanner.nextLine();
            if (!novosGeneros.isEmpty()) {
                conteudoEditar.setGeneros(Arrays.asList(novosGeneros.split(",")));
            }

            System.out.println("Conteúdo atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    void listarConteudos(List<Conteudo> conteudos) {
        System.out.println("\nLista de Conteúdos:");
        for (Conteudo conteudo : conteudos) {
            System.out.println("- " + conteudo.getTitulo() + " (" + conteudo.getAnoDeProducao() + ")");
        }
    }
}
