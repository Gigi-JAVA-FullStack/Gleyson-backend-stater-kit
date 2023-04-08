# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring CRUD Postgres - Flyway - Api

Este projeto é uma evolução do projeto [springboot-crud-postgres-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-postgres-api) para ilustrar como configuramos o Flyway Database Migrations para gerenciar a evolução/replicação de nosso banco de dados nos respectivos ambientes.
### Tecnologias

* PostgreSQL
* Flyway


### Flyway

Flyway é uma dentre as várias ferramentas que se propõem a trazer ordem e organização para os scripts SQL que são executados no banco de dados, funcionando como um controle de versão do mesmo.

**Recursos**

Uma ferramenta como esta permite:

* Sincronizar o banco de dados com a versão da aplicação;
* Saber quais scripts SQL foram executados ou não;
* Automatizar a execução dos scripts;
* Criar um banco de dados do zero;
* Permite criar um rollback de mudanças no banco de dados (útil em casos raros).


#### **`pom.xml`**
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

#### **`application.properties`**
```shell
## Flyway
#Customizando a pasta de scripts por banco de dados
spring.flyway.check-location=false
spring.flyway.locations=classpath:/db/migration/postgres
spring.jpa.defer-datasource-initialization=false
```
Vamos conhecer as propriedades abaixo:

* `spring.flyway.check-location=false` : nos da a liberdade de definir um diretório para nossos scripts
* `spring.flyway.locations=classpath:/db/migration/postgres` : informamos aonde estarão inseridos nossos scripts `.sql`
* `spring.jpa.defer-datasource-initialization=false` : informamos para o SpringBoot não mais gerenciar a estratégia de geração de scripts sql de forma automática.

> Observe que o banco de dados foi instalado na porta `5432` com usuário `postgres` e senha `postgres` e o `database` que iremos conectar se chamara `crud-api`. Confirme previamente a sua conexão com banco utilizando as ferramentas PGAdmin ou DBeaver. 

O SpringBootDataJpa proporciona uma configuração adicional para bancos de dados que não são em memória, você pode decidir se as tabelas serão criadas/atualmente ou não.

#### **`application.properties`**
```
# -> none / update
spring.jpa.hibernate.ddl-auto=update
```

Se preferir, você também poderá habilitar um console para acompanhar todo comando sql executado em sua aplicação.

```
spring.jpa.show-sql=true
```

### CRUD de Clientes

Vamos realizar as operações básicas relacionadas em uma gestão de clientes:

| Database | HTTP                  | Descrição                                                  |
|----------|-----------------------|------------------------------------------------------------|
| INSERT   | POST:/clientes        | Inclusão de um novo cliente                                |
| UPDATE   | PUT:/clientes         | Alteraração do cliente cadastrado                          |
| SELECT   | GET:/clientes/{id}    | Busca o cliente pelo ID informado                          |
| DELETE   | DELETE:/clientes/{id} | Remove o cliente da base de dados pelo o ID correspondente |
| SELECT   | GET:/clientes         | Lista todos os clientes na base de dados                   |


