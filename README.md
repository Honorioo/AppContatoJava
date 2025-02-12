# API Java - Pessoas e Contatos

Sobre o Projeto

Esta é uma API desenvolvida em Java que gerencia informações de pessoas e seus respectivos contatos.
A API foi projetada para ser simples e eficiente, permitindo operações CRUD (Create, Read, Update, Delete) em ambas as entidades.

## Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Banco de Dados (ex: H2, PostgreSQL, MySQL)

Swagger para documentação da API


## Clonar o Repositório

  git clone https://github.com/seu-usuario/nome-do-repositorio.git
  cd nome-do-repositorio
  

## Acessando a Documentação Swagger

Após iniciar a API, você pode acessar a documentação interativa via Swagger no seguinte link:

http://localhost:8080/swagger-ui/index.html


## Endpoints Principais

Abaixo estão alguns dos endpoints disponíveis:

### Pessoas

GET api/pessoas - Lista todas as pessoas

POST api/pessoas - Cadastra uma nova pessoa

GET api/pessoas/maladireta/{id} - Retorna uma pessoa pelo ID

PUT api/pessoas/{id} - Atualiza os dados de uma pessoa

DELETE api/pessoas/{id} - Remove uma pessoa

### Contatos

GET api/contato - Lista todos os contatos

POST api/contato - Adiciona um novo contato

GET api/contato/{id} - Retorna um contato pelo ID

PUT api/contato/{id} - Atualiza um contato

DELETE api/contato/{id} - Remove um contato
