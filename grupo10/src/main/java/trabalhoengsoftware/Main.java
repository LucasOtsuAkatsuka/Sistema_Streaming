package trabalhoengsoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializando entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Inicializando listas
        List<Pessoa> pessoas = new ArrayList<>();

        // Inicia o sistema sem nenhuma conta logada
        Pessoa contaLogada = null;

        int opcao = -1;

        // Variavel que indica se há alguma conta logada
        boolean loginSucesso = false;

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
                            System.out.print("\n\n");
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
                                            + contaLogada.getNome() + " (Usuário).");
                                } else if (contaLogada instanceof Administrador) {
                                    System.out.println("Login realizado com sucesso! Bem-vindo, "
                                            + contaLogada.getNome() + " (Administrador).");
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
                System.out.println("opcoes adm");
            }

            System.out.println("Deseja sair do sistema? Se sim digite 0, se não, digite qualquer tecla");
            opcao = scanner.nextInt();
            if (opcao == 0) {
                System.out.println("Saindo do Sistema");
            }
        } while (opcao != 0);
    }
}