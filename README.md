# Screenmatch com Spring Data JPA 🎬

Projeto desenvolvido durante o curso **Persistência de dados e consultas com Spring Data JPA**, da trilha Alura/Oracle ONE.

## 💡 Sobre

Aplicação Spring Boot para cadastro e consulta de séries utilizando:

- ☕ Java com Spring Boot
- 🛠️ Maven
- 🌐 Integração com a API OMDB
- 🗄️ Banco de dados PostgreSQL
- 🔍 Consultas avançadas com Spring Data JPA

## 🔧 Funcionalidades

- Cadastrar séries pela API OMDB
- Consultar séries:
  - Por título
  - Por ator
  - Por categoria (gênero)
  - Por trecho no nome
  - Por avaliação mínima da temporada
  - Por número de episódios por série
  - Por data de lançamento
  - Top 5 séries
  - Séries com mais episódios
  - Por episódio específico

## 🧰 Tecnologias usadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- OMDB API
- Maven
- IntelliJ IDEA

## 🗃️ Banco de dados

A aplicação usa um banco de dados PostgreSQL local.

Para rodar o projeto, é necessário ter o PostgreSQL instalado e criar um banco chamado `screenmatch`.

Exemplo de configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/screenmatch
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


## 🛠️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone git@github.com:JuRSouza/screenmatch_com_jpa.git
