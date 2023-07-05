# Task Manager (Lista de Tarefas) - Spring Boot

Este é um repositório para um aplicativo de gerenciamento de tarefas (to-do list) desenvolvido com o Spring Boot.

## Pré-requisitos

Certifique-se de ter os seguintes componentes instalados antes de executar o aplicativo:

- Java Development Kit (JDK) 17 ou superior
- Maven
- MySQL

## Configuração do Banco de Dados

O aplicativo utiliza o MySQL como banco de dados. Certifique-se de ter um servidor MySQL configurado e atualize as informações de conexão no arquivo `application.properties`.

Caso seja necessário, altere o `spring.datasource.username` e `spring.datasource.password` de acordo com suas credenciais do mySql.

Também lembre de criar um Schema com o nome task_manager.

## Executando o Aplicativo

Para executar o aplicativo, siga as etapas abaixo:

1. Clone este repositório para o seu ambiente local.
2. Navegue até o diretório raiz do projeto.
3. Encontre o arquivo `TaskManagerApplication.java` e execute-o clicando em __run__.

Após a execução bem-sucedida, você poderá acessar o aplicativo em `http://localhost:8080`.

## 📚 Documentação (endpoints)

Documentação da API para o task manager.

## Autenticação

Rota padrão `<http://localhost:8080/api/auth/>`

### Login

Efetua o login de um usuário registrado.

| Método | Funcionalidade                          | URL                         |
| ------ | --------------------------------------- | --------------------------- |
| `POST` | Realiza o login do usuário na aplicação | <http://localhost:8080/api/auth/login> |

- __URL:__ `/api/auth/login`
- __Método:__ `POST`
- __Corpo da Requisição:__

```json
  {
    "email": "isaac@gmail.com",
    "senha": "teste"
  }
```

<details>
  <summary>A resposta da requisição é a seguinte:</summary>

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
 "nome": "Isaac",
 "sobrenome": "Almeida",
 "email": "isaac@gmail.com",
 "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0YXNrLW1hbmFnZXIiLCJzdWIiOiJpc2FhY0BnbWFpbC5jb20iLCJleHAiOjE2OTA0NjAxNjMsImlkIjoyfQ.W1-5Px4-3TwDjAdQ7I0dBDgjpJv0fzIjcL9TXfEaiTI"
}
```

</details>

<details>
  <summary>A requisição irá falhar nos seguintes casos:</summary>

- A rota retorna o código <code>400</code>, com a mensagem <code>O nome é obrigatório</code> caso o campo name não seja informado no body da requisição;

</details>

### Cadastro

Efetua o login de um usuário registrado.

| Método | Funcionalidade                          | URL                         |
| ------ | --------------------------------------- | --------------------------- |
| `POST` | Realiza o cadastro do usuário na aplicação | <http://localhost:8080/api/auth/cadastro> |

- __URL:__ `/api/auth/cadastro`
- __Método:__ `POST`
- __Corpo da Requisição:__

```json
  {
    "nome": "Isaac",
    "sobrenome": "Almeida",
    "email": "isaac@gmail.com",
    "senha": "teste"
  }
```

<details>
  <summary>A resposta da requisição é a seguinte:</summary>

```http
HTTP/1.1 201 CREATED
Content-Type: application/json

{
 "nome": "Isaac",
 "sobrenome": "Almeida",
 "email": "isaac@gmail.com",
 "token": null
}
```

</details>

## Usuários

Rota padrão `<http://localhost:8080/api/usuarios>`

| Método   | Funcionalidade                            | URL                         |
|----------|-------------------------------------------| --------------------------- |
| `POST`   | Realiza o cadastro do usuário na aplicação | <http://localhost:8080/api/usuarios> |
| `GET`    | Lista todos os usuários cadastrados       | <http://localhost:8080/api/usuarios> |
| `PUT`    | Edita o usuário encontrado pelo id        | <http://localhost:8080/api/usuarios/{id}> |
| `DELETE` | Deleta o usuário encontrado pelo id       | <http://localhost:8080/api/usuarios/{id}> |
| `GET`    | Busca o usuário pelo id         | <http://localhost:8080/api/usuarios/{id}> |

<details>
  <summary>Cadastro</summary>

- __URL:__ `/api/usuarios`
- __Método:__ `POST`
- __Corpo da Requisição:__

