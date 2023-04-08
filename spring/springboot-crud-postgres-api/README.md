# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring CRUD Postgres Api

Este projeto é uma evolução do projeto [springboot-crud-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-api) para ilustrar como configuramos uma conexão com o PostgreSQL.

### Tecnologias

* PostgreSQL
* PGAdmin
* ou Debeaver

### Configuração

Para habilitar uma conexão PostgreSQL em um projeto Spring, basta realizar duas operações:

#### **`pom.xml`**
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

> REMOVA A DEPENDÊNCIA DE OUTROS DRIVERS DE BANCO DE DADOS

#### **`application.properties`**
```shell
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/crud-api
spring.datasource.username=postgres
spring.datasource.password=postgres
```

> Observe que o banco de dados foi instalado na porta `5432` com usuário `postgres` e senha `postgres` e o `database` que iremos conectar se chamara `crud-api`. Confirme previamente a sua conexão com banco utilizando as ferramentas PGAdmin ou DBeaver. 

