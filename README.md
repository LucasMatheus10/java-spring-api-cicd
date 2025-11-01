# API Java Spring Boot com Pipeline de CI/CD Completo

![Linguagem](https://img.shields.io/badge/Java-21-blue.svg?style=for-the-badge&logo=java)
![Framework](https://img.shields.io/badge/Spring%20Boot-3.5.7-green.svg?style=for-the-badge&logo=spring)
![CI/CD](https://img.shields.io/badge/GitHub%20Actions-CI/CD-blueviolet.svg?style=for-the-badge&logo=githubactions)
![Containerização](https://img.shields.io/badge/Docker-Build-blue.svg?style=for-the-badge&logo=docker)

## 🎯 Sobre o Projeto

Este projeto demonstra um fluxo de trabalho, unindo o desenvolvimento de uma API backend simples com **Java/Spring Boot** e práticas modernas de **DevOps**.

O objetivo é mostrar o ciclo de vida completo de uma aplicação:
1.  **Desenvolvimento:** Uma API REST simples, construída com Spring Boot e gerenciada pelo Maven.
2.  **Containerização:** O empacotamento da aplicação em uma imagem Docker leve e otimizada.
3.  **Entrega Contínua (CI/CD):** Um pipeline automatizado com GitHub Actions que constrói a imagem e a publica no Docker Hub a cada alteração na branch `main`.

## ✨ Funcionalidades Principais

### Aplicação (Backend)
* **API RESTful:** Expõe os endpoints (`/hello`, `/goodbye`, `/status`) usando o Spring Web.
* **Endpoint de Health Check:** O endpoint `/status` retorna um JSON com o status do serviço e um timestamp.
* **Build com Maven:** O projeto é gerenciado pelo Maven, utilizando o Maven Wrapper (`mvnw`) para garantir um build consistente.

### DevOps (Automação e Entrega)
* **Dockerfile Multi-Stage:** Utiliza um `Dockerfile` de múltiplos estágios para criar uma imagem de produção enxuta. O primeiro estágio (`builder`) compila o código com o JDK completo, e o estágio final copia apenas o `.jar` resultante para uma imagem JRE leve.
* **Otimização de Cache:** O `Dockerfile` é otimizado para aproveitar o cache de camadas do Docker, separando o download de dependências (`dependency:go-offline`) da cópia do código-fonte.
* **Pipeline de CI/CD Automatizado:** O arquivo `.github/workflows/main.yml` define um pipeline que:
    * É acionado a cada `push` na branch `main`.
    * Configura o ambiente com JDK 21.
    * Faz login no Docker Hub de forma segura usando GitHub Secrets.
    * Constrói e envia a imagem Docker para o Docker Hub.

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java 21, Spring Boot, Spring Web, Maven
* **DevOps:** Docker, GitHub Actions

## 🚀 Como Executar o Projeto

*Nota: Todos os comandos devem ser executados de dentro da pasta `spring-api-cicd`.*

### Pré-requisitos
* Java 21 (JDK)
* Docker Desktop

### 1. Rodando Localmente (via Maven)

Esta é a forma padrão de executar durante o desenvolvimento.

1.  Clone o repositório e entre na pasta da aplicação:
    ```sh
    git clone https://github.com/LucasMatheus10/java-spring-api-cicd.git
    cd java-spring-api-cicd/spring-api-cicd
    ```

2.  Dê permissão de execução ao Maven Wrapper (necessário em Linux/macOS):
    ```sh
    chmod +x ./mvnw
    ```

3.  Execute a aplicação:
    ```sh
    ./mvnw spring-boot:run
    ```

4.  Acesse os endpoints no seu navegador:
    * `http://localhost:8080/hello`
    * `http://localhost:8080/goodbye`
    * `http://localhost:8080/status`

### 2. Rodando com Docker

Esta forma simula como a aplicação rodaria em um ambiente de produção.

1.  Navegue até a pasta `spring-api-cicd` (mesma do passo 1 acima).

2.  Construa a imagem Docker:
    ```sh
    docker build -t java-spring-api .
    ```

3.  Execute um contêiner a partir da imagem:
    ```sh
    docker run -p 8080:8080 java-spring-api
    ```
    * O comando `-p 8080:8080` mapeia a porta 8080 do seu computador para a porta 8080 exposta pelo contêiner.

4.  Acesse os endpoints da mesma forma: `http://localhost:8080/status`