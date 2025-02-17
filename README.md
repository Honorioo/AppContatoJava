# API Java - Pessoas e Contatos

### Sobre o Projeto

Esta é uma API desenvolvida em Java que gerencia informações de pessoas e seus respectivos contatos. A API foi projetada para ser simples e eficiente, permitindo operações CRUD (Create, Read, Update, Delete) em ambas as entidades.

## Tecnologias Utilizadas
Java - JDK 21

Spring Boot - versão 3.4.2

Spring Data JPA - para interações com o banco de dados

Banco de Dados H2 - banco em memória

Swagger - versão 2.2.0, utilizado para a documentação interativa da API


## Clonar o Repositório
git clone https://github.com/Honorioo/AppContatoJava.git

cd nome-do-repositorio

## Acessando a Documentação Swagger
Após iniciar a API, você pode acessar a documentação interativa via Swagger no seguinte link:

http://localhost:8080/swagger-ui/index.html

## ENUM de Tipos de Contato
A API também utiliza um ENUM para definir os tipos de contato, com os seguintes valores:

TELEFONE(0) - CELULAR(1) - EMAIL(2) - REDE_SOCIAL(3)

## Endpoints Principais
Abaixo estão alguns dos endpoints disponíveis:

### 📌 Pessoas
GET api/pessoas - Lista todas as pessoas

GET api/pessoas/maladireta/{id} - Retorna uma pessoa pelo ID

POST api/pessoas - Cadastra uma nova pessoa

PUT api/pessoas/{id} - Atualiza os dados de uma pessoa

DELETE api/pessoas/{id} - Remove uma pessoa


### 📞 Contatos
GET api/contato - Lista todos os contatos

GET api/contato/{id} - Retorna um contato pelo ID

POST api/contato - Adiciona um novo contato

PUT api/contato/{id} - Atualiza um contato

DELETE api/contato/{id} - Remove um contato

✉️ Desenvolvido por Vinicius Honorio
