# CP3-Java
**Projeto de Gestão de Brinquedos**

**Descrição do Projeto**

Este projeto consiste em um sistema de gestão de brinquedos para uma empresa voltada para crianças até 12 anos. O sistema foi desenvolvido utilizando o framework Spring Boot configurado com o Maven em linguagem Java. Ele permite realizar operações básicas de um CRUD (Create, Read, Update e Delete) para gerenciar informações sobre os brinquedos, incluindo nome, tipo, classificação, tamanho e preço.

**IDE Utilizado**

O projeto foi desenvolvido utilizando o Eclipse como ambiente de desenvolvimento integrado (IDE).

**Configuração Inicial do Spring Initializr**

**Dependências do Projeto**

**As principais dependências utilizadas no projeto são:**

Spring Boot Starter Web
Spring Data JPA
Lombok

**Estrutura do Projeto**

**A estrutura do projeto segue os padrões do Spring Boot, com os seguintes pacotes principais:**

com.lego.controller: Contém os controladores responsáveis por receber as requisições HTTP e direcioná-las para as operações adequadas.
com.lego.model: Contém as entidades JPA que representam os brinquedos.
com.lego.repository: Contém as interfaces de repositório que permitem acessar e manipular os dados no banco de dados.

**Endpoints**

**O projeto oferece os seguintes endpoints para operações CRUD:**

GET /brinquedos: Retorna a lista de todos os brinquedos cadastrados.

GET /brinquedos/{id}: Retorna as informações de um brinquedo específico com o ID fornecido.

POST /brinquedos: Cria um novo brinquedo com base nos dados fornecidos.

PUT /brinquedos/{id}: Atualiza as informações de um brinquedo existente com o ID fornecido.

DELETE /brinquedos/{id}: Exclui um brinquedo existente com o ID fornecido.

**Testes com Postman**

Os testes dos endpoints podem ser realizados utilizando o software Postman. Abaixo estão os exemplos de uso dos endpoints:

**GET /brinquedos**

Para obter a lista de brinquedos cadastrados:

GET localhost:8080/brinquedos

GET /brinquedos/{id}

Para obter as informações de um brinquedo específico, substitua {id} pelo ID do brinquedo desejado:

GET localhost:8080/brinquedos/1

**POST /brinquedos**

Para criar um novo brinquedo, envie uma requisição POST com os dados do brinquedo no corpo da requisição:

POST localhost:8080/brinquedos

Body:
{
  "nome": "Carrinho",
  "tipo": "Veículo",
  "classificacao": "Infantil",
  "tamanho": "Pequeno",
  "preco": 49.99
}

**PUT /brinquedos/{id}**

Para atualizar as informações de um brinquedo existente, substitua {id} pelo ID do brinquedo a ser atualizado e envie uma requisição PUT com os novos dados do brinquedo no corpo da requisição:

PUT localhost:8080/brinquedos/1

Body:
{
  "nome": "Carrinho",
  "tipo": "Veículo",
  "classificacao": "Infantil",
  "tamanho": "Pequeno",
  "preco": 59.99
}

**DELETE /brinquedos/{id}**

Para excluir um brinquedo existente, substitua {id} pelo ID do brinquedo a ser excluído:

DELETE localhost:8080/brinquedos/1

**Banco de Dados**

O projeto utiliza um banco de dados Oracle, com a tabela tb_brinquedos para armazenar as informações dos brinquedos. As colunas obrigatórias na tabela são: Id, Nome, Tipo, Classificacao, Tamanho e Preco.

**Observações**

O projeto utiliza o padrão de retorno de informações HATEOAS (nível de maturidade 3 de projeto).

O Lombok foi utilizado para reduzir a quantidade de código boilerplate.

As operações de persistência no banco de dados são realizadas utilizando as funcionalidades oferecidas pelo Spring Data JPA.

**Autores**

Este projeto foi desenvolvido por:

Antonio Augusto

Camilla Santana

Charles Carvalho 

Luan Ribeiro

Raphael Torres
