# Digytal - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit - Spring Send Email - Api

Este projeto tem por finalidade implementar o envio de e-mail contendo a senha padrão dos usuários do sistemas. Ver projeto inicial em [springboot-jwt-database-roles-authentication](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-jwt-database-roles-authentication).

### Tecnologias

* Spring Security
* Spring Email
* G-Mail

## Configuração

Habilitar o envio de e-mail pelo SpringBoot integrando ao G-Mail hoje é uma tarefa bem simples, siga as instruções abaixo:

1. Adicione a dependência (starter) do `spring-boot-starter-mail`

#### **`pom.xml`**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

2. Configure as propriedades para envio de e-mail

#### **`application.properties`**
```shell
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=gleyson@digytal.com.br
spring.mail.password=** SUA_SENHA **
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.enable=false
spring.mail.test-connection=false
```

>Duas observações em relação a configuração acima, primeira seu e-mail e senha **NÃO PODEM** estar diretamente no `application.properties` e sim na configuração de seu servidor ou container e o G-Mail recomanda **NÃO USAR** sua senha pessoal, mas sim criar uma senha para esta finalidade em específica.