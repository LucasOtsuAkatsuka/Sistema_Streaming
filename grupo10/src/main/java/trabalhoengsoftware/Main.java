package trabalhoengsoftware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializando entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Inicializando listas
        List<Pessoa> pessoas = new ArrayList<>();
        List<Conteudo> conteudos = new ArrayList<>();

        // Inicia o sistema sem nenhuma conta logada
        Pessoa contaLogada = null;

        int opcao = -1;

        // Variavel que indica se há alguma conta logada
        boolean loginSucesso = false;

        // Instanciando 5 conteúdos
        conteudos.add(new Filme(
                "A Origem",
                2010,
                Arrays.asList("Português", "Inglês", "Espanhol"),
                Arrays.asList("Português", "Inglês"),
                "Um ladrão que invade sonhos tenta redimir-se realizando um último trabalho impossível.",
                Arrays.asList("Leonardo DiCaprio", "Ellen Page", "Joseph Gordon-Levitt"),
                "Christopher Nolan",
                Arrays.asList("Ficção Científica", "Ação", "Drama"),
                148));

        conteudos.add(new Serie(
                "Stranger Things",
                2016,
                Arrays.asList("Português", "Inglês"),
                Arrays.asList("Português", "Inglês"),
                "Um grupo de crianças enfrenta eventos sobrenaturais em uma pequena cidade.",
                Arrays.asList("Millie Bobby Brown", "Finn Wolfhard", "David Harbour"),
                "The Duffer Brothers",
                Arrays.asList("Ficção Científica", "Mistério", "Drama"),
                4,
                10));

        conteudos.add(new Filme(
                "Clube da Luta",
                1999,
                Arrays.asList("Português", "Inglês"),
                Arrays.asList("Português", "Inglês"),
                "Um homem insone cria um clube secreto de luta como forma de terapia.",
                Arrays.asList("Brad Pitt", "Edward Norton", "Helena Bonham Carter"),
                "David Fincher",
                Arrays.asList("Drama", "Suspense"),
                139));

        conteudos.add(new Filme(
                "O Senhor dos Anéis: A Sociedade do Anel",
                2001,
                Arrays.asList("Português", "Inglês", "Espanhol"),
                Arrays.asList("Português", "Inglês"),
                "Frodo e seus amigos embarcam em uma jornada para destruir o Anel do Poder.",
                Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"),
                "Peter Jackson",
                Arrays.asList("Fantasia", "Aventura", "Drama"),
                178));

        conteudos.add(new Serie(
                "Breaking Bad",
                2008,
                Arrays.asList("Português", "Inglês"),
                Arrays.asList("Português", "Inglês"),
                "Um professor de química com câncer terminal começa a fabricar metanfetamina.",
                Arrays.asList("Bryan Cranston", "Aaron Paul", "Anna Gunn"),
                "Vince Gilligan",
                Arrays.asList("Drama", "Suspense", "Crime"),
                5,
                7));

        do {

            if (!loginSucesso) {

                System.out.println("\n************************************************************");
                System.out.println(
                        "Bem Vindo ao Sistema de Streaming de Filmes e Séries");
                System.out.println("\n************************************************************");
                System.out.println(
                        "\nVocê Deseja: ");
                System.out.println("1. Registrar Conta");
                System.out.println("2. Logar");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        // Coletando os dados para criação da conta do usuario
                        System.out.print("\nNome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        boolean ehAdm;

                        System.out.print("Digite: 1 - Se for administrador e 2 - Se for usuário: ");
                        int escolha = scanner.nextInt();
                        if (escolha == 1) {
                            ehAdm = true;
                        } else {
                            ehAdm = false;
                        }
                        if (ehAdm) {
                            ehAdm = true;
                            // Criando de fato a conta administrador
                            Administrador newAdministrador = new Administrador(nome, email, senha);
                            pessoas.add(newAdministrador);
                            System.out.print("\n\n");
                            System.out.println("********************************************");
                            System.out.println(
                                    "Administrador cadastrado com sucesso, Espero que tenha um bom gerenciamento!!!");
                            // System.out.println(newAdministrador);
                            System.out.println("\n********************************************");
                            System.out.print("\n\n");
                        } else {
                            // criando de fato a conta do usuário
                            ehAdm = false;
                            System.out.print("\n\n");
                            System.out.println("********************************************");
                            System.out.print(
                                    "usuário cadastrado com sucesso!");
                            Usuario newUsuario = new Usuario(nome, email, senha);
                            pessoas.add(newUsuario);
                            // System.out.println(newUsuario);
                            System.out.println("\n********************************************");
                            System.out.print("\n\n");
                        }
                        break;
                    case 2:
                        // Efetuando o login
                        System.out.print("Email: ");
                        email = scanner.nextLine();
                        System.out.print("Senha: ");
                        senha = scanner.nextLine();

                        // verificando se os dados estão corretos para efetuar o login
                        for (Pessoa pessoa : pessoas) {
                            if (pessoa.login(email, senha)) {
                                contaLogada = pessoa;
                                loginSucesso = true;
                                System.out.println("\n");
                                if (contaLogada instanceof Usuario) {
                                    System.out.println("Login realizado com sucesso! Bem-vindo, "
                                            + contaLogada.getNome() + " (Usuário).\n");
                                } else if (contaLogada instanceof Administrador) {
                                    System.out.println("Login realizado com sucesso! Bem-vindo, "
                                            + contaLogada.getNome() + " (Administrador).\n");
                                }
                            }
                        }
                        if (!loginSucesso) {
                            System.out.println("\nCredenciais inválidas. Tente novamente.\n");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

                // Se tiver conta logada e for usuário
            } else if (loginSucesso && contaLogada.isEhAdm() == false) {
                System.out.println("\n************************************************************");
                System.out.println(
                        "Bem Vindo, " + contaLogada.getNome());
                System.out.println("\n************************************************************");
                System.out.println(
                        "\nVocê Deseja: ");

                Usuario usuarioLogado = (Usuario) contaLogada;

                if (usuarioLogado.isAssinante()) {
                    System.out.println("1. Cancelar Assinatura");
                    System.out.println("2. gerenciar Perfis");
                } else {
                    System.out.println("1. Virar Assinante");
                }

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        if (usuarioLogado.isAssinante()) {
                            // Cancelar a assinatura
                            usuarioLogado.cancelarAssinatura();
                        } else {
                            // Tornar-se assinante
                            System.out.print("Escolha o método de pagamento (Cartão ou Pix): ");
                            String metodoPagamento = scanner.nextLine();
                            MetodoPagamento pagamento = new MetodoPagamento(metodoPagamento);

                            int opcao1;
                            String tipoAssinatura;
                            System.out.println("Tipo de Assinatura: ");
                            System.out.println("1 - Premium / 2 - Comum");
                            opcao1 = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcao1) {
                                case 1:
                                    tipoAssinatura = "Premium";
                                    break;
                                case 2:
                                    tipoAssinatura = "Comum";
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    tipoAssinatura = "Comum";
                                    break;
                            }
                            Assinatura novaAssinatura = new Assinatura(pagamento, tipoAssinatura);
                            usuarioLogado.fazerAssinatura(novaAssinatura);

                            System.out.println("Parabéns! Você agora é assinante!");
                        }
                        break;
                    case 2:
                        if (usuarioLogado.isAssinante()) {
                            usuarioLogado.gerenciarPerfis();
                        } else {
                            System.out.println("Opção inválida");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } else if (loginSucesso && contaLogada.isEhAdm() == true) {
                System.out.println("\n************************************************************");
                System.out.println(
                        "Bem Vindo Administrador, " + contaLogada.getNome());
                System.out.println("\n************************************************************");
                System.out.println(
                        "\nVocê Deseja: ");
                System.out.println("1. Gerenciar Conteúdos");
                System.out.println("2. Deletar Usuário");
                System.out.println("3. Deslogar");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    // Gerenciar conteúdos
                    case 1:
                        boolean gerenciarConteudo = true;
                        System.out.println("\n********** Gerenciar Conteúdo **********");
                        System.out.println("1. Adicionar Conteúdo");
                        System.out.println("2. Deletar Conteúdo");
                        System.out.println("3. Editar Conteúdo");
                        System.out.println("4. Listar Conteúdos");
                        System.out.println("0. Voltar");

                        opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {

                            // Adicionar conteúdo
                            case 1:

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
                                break;

                            // Deletar Conteúdo
                            case 2:
                                System.out.println("\nConteúdos Disponíveis:");
                                for (int i = 0; i < conteudos.size(); i++) {
                                    System.out.println((i + 1) + ". " + conteudos.get(i).getTitulo());
                                }

                                System.out.print("Escolha o número do conteúdo a ser deletado: ");
                                int indexDeletar = scanner.nextInt() - 1;
                                scanner.nextLine();

                                if (indexDeletar >= 0 && indexDeletar < conteudos.size()) {
                                    System.out.println("Conteúdo " + conteudos.get(indexDeletar).getTitulo()
                                            + " deletado com sucesso.");
                                    conteudos.remove(indexDeletar);
                                } else {
                                    System.out.println("Índice inválido.");
                                }
                                break;

                            // Editar Conteúdo
                            case 3:
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
                                    if (!novoTitulo.isEmpty())
                                        conteudoEditar.setTitulo(novoTitulo);

                                    // Editar Ano de Produção
                                    System.out.print("Novo Ano de Produção (ou 0 para manter): ");
                                    int novoAno = scanner.nextInt();
                                    scanner.nextLine();
                                    if (novoAno != 0)
                                        conteudoEditar.setAnoDeProducao(novoAno);

                                    // Editar Legendas Disponíveis
                                    System.out.print(
                                            "Novas Legendas Disponíveis (separadas por vírgula, ou Enter para manter): ");
                                    String novasLegendas = scanner.nextLine();
                                    if (!novasLegendas.isEmpty()) {
                                        conteudoEditar.setLegendasDisponiveis(Arrays.asList(novasLegendas.split(",")));
                                    }

                                    // Editar Áudios Disponíveis
                                    System.out.print(
                                            "Novos Áudios Disponíveis (separados por vírgula, ou Enter para manter): ");
                                    String novosAudios = scanner.nextLine();
                                    if (!novosAudios.isEmpty()) {
                                        conteudoEditar.setAudiosDisponiveis(Arrays.asList(novosAudios.split(",")));
                                    }

                                    // Editar Descrição
                                    System.out.print("Nova Descrição (ou Enter para manter): ");
                                    String novaDescricao = scanner.nextLine();
                                    if (!novaDescricao.isEmpty())
                                        conteudoEditar.setDescricao(novaDescricao);

                                    // Editar Nome dos Atores
                                    System.out.print(
                                            "Novos Nomes dos Atores (separados por vírgula, ou Enter para manter): ");
                                    String novosAtores = scanner.nextLine();
                                    if (!novosAtores.isEmpty()) {
                                        conteudoEditar.setNomeAtores(Arrays.asList(novosAtores.split(",")));
                                    }

                                    // Editar Nome do Diretor
                                    System.out.print("Novo Nome do Diretor (ou Enter para manter): ");
                                    String novoDiretor = scanner.nextLine();
                                    if (!novoDiretor.isEmpty())
                                        conteudoEditar.setNomeDiretor(novoDiretor);

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
                                break;

                            case 4:
                                System.out.println("\nLista de Conteúdos:");
                                for (Conteudo conteudo : conteudos) {
                                    System.out.println(
                                            "- " + conteudo.getTitulo() + " (" + conteudo.getAnoDeProducao() + ")");
                                }
                                break;

                            case 0:
                                gerenciarConteudo = false;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                        break;

                    // Deletar Usuários
                    case 2:
                        System.out.println("Usuários Cadastrados:");
                        for (int i = 0; i < pessoas.size(); i++) {
                            if (pessoas.get(i) instanceof Usuario) {
                                System.out.println((i + 1) + ". " + pessoas.get(i).getNome());
                            }
                        }

                        System.out.print("Escolha o número do usuário a ser deletado: ");
                        int indexDeletar = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexDeletar >= 0 && indexDeletar < pessoas.size()
                                && pessoas.get(indexDeletar) instanceof Usuario) {
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
                        break;

                    // Deslogar
                    case 3:
                        System.out.print("Tem certeza que deseja deslogar? (sim/nao): ");
                        String confirmacao = scanner.nextLine();

                        if (confirmacao.equalsIgnoreCase("sim")) {
                            contaLogada.logout();
                            contaLogada = null;
                            loginSucesso = false;
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }

            System.out.println("Deseja sair do sistema? Se sim digite 0, se não, digite qualquer tecla");
            opcao = scanner.nextInt();
            if (opcao == 0) {
                System.out.println("Saindo do Sistema");
            }
        } while (opcao != 0);
    }
}