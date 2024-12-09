package trabalhoengsoftware;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private boolean ehAdm;

    public Pessoa(String nome, String email, String senha, boolean ehAdm) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ehAdm = ehAdm;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isEhAdm() {
        return ehAdm;
    }

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        System.out.println(nome + " fez logout.");
    }
}
