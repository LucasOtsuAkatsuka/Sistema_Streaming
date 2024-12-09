package trabalhoengsoftware;

public class Administrador extends Pessoa {
    private String cargo;

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha, true);
        this.cargo = "administrador";
    }

    public void gerenciarUsuarios() {
        System.out.println(this.getNome() + " está gerenciando os usuários do sistema.");
    }
}
