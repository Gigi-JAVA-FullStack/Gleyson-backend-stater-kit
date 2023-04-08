# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring CRUD Api

Este projeto é um modelo para que você possa desenvolver sua primeira aplicação com SpringBoot para provê uma API de cadastro de clientes realiazando as operações de inclusão, alteração, busca e listagem de dados de clientes.

### Tecnologias

* Java 1.8+
* SpringBoot 2.7.4
* SpringDataJpa
* SpringWeb
* SpringTest
* Projeto Lombok
* H2 database
* Postgres - configuração
* Swagger OpenAPI

### Dependências

Um projeto SpringBoot é formada por dependência denominadas de **starters** e o nosso projeto por ser uma API Rest especificante utilizará os starters citados no `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### Projeto Lombok

O Lombok é uma biblioteca Java focada em produtividade e redução de código boilerplate que, por meio de anotações adicionadas ao nosso código, ensinamos o compilador (maven ou gradle) durante o processo de compilação a criar código Java.

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

#### Persistência de dados

O SpringBoot é facildade configurável a qualquer provedor de acesso a dados como H2Database, PostgreSQL, MySQL, SQLServer, Oracle Database entre outros, basta informar a biblioteca correspondente e configurar a sua conexão de bancos de dados no arquivo `resources/application.properties`.

*Configurando o banco em memória H2Database*

#### **`pom.xml`**
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

#### **`application.properties`**
```shell
spring.datasource.url=jdbc:h2:mem:crud-api
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

#### Documentação da API

O Swagger é um framework composto por diversas ferramentas que, independente da linguagem, auxilia a descrição, consumo e visualização de serviços de uma API REST.

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.4</version>
</dependency>
```

### Estrutura do projeto

O projeto é composto por pacotes que classificam as classes de acordo com o seu papel ou finalidades específicas.

O pacote principal é `digytal.backend.api`.

| Nome       | Descrição                                                                                      |
|------------|------------------------------------------------------------------------------------------------|
| enums      | pacote que contém os enums do sistema                                                          |
| model      | pacote que contém as classes de modelo do sistema (entidades e dtos)                           |
| repository | pacote que contém as interfaces responsáveis pela persistência de cada entidade correspondente |
| service    | pacote que contém as classes responsáveis por gerencias as regras de negóicio da aplicação.    |
| webservice | pacote que contém as classes que representam os recursos https disponíveis pela aplivação      |

### Model

As aplicações costumam separar a camada de domínio (Entity) com a camada de transferência de dados (DTO) para manter a segurança no que se refere ao acesso à dados.
Para implementar nosso projeto seguindo esta diretriz, organizando a nossa camada de modelo contendo três arquivos comuns para cada entidade da aplicação.

* Entity - Classe mapeada com JPA para representar uma tabela no banco de dados
* Request - Classe que será utilizada para realizar operações de inclusão e alteração de registros
* Response - Classe que representa a resposta no formato JSon das consultas realizadas pela aplicação.






