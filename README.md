# To-Do List - Java & Spring Boot

O projeto **To-Do List** é uma aplicação web simples que permite aos usuários criar, gerenciar e marcar tarefas como concluídas. A aplicação é desenvolvida utilizando **Java** e **Spring Boot**, proporcionando uma API RESTful para interação com a lista de tarefas.

## Descrição

A aplicação permite que os usuários:
- **Adicionar novas tarefas** à lista.
- **Listar todas as tarefas**.
- **Marcar tarefas como concluídas**.
- **Excluir tarefas**.

O projeto utiliza a arquitetura **RESTful** com **Spring Boot**, oferecendo endpoints para todas as operações principais. O banco de dados utilizado é **H2**, uma solução de banco de dados em memória, para facilitar o desenvolvimento e testes.

## Funcionalidades

- **Adicionar Tarefa**: O usuário pode adicionar novas tarefas com uma descrição e um status inicial de "pendente".
- **Listar Tarefas**: O usuário pode visualizar todas as tarefas registradas.
- **Atualizar Tarefa**: O usuário pode marcar uma tarefa como concluída ou editar a descrição.
- **Deletar Tarefa**: O usuário pode remover uma tarefa da lista.

## Tecnologias

- **Java**: Linguagem de programação utilizada para o backend.
- **Spring Boot**: Framework que facilita o desenvolvimento de APIs RESTful.
- **Spring Data JPA**: Para gerenciar a persistência de dados no banco.
- **H2 Database**: Banco de dados em memória utilizado para armazenar as tarefas.
- **Maven**: Gerenciador de dependências e construção do projeto.

## Endpoints da API

A API oferece os seguintes endpoints para interação com as tarefas:

### 1. Criar uma nova tarefa
- **Método**: `POST`
- **Endpoint**: `/tasks`
- **Corpo**:
    ```json
    {
        "description": "Comprar leite"
    }
    ```
- **Resposta**: 
    ```json
    {
        "id": 1,
        "description": "Comprar leite",
        "completed": false
    }
    ```

### 2. Listar todas as tarefas
- **Método**: `GET`
- **Endpoint**: `/tasks`
- **Resposta**:
    ```json
    [
        {
            "id": 1,
            "description": "Comprar leite",
            "completed": false
        },
        {
            "id": 2,
            "description": "Lavar roupa",
            "completed": true
        }
    ]
    ```

### 3. Atualizar uma tarefa
- **Método**: `PUT`
- **Endpoint**: `/tasks/{id}`
- **Corpo**:
    ```json
    {
        "description": "Comprar leite",
        "completed": true
    }
    ```
- **Resposta**:
    ```json
    {
        "id": 1,
        "description": "Comprar leite",
        "completed": true
    }
    ```

### 4. Deletar uma tarefa
- **Método**: `DELETE`
- **Endpoint**: `/tasks/{id}`
- **Resposta**: 
    `204 No Content` (Sem corpo na resposta)

## Como Rodar o Projeto

### Pré-requisitos

- **Java 11** ou superior.
- **Maven** para gerenciamento de dependências e construção do projeto.

### Passos

1. Clone o repositório:
    ```bash
    git clone https://github.com/usuario/to-do-list.git
    cd to-do-list
    ```

2. Instale as dependências do Maven:
    ```bash
    mvn install
    ```

3. Execute o aplicativo:
    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`. Você pode testar a API utilizando ferramentas como **Postman** ou **curl**.

## Exemplo de Uso com **curl**

1. **Adicionar uma nova tarefa**:
    ```bash
    curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"description": "Comprar leite"}'
    ```

2. **Listar todas as tarefas**:
    ```bash
    curl http://localhost:8080/tasks
    ```

3. **Atualizar uma tarefa**:
    ```bash
    curl -X PUT http://localhost:8080/tasks/1 -H "Content-Type: application/json" -d '{"description": "Comprar leite", "completed": true}'
    ```

4. **Deletar uma tarefa**:
    ```bash
    curl -X DELETE http://localhost:8080/tasks/1
    ```

## Testes

Este projeto pode ser testado usando o framework **JUnit 5**. A estrutura de testes já está configurada para testar os principais métodos de controle da aplicação.

Para rodar os testes:

```bash
mvn test
