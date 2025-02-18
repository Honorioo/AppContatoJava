# API Java - Pessoas e Contatos

![GitHub repo size](https://img.shields.io/github/repo-size/Honorioo/AppContatoJava?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/Honorioo/AppContatoJava?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/Honorioo/AppContatoJava?style=for-the-badge)

API desenvolvida em Java para gerenciar informações de pessoas e seus respectivos contatos, permitindo operações CRUD de maneira eficiente.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas para as seguintes tarefas:

- [x] Implementação dos endpoints principais
- [x] Integração com banco de dados H2
- [x] Documentação via Swagger
- [x] Testes unitários

## 💻 Tecnologias Utilizadas

- **Java** - JDK 21  
- **Spring Boot** - versão 3.4.2  
- **Spring Data JPA** - para interações com o banco de dados  
- **Banco de Dados H2** - banco em memória  
- **Swagger** - versão 2.2.0, utilizado para a documentação interativa da API  

## 🚀 Clonando o Repositório

Para instalar e rodar o projeto localmente, siga estas etapas:

```bash
git clone https://github.com/Honorioo/AppContatoJava.git
cd AppContatoJava
```

## 📜 Acessando a Documentação Swagger

Após iniciar a API, você pode acessar a documentação interativa via Swagger no seguinte link:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

## 📌 ENUM de Tipos de Contato

A API utiliza um ENUM para definir os tipos de contato, com os seguintes valores:

- **TELEFONE(0)**  
- **CELULAR(1)**  
- **EMAIL(2)**  
- **REDE_SOCIAL(3)**  

## 📌 Endpoints Principais

### 🧑 Pessoas

- **GET** `/api/pessoas` - Lista todas as pessoas
- **GET** `/api/pessoas/maladireta/{id}` - Retorna uma pessoa pelo ID
- **POST** `/api/pessoas` - Cadastra uma nova pessoa
- **PUT** `/api/pessoas/{id}` - Atualiza os dados de uma pessoa
- **DELETE** `/api/pessoas/{id}` - Remove uma pessoa

### 📞 Contatos

- **GET** `/api/contato` - Lista todos os contatos
- **GET** `/api/contato/{id}` - Retorna um contato pelo ID
- **POST** `/api/contato` - Adiciona um novo contato
- **PUT** `/api/contato/{id}` - Atualiza um contato
- **DELETE** `/api/contato/{id}` - Remove um contato

##

✉️ Desenvolvido por <a href="https://github.com/Honorioo"> Vinicius Honorio