```json
  {
    "nome": "Isaac",
    "sobrenome": "Almeida",
    "email": "isaac@gmail.com",
    "senha": "teste"
  }
```

Resposta:

```http
HTTP/1.1 201 CREATED
Content-Type: application/json

{
 "nome": "Isaac",
 "sobrenome": "Almeida",
 "email": "isaac@gmail.com",
 "token": null
}
```

</details>

<details>
  <summary>Listar Usuário</summary>

- __URL:__ `/api/usuarios`
- __Método:__ `GET`

Parâmetros da paginação

- page (opcional): Número da página (padrão: 0).
- size (opcional): Quantidade de registros por página (padrão: 10).
- sort (opcional): Ordenação dos registros (padrão: "nome").

```json
  {
    "nome": "Isaac",
    "sobrenome": "Almeida",
    "email": "isaac@gmail.com",
    "senha": "teste"
  }
```

Resposta:

```http
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "idUsuario": 1,
    "nome": "Isaac",
    "sobrenome": "Almeida",
    "email": "isaac@gmail.com",
    "senha": "$2a$10$BdZKQOVMZk3JG5cKcFRz6O/p/YUcKRcELwNw8sPNBNEqxDKtkj9y2",
    "token": null
  },
  ...
]
```

</details>

<details>
    <summary>Edita Usuário ID</summary>

- __URL:__ `/api/usuarios/{id}`
- __Método:__ `PUT`
- __Corpo da Requisição:__

```json
    {
      "nome": "Carlos",
      "sobrenome": "Silva",
      "email": "Carlos@gmail.com",
      "senha": "teste"
    }
```

Resposta:

```http
HTTP/1.1 302 FOUND
Content-Type: application/json

{
    "idUsuario": 2,
    "nome": "Carlos",
    "sobrenome": "Silva",
    "email": "Carlos@gmail.com",
    "senha": "$2a$10$0Rk5YbJ4rkXOCYLVJ1H0OeXjdUK7eJ3zAABUg58lXWrXUQb9F7fx6",
    "password": "$2a$10$0Rk5YbJ4rkXOCYLVJ1H0OeXjdUK7eJ3zAABUg58lXWrXUQb9F7fx6",
    "enabled": true,
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ],
    "username": "Carlos@gmail.com",
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true
}
```
</details>

<details>
    <summary>Deleta Usuário pelo ID</summary>

- __URL:__ `/api/usuarios/{id}`
- __Método:__ `DELETE`
- __Path Variable ID__

Resposta:

```http
HTTP/1.1 200 OK
Usuário deletado com sucesso !!
```
</details>

<details>
    <summary>Busca Usuário pelo ID</summary>

- __URL:__ `/api/usuarios/{id}`
- __Método:__ `GET`
- __Path Variable ID__

Resposta:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
    "idUsuario": 6,
    "nome": "Adson",
    "sobrenome": "Souza",
    "email": "adson@gmail.com",
    "senha": "$2a$10$AYmnwwg4Gz92Zc0/AdbSwem.4RDe1uJjAvXXB6A91NVGqmpsv.atu",
    "password": "$2a$10$AYmnwwg4Gz92Zc0/AdbSwem.4RDe1uJjAvXXB6A91NVGqmpsv.atu",
    "enabled": true,
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "username": "adson@gmail.com",
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ]
}
```
</details>

## Tarefas

Rota padrão `<http://localhost:8080/api/tarefas>`

| Método   | Funcionalidade                        | URL                                       |
|----------|---------------------------------------|-------------------------------------------|
| `POST`   | Cria a tarefa na aplicação            | <http://localhost:8080/api/tarefas>       |
| `GET`    | Lista as tarefas criadas pelo usuário | <http://localhost:8080/api/tarefas>      |
| `PUT`    | Edita a tarefa encontrada pelo id     | <http://localhost:8080/api/tarefas/{id}> |
| `DELETE` | Deleta a tarefa encontrada pelo id    | <http://localhost:8080/api/tarefas/{id}> |
| `GET`    | Busca a tarefa pelo id     | <http://localhost:8080/api/tarefas/{id}> |

<details>
    <summary>Cadastro</summary>

- __URL:__ `/api/tarefas`
- __Método:__ `POST`
- __Corpo da Requisição:__

