
## API GraphQL de Gerenciamento de Livros
Este projeto é uma API GraphQL construída com Spring Boot para gerenciamento de livros. Ele demonstra os conceitos básicos de GraphQL em Java, incluindo queries, mutations e integração com banco de dados.
## Pré-requisitos
- Java JDK 11+

- Maven 3.6+

- IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

- H2 - banco em memória (obs: se atente a url no properties "jdbc:...")
## Configuração do Ambiente
#### 1) Clone o repositório: git clone https://github.com/giovanieugenio1/graphql-api.git

#### 2) Extraia o projeto e adicione a sua IDE.

#### 3) Execute o projeto no terminal com:
     mvn spring-boot:run


## Acessando a API

#### GraphiQL (Interface interativa):
- URL: http://localhost:8080/graphiql

#### Endpoint GraphQL:
- Mutation (Adicionar novo livro)

        mutation {
            addBook(
                title: "Domain-Driven Design",
                author: "Eric Evans",
                isbn: "978-0321125217",
                publicationYear: 2003
            ) {
                id
                title
            }
        }

- Mutation (Atualizar um livro existente)

        mutation {
            updateBook(
                id: 1,
                title: "Domain-Driven Design: Revised Edition",
                author: "Eric Evans",
                isbn: "978-0321125217",
                publicationYear: 2013
            ) {
                id
                title
                author
                publicationYear
            }
        }

- Mutation (Deletar um livro)

        mutation {
            deleteBook(id: 1)
        }


- Query (Buscar livro por ID)

        query {
            bookById(id: 1) {
                title
                isbn
                publicationYear
            }
        }

- Query (Buscar todos os livros)

        query {
            allBooks {
                id
                title
                author
            }
        }
## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

