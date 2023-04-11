# Digytal - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## BackEnd - StarterKit

Bem-vindo a mais um projeto proporcionado pela Digytal para te auxiliar e te dar um direcionamento para criar suas primeiras aplicações back-end mediante requisitos do mercado.
Este repositório consiste em oferecer um MVP ou conteúdos resumidos em forma de template para que você possa usá-lo como um modelo básico de arquitetura para desenvolvimento de um software de acordo com os requisitos.

Abaixo segue uma ordem cronológico da evolução de um mesmo projeto de acordo com que for aprimorando de conhecimento em seus estudos.

### SpringBoot

Abaixo temos uma lista de projetos existentes na pasta `spring` onde exploramos todos os recursos disponíveis por este framework tão versátil e utilizado em projetos atuais desenvolvidos com a linguagem Java.

|Diretório|Recursos|Descrição|
|----------|---------|-------|
|[springboot-crud-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-api)|Projeto Web Modelo / Swagger / SpringDataJpa - H2 / Lombok / HTTP Rest |Modelo mínimo para qualquer projeto HTTP Rest utilizando SpringBoot capaz de interagir com um banco de dados em memória|
|[springboot-crud-postgres-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-postgres-api)|Projeto HTTP Web Modelo conectado ao PostgreSQL |Modelo mínimo de um projeto HTTP Web conectado ao PostgreSQL.|
|[springboot-crud-postgres-flyway-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-postgres-flyway-api)|Habilitando FlyWay Migrations com PostgreSQL |Habilitar o recurso de database migrations utilizando FlyWay e PostgreSQL|
|[springboot-crud-exception-handler-api](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-crud-exception-handler-api)|Projeto Web com implementação de Exception Handler |Projeto Web padronizando mensagens de sucesso ou de exceções|
|[springboot-jwt-authentication](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-jwt-authentication)|Projeto Web com implementação de autenticação com JWT |Habilitar as configurações de autenticação e segurança na aplicação|
|[springboot-jwt-database-authentication](https://github.com/glysns/backend-stater-kit/tree/main/spring/springboot-jwt-database-authentication)|Projeto Web com implementação de autenticação com JWT e PostgreSQL |Habilitar as configurações de autenticação e segurança armazenando os usuários em um banco de dados|


Solidity

TIPOS

uint256 - INTEIRO DE 32 BYTES

struct - conjunto de informacoes de mesmo dominio

address tipo especifico

mapping (chave, valor)

msg

variaveis

tipo + visibilidade + nome + atribuição


fee = taxa
balance = saldo

disco no da block chain

function (tipo nome) - public aparentemente vai estar visivel na plataforma

calldata - não salva em disco, no caso os parametros (somente leitura)
memory permite mudar o valor da variavel

variaveis locais versus variaveis de intancia (memory)

valores default (padrao) em variaveis não inicializadas ou sem atribuição

msg = variavel global que se refere a interação (chamada) do usuário diante do contrato em forma de mensagem

msg.sender = pessoa que enviou a requisição ao contrato
msg.value = valor enviado na chamada da requisição (payable)

variaveis leitura - não gera taxa

functions escrita e leitura - paga taxa ou não

taxa é relativa a quantidade de bytes que serão escritos versus a lógica aplicada (tempo de processamento)


parametros uint256, address e outros primitivos calldata/memory

payable - recurso que possibilita que a carteira que chamou a função envie uma quantia de valor agregada (doar, transferir, depositar, sacar) - donate, transfer, xx, withdraw

require função de validação

require(msg.value > 0, "O valor não pode ser zero")

obter o elemento do map - map[indice].atributos

operador de unario +=

Campain memory c = mapa[id], prq foi memory ?









address payable recebedor = payable(address) - tornar um recebedor um pessoa que ve o valor

recebedor.call{value: balance - fee} ("")

SMARTCONTRACT




// SPDX-License-Identifier: MIT

pragma solidity ^0.8.17;

struct Campaign {
    address author;
    string title;
    string description;
    string videoUrl;
    string imageUrl;
    uint256 balance;
    bool active;
}

contract DonateCrypto {

    uint256 public fee = 100;//wei
    uint256 public nextId = 0;

    mapping(uint256 => Campaign) public campaigns; //id => campanha

    function addCampaign(string calldata title, string calldata description, string calldata videoUrl, string calldata imageUrl) public {
        Campaign memory newCampaign;
        newCampaign.title = title;
        newCampaign.description = description;
        newCampaign.videoUrl = videoUrl;
        newCampaign.imageUrl = imageUrl;
        newCampaign.active = true;
        newCampaign.author = msg.sender;

        nextId++;
        campaigns[nextId] = newCampaign;
    }

    function donate(uint256 id) public payable {
        require(msg.value > 0, "You must send a donation value > 0");
        require(campaigns[id].active == true, "Cannot donate to this campaign");

        campaigns[id].balance += msg.value;
    }

    function withdraw(uint256 id) public {

        Campaign memory campaign = campaigns[id];
        require(campaign.author == msg.sender, "You do not have permission");
        require(campaign.active == true, "This campaign is closed");
        require(campaign.balance > fee, "This campaign does not have enough balance");

        address payable recipient = payable(campaign.author);
        recipient.call{value: campaign.balance - fee}("");

        campaigns[id].active = false;
    }

}
