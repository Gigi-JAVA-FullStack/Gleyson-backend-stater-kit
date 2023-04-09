# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring JWT Authentication - Api

Este projeto tem por finalidade implementar uma camada de autenticação utilizando Spring Security e JWT.

### Tecnologias

* Spring Security
* JWT

A autenticação é um processo de segurança para verificar a veracidade e autenticidade de uma pessoa ou objeto. O tema da autenticação de um indivíduo, entidade ou objeto não é algo novo, dado que a palavra "autêntico" vem do grego "authentikos", que significa "original, genuíno". Portanto, a autenticação é baseada na comparação e correspondência para determinar se algo ou alguém é, de fato, o que ou quem afirmam ser.

### JWT

O JSON Web Token é um padrão da Internet para a criação de dados com assinatura opcional e/ou criptografia cujo payload contém o JSON que afirma algum número de declarações. Os tokens são assinados usando um segredo privado ou uma chave pública/privada

### Infraestrutura

Vamos começar pela criação dos pacotes `infra.security`, `infra.security.jwt` que terão o papel de agrupar classes que representam configurações e meios de autenticação em nossa aplicação no JWT:

| Classe                           | Descrição                                                                                                                |
|----------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| infra.security.Session           | Classe que representa a sessão de um usuário contendo o `username` e o `token`                                           |
| infra.security.jwt.JwtObject     | Classe que representará o jwt-token para ser convertido em Json e vice-versa.                                            |
| infra.security.jwt.JwtFactory    | Classe responsável por criar o jwt-token em forma objeto e string                                                        |
| infra.security.jwt.JwtProperties | Classe que contém propriedades de `prefixo`, `chave privada` e `tempo de expiração` do token vindo do `application.properties` |

### Configuração

#### **`pom.xml`**
```xml
<!-- Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.7.0</version>
</dependency>
```

#### **`application.properties`**
```shell
## Parametros de configuracao do Token
jwt.properties.prefix=Bearer
jwt.properties.key=MyKey
## 4 horas -> 60 x 60 x 4
jwt.properties.expiration=14400
```
