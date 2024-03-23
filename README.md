# Sistema Bancário

Este é um projeto de exemplo de um sistema bancário simples, desenvolvido em Java com Spring Boot e PostgreSQL.

## Pré-requisitos

- Java JDK
- IntelliJ IDEA (ou outra IDE de sua preferência)
- PostgreSQL

## Configuração do Banco de Dados

Certifique-se de ter o PostgreSQL instalado e configurado em sua máquina. Você pode ajustar as configurações do banco de dados no arquivo `application.properties`.

## Como Executar

1. Clone este repositório.
2. Importe o projeto para sua IDE.
3. Configure o banco de dados PostgreSQL.
4. Execute o aplicativo Spring Boot.

## Endpoints da API

### Usuários

- **POST /salvarUsuario**: Cria um novo usuário.
- **PUT /atualizarUsuario/{idUsuario}**: Atualiza um usuário existente pelo ID.
- **DELETE /apagarUsuarioId**: Apaga um usuário pelo ID.
- **GET /listarUsuarios**: Lista todos os usuários cadastrados.
- **GET /listarUsuarioId**: Retorna um usuário pelo seu ID.

### Contas

- **POST /salvarConta**: Cria uma nova conta.
- **PUT /atualizarConta/{idConta}**: Atualiza o tipo de uma conta existente pelo ID.
- **DELETE /apagarContaId**: Apaga uma conta pelo ID.
- **GET /listarContas**: Lista todas as contas cadastradas.
- **GET /listarContaId**: Retorna uma conta pelo seu ID.

### Transações

- **POST /realizarDeposito**: Realiza um depósito em uma conta.
- **POST /realizarSaque**: Realiza um saque em uma conta.

## Criado por:

- [Bruno Ferreira](https://github.com/obrunohferreira)

