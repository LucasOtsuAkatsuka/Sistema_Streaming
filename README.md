# Sistema de Streaming

## Descrição

Este documento apresenta a especificação, o projeto arquitetural e o
detalhamento do sistema de streaming, projetado para oferecer uma experiência eficiente
para os usuários na navegação, personalização de perfis, e consumo de conteúdos. O
sistema é voltado tanto para usuários finais quanto para administradores, garantindo
flexibilidade no gerenciamento de assinaturas, conteúdo e relatórios e formas de
pagamentos.
O objetivo principal do sistema é permitir que os usuários encontrem, assistam e
gerenciem conteúdos de maneira simplificada, enquanto administradores possam
gerenciar os usuários e os conteúdos do sistema. A aplicação segue uma arquitetura
multicamadas.
Além disso, esta documentação detalha os requisitos funcionais através de diagramas de
casos de uso, descreve os cenários de interação dos atores com o sistema, apresenta a
arquitetura projetada com diagramas de componentes, e explora o projeto detalhado com
diagramas de classes, sequência e atividades.


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
## Casos de uso

![Captura de tela 2025-02-14 195438](https://github.com/user-attachments/assets/d86b91d9-2cb2-45da-85c2-11b56351ba5a)

## Diagrama dos casos de uso

![Diagrama sem nome drawio (4)](https://github.com/user-attachments/assets/0627c6a2-2b83-4284-b0f3-053440f02e14)


## Arquitetura

![Captura de tela 2025-02-14 195913](https://github.com/user-attachments/assets/f4db96c3-9299-46cd-af7d-41b895311074)

## Diagrama de Classes

![Diagrama sem nome drawio (6)](https://github.com/user-attachments/assets/46cc1ace-0273-4e8c-ba75-47e0095f36a6)


## Autores

- **Lucas Jun Otsu Akatsuka**
