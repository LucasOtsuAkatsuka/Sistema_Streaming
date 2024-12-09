package trabalhoengsoftware;

import java.util.List;
import java.util.Scanner;

public class Perfil {
    private String nome;
    private boolean ehInfantil;
    private List<String> generosFavoritos;
    private Relatorio relatorio;

    public Perfil(String nome, boolean ehInfantil, List<String> generosFavoritos) {
        this.nome = nome;
        this.ehInfantil = ehInfantil;
        this.generosFavoritos = generosFavoritos;
    }

    public void editarPerfil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 1 para editar o nome");
        System.out.println("Digite 2 para editar se é infantil");
        System.out.println("Digite 3 para gerenciar os gêneros favoritos");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome do perfil: ");
                String novoNome = scanner.nextLine();
                this.nome = novoNome;
                System.out.println("Nome do perfil atualizado para: " + nome);
                break;

            case 2:
                System.out.print("É infantil? (1 - Sim, 0 - Não): ");
                int ehInfantilEscolha = scanner.nextInt();
                boolean ehInfantilNovo = (ehInfantilEscolha == 1);
                scanner.nextLine();
                this.ehInfantil = ehInfantilNovo;
                System.out.println("Restrição infantil atualizada para: " + ehInfantil);
                break;

            case 3:
                gerenciarGeneros(scanner);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public void aplicarRestricoes() {
        if (ehInfantil) {
            System.out.println("Restrições infantis aplicadas ao perfil " + nome);
        } else {
            System.out.println("Perfil " + nome + " sem restrições infantis.");
        }
    }

    private void gerenciarGeneros(Scanner scanner) {
        while (true) {
            System.out.println("\nGêneros favoritos atuais: " + generosFavoritos);
            System.out.println("Digite 1 para adicionar um gênero");
            System.out.println("Digite 2 para remover um gênero");
            System.out.println("Digite 3 para sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o gênero que deseja adicionar: ");
                    String generoAdicionar = scanner.nextLine();
                    if (!generosFavoritos.contains(generoAdicionar)) {
                        generosFavoritos.add(generoAdicionar);
                        System.out.println("Gênero adicionado: " + generoAdicionar);
                    } else {
                        System.out.println("O gênero já está na lista.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o gênero que deseja remover: ");
                    String generoRemover = scanner.nextLine();
                    if (generosFavoritos.contains(generoRemover)) {
                        generosFavoritos.remove(generoRemover);
                        System.out.println("Gênero removido: " + generoRemover);
                    } else {
                        System.out.println("O gênero não está na lista.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo da gestão de gêneros.");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean isEhInfantil() {
        return ehInfantil;
    }

    public List<String> getGenerosFavoritos() {
        return generosFavoritos;
    }
}
