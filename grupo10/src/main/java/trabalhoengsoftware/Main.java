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
                    System.out.println("3. Assistir Conteúdo");
                    System.out.println("4. Pesquisar Conteudo");
                    System.out.println("5. deslogar");
                } else {
                    System.out.println("1. Virar Assinante");
                    System.out.println("2. deslogar");
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
                            System.out.print("Tem certeza que deseja deslogar? (sim/nao): ");
                            String confirmacao = scanner.nextLine();

                            if (confirmacao.equalsIgnoreCase("sim")) {
                                contaLogada.logout();
                                contaLogada = null;
                                loginSucesso = false;
                            } else {
                                System.out.println("Operação cancelada.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("\nConteúdos Disponíveis:");
                        for (int i = 0; i < conteudos.size(); i++) {
                            System.out.println((i + 1) + ". " + conteudos.get(i).getTitulo() + " vizualizações: "
                                    + conteudos.get(i).getVizualizacoes());
                        }

                        System.out.print("Escolha o número do conteúdo a ser assistido: ");
                        int indexAssistir = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indexAssistir >= 0 && indexAssistir < conteudos.size()) {
                            conteudos.get(indexAssistir).somarVizualizacoes();
                            System.out.println("Assistindo " + conteudos.get(indexAssistir).getTitulo());
                        } else {
                            System.out.println("Índice inválido.");
                        }

                        break;
                    case 4:
                        System.out.println("Digite o nome que deseja pesquisar: ");
                        String tituloConteudo = scanner.nextLine();
                        Usuario usuarioLogadoPesquisa = (Usuario) contaLogada;
                        usuarioLogadoPesquisa.pesquisarConteudo(conteudos, tituloConteudo);
                        break;
                    case 5:
                        System.out.print("Tem certeza que deseja deslogar? (sim/nao): ");
                        String confirmacao = scanner.nextLine();

                        if (confirmacao.equalsIgnoreCase("sim")) {
                            contaLogada.logout();
                            contaLogada = null;
                            loginSucesso = false;
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                        break;
                    default:
                }
            } else if (loginSucesso && contaLogada.isEhAdm() == true) {
                Administrador administradorLogado = (Administrador) contaLogada;
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
                        administradorLogado.gerenciarConteudos(conteudos);
                        break;

                    // Deletar Usuários
                    case 2:
                        administradorLogado.gerenciarUsuarios(pessoas);
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