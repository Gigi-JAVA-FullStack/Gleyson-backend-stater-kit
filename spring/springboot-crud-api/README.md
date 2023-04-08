# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring CRUD Api

Este projeto é um modelo para que você possa desenvolver sua primeira aplicação com SpringBoot para provê uma API de cadastro de clientes realiazando as operações de inclusão, alteração, busca e listagem de dados de clientes.

### Tecnologias

* SpringBoot 2.7.4
* SpringDataJpa
* SpringWeb
* SpringTest
* Projeto Lombok
* H2 database
* Postgres - configuração

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






