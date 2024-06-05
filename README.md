# Santander Dev Week 2024.
Projeto (Java RESTful API) criado no Bootcamp Santander 2024 para ser enviado (deploy) em uma plataforma de nuvem.

## Diagrama de classes

```mermaid
classDiagram
    class User {
        -String name
        -Account account
        -Card card
        -Feature[] features
        -News[] news
    }

    class Account {
        -String number
        -String agency
        -float balance
        -float limit
    }

    class Card {
        -String number
        -float limit
    }

    class Feature {
        -String icon
        -String description
    }

    class News {
        -String icon
        -String description
    }

    User "1" *-- "1" Account
    User "1" *-- "1" Card
    User "1" *-- "N" Feature
    User "1" *-- "N" News
```

Esta API foi criada com o intuito de praticar o deploy da mesma em uma plataforma de nuvem (Render), fazendo o provisionamento do banco de dados (Postgres) também nesta plataforma, reforçando assim os conhecimentos do desenvolvimento de uma api e sobre o processo de Integraçao Contínua (CI) e Entrega Contínua (CD).
