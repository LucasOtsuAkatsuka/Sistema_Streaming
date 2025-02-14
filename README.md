# Sistema de Streaming

## Descrição

O objetivo deste documento é definir os requisitos funcionais e não funcionais para o
desenvolvimento de um sistema de streaming de vídeos. Este sistema permitirá aos
usuários assistirem a conteúdos variados mediante um cadastro prévio, incluindo opções de
perfis personalizáveis, assinaturas pagas e um catálogo diversificado de filmes e séries.
Este projeto está sendo desenvolvido na matéria de Engenharia de software, pelos alunos
da Universidade Federal de Minas Gerais.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Outros**: JUnit, Maven

## 📂 Estrutura do Projeto

O projeto segue a arquitetura **MVC (Model-View-Controller)** e esta organizado da seguinte forma:

```
trabalhoengsoftware/
│── src/
│   ├── main/java/trabalhoengsoftware/   # 📌 Codigo-fonte principal
│   │   ├── Administrador.java           # Classe do administrador do sistema
│   │   ├── Assinatura.java              # Representacao das assinaturas dos usuarios
│   │   ├── Conteudo.java                # Classe base para conteudos (Filmes e Series)
│   │   ├── Filme.java                   # Classe para filmes
│   │   ├── Main.java                     # Classe principal (entry point)
│   │   ├── MetodoPagamento.java         # Metodos de pagamento disponiveis
│   │   ├── Perfil.java                   # Perfis dentro de uma conta
│   │   ├── Pessoa.java                   # Classe base para Usuario e Administrador
│   │   ├── Relatorio.java                # Geracao de relatorios do sistema
│   │   ├── Serie.java                    # Classe para series
│   │   ├── Usuario.java                  # Classe para usuarios do sistema
│   │
│   ├── test/java/trabalhoengsoftware/   # 📌 Testes automatizados (JUnit)
│   │   ├── AdministradorTest.java       # Testes da classe Administrador
│   │   ├── ConteudoTest.java            # Testes da classe Conteudo
│   │   ├── FilmeTest.java               # Testes da classe Filme
│   │   ├── MetodoPagamentoTest.java     # Testes da classe MetodoPagamento
│   │   ├── PerfilTest.java              # Testes da classe Perfil
│   │   ├── PessoaTest.java              # Testes da classe Pessoa
│   │   ├── RelatorioTest.java           # Testes da classe Relatorio
│   │   ├── SerieTest.java               # Testes da classe Serie
│   │   ├── UsuarioTest.java             # Testes da classe Usuario
│
│── target/                               # 📌 Arquivos compilados (gerados pelo Maven/Gradle)
```

## 📌 **Como Rodar o Projeto**

1. Clone este repositorio:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Compile o projeto:
   ```bash
   mvn clean install 
   ```
   
3. Execute a aplicacao:
   ```bash
   java -jar target/nome-do-projeto.jar
   ```

## 🛠 **Testes**

Para rodar os testes unitarios, use:

```bash
mvn test  
```




## Autores

- **Lucas Jun Otsu Akatsuka**