```json
    {
      "nome": "A Tarefa de exemplo",
      "descricao": "Descrição da tarefa de exemplo",
      "prioridade": "NORMAL",
      "status": "EM_ANDAMENTO",
      "dataInicio": "2023-06-26",
      "dataFinal": "2023-07-03",
      "usuario": {
        "idUsuario": 2
      }
    }
```

Resposta:

```http
HTTP/1.1 201 CREATED
Content-Type: application/json

    {
        "id": 1,
        "nome": "A Tarefa de exemplo",
        "descricao": "Descrição da tarefa de exemplo",
        "prioridade": "NORMAL",
        "status": "EM_ANDAMENTO",
        "dataInicio": "2023-06-26",
        "dataFinal": "2023-07-03",
        "usuario": {
            "nome": "Adson",
            "sobrenome": "Souza",
            "email": "adson@gmail.com",
            "token": null
        }
    }
```

</details>

<details>
    <summary>Listar Tarefas</summary>

- __URL:__ `/api/tarefas`
- __Método:__ `GET`

Parâmetros da paginação

- page (opcional): Número da página (padrão: 0).
- size (opcional): Quantidade de registros por página (padrão: 10).
- sort (opcional): Ordenação dos registros (padrão: "nome").

```json
     {
      "id": 1,
      "nome": "A Tarefa de exemplo",
      "descricao": "Descrição da tarefa de exemplo",
      "prioridade": "NORMAL",
      "status": "EM_ANDAMENTO",
      "dataInicio": "2023-06-26",
      "dataFinal": "2023-07-03",
      "usuario": {
        "nome": "Adson",
        "sobrenome": "Souza",
        "email": "adson@gmail.com",
        "token": null
      }
    }
```

Resposta:

```http
HTTP/1.1 200 OK
Content-Type: application/json

    [
        {
            "id": 1,
            "nome": "A Tarefa de exemplo",
            "descricao": "Descrição da tarefa de exemplo",
            "prioridade": "NORMAL",
            "status": "EM_ANDAMENTO",
            "dataInicio": "2023-06-26",
            "dataFinal": "2023-07-03",
            "usuario": {
                "nome": "Adson",
                "sobrenome": "Souza",
                "email": "adson@gmail.com",
                "token": null
            }
        },
        ...
    ]
```

</details>

<details>
    <summary>Edita Tarefa ID</summary>

- __URL:__ `/api/tarefas/{id}`
- __Método:__ `PUT`
- __Corpo da Requisição:__

```json
  {
      "nome": "Tarefa de Exemplo editada",
      "descricao": "Descrição da tarefa de exemplo",
      "prioridade": 1,
      "status": "EM_ANDAMENTO",
      "dataInicio": "2023-06-26",
      "dataFinal": "2023-07-03",
      "usuario": {
        "idUsuario": 1
      }
  }
```

Resposta:

```http
HTTP/1.1 200 OK
Content-Type: application/json

  {
    "id": 1,
    "nome": "Tarefa de Exemplo editada",
    "descricao": "Descrição da tarefa de exemplo",
    "prioridade": "NORMAL",
    "status": "EM_ANDAMENTO",
    "dataInicio": "2023-06-26",
    "dataFinal": "2023-07-03",
    "usuario": {
        "nome": "Adson",
        "sobrenome": "Souza",
        "email": "adson@gmail.com",
        "token": null
    }
  }
```
</details>

<details>
    <summary>Busca Tarefa ID</summary>

- __URL:__ `/api/tarefas/{id}`
- __Método:__ `GET`
- __Path Variable ID__

Resposta:

```http
HTTP/1.1 200 OK
Content-Type: application/json

  {
    "id": 1,
    "nome": "Tarefa de Exemplo editada",
    "descricao": "Descrição da tarefa de exemplo",
    "prioridade": "NORMAL",
    "status": "EM_ANDAMENTO",
    "dataInicio": "2023-06-26",
    "dataFinal": "2023-07-03",
    "usuario": {
        "nome": "Adson",
        "sobrenome": "Souza",
        "email": "adson@gmail.com",
        "token": null
    }
  }
```

</details>

<details>
    <summary>Deleta Tarefa ID</summary>

- __URL:__ `/api/tarefas/{id}`
- __Método:__ `DELETE`
- __Path Variable ID__

Resposta:

```http
HTTP/1.1 204 NO CONTENT

```

</details>

