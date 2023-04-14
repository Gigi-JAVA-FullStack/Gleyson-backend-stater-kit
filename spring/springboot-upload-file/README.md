# Digytal - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)

#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring Upload File - Api

Este projeto tem a finaliade de disponibilizar uma API para realizar upload e exibição de imagens salvas no disco ou em um banco de dados. O projeto foi baseado no exemplo [springboot-crud-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-api)

### Tecnologias

* Java 1.8+
* SpringBoot 2.7.4
* SpringDataJpa
* Hibernate
* SpringWeb
* Projeto Lombok
* H2 database
* Swagger OpenAPI


#### Configurações adicionais

Vamos definir em nossa configuração um diretório padrão para armazenar as imagens recebidos via upload conforme abaixo:

#### **`application.properties`**
```shell
file.upload.folder=${PRODUCTION_FILE_UPLOAD_FOLDER:c:\\digytal}
```

> O H2 disponibiliza uma interface web para visualizar as tabelas e realizar operações básicas de SQL.

#### **`application.properties`**
```shell
spring.h2.console.enabled=true
```

Acesse o link : `http://localhost:8080/h2-console`

![image](https://github.com/glysns/backend-stater-kit/blob/main/spring/springboot-crud-api/src/main/resources/img/h2-login.png)

![image](https://github.com/glysns/backend-stater-kit/blob/main/spring/springboot-crud-api/src/main/resources/img/h2-sql.png)

#### Refatoração

Para disponibilizar estes recursos com base no CRUD de um Cliente já existente foram realizados os procedimentos abaixo:

1. Alterar a entidade `model.cliente.ClienteEntity` para ter os atributos `photoPath` ou `photoByte`;
2. A classe `service.ClienteService` agora possui mais dois métodos: `changePhotoPath`e `changeEntityPhoto`
3. Criamos a classe `service.FileUploadService` para gerenciar as ações de upload e exibição de arquivos
4. Criamos mais um recurso `webservice.FileUploadResource` para tratar requisições relacionadas a upload de imgagens  


### CRUD de Clientes

Vamos realizar as operações básicas relacionadas em uma gestão de clientes:

| Database | HTTP                  | Descrição                                                  |
|----------|-----------------------|------------------------------------------------------------|
| INSERT   | POST:/clientes        | Inclusão de um novo cliente                                |
| UPDATE   | PUT:/clientes         | Alteraração do cliente cadastrado                          |
| SELECT   | GET:/clientes/{id}    | Busca o cliente pelo ID informado                          |
| DELETE   | DELETE:/clientes/{id} | Remove o cliente da base de dados pelo o ID correspondente |
| SELECT   | GET:/clientes         | Lista todos os clientes na base de dados                   |


