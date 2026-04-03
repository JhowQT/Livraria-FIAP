#  Livraria FIAP - Projeto DevOps

## Descrição do Projeto

Este projeto é uma aplicação web desenvolvida com **Spring Boot**, que simula uma livraria com cadastro e listagem de **Livros** e **Jogos**.

A aplicação segue o padrão MVC (Model-View-Controller) e utiliza:

* Controllers para gerenciar requisições
* Repositories para acesso a dados
* Templates HTML para interface

---

##  Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Maven
* Thymeleaf
* HTML/CSS
* GitHub Actions (CI/CD)

---

##  Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

* Java JDK 17 ou superior
* Maven (ou usar o Maven Wrapper incluído)
* Git

---

##  Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd Livraria-FIAP-main
```

---

### 2. Rodar a aplicação

Você pode rodar de duas formas:

#### Usando Maven Wrapper (recomendado)

Linux/Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

---

#### usando Maven instalado

```bash
mvn spring-boot:run
```

---

### 3. Acessar a aplicação

Após iniciar, acesse no navegador:

```
http://localhost:8080
```

---

##  Funcionalidades

*  Cadastro de Livros
*  Cadastro de Jogos
*  Listagem de Livros e Jogos
*  Página inicial

---

## 📂 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/br/com/dimdim/
 │   │   ├── controller/
 │   │   ├── model/
 │   │   ├── repository/
 │   │   └── DimdimApplication.java
 │   └── resources/
 │       ├── templates/
 │       ├── static/
 │       └── application.properties
```

---

##  Autor

* Julia Damasceno Busso - RM560293
* Gabriel Gomes Cardoso - Rm559597 
* Jhonatan Quispe Torrez - rm560601

```
```
