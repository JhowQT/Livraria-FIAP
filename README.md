# Livraria FIAP - Projeto DevOps

## Video
https://www.youtube.com/watch?v=Mes5-gfPJ54

#tabelas
CREATE TABLE tb_jogo (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    plataforma VARCHAR(50),
    preco DECIMAL(10,2)
);

CREATE TABLE tb_livro (
    id INT IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100),
    editora VARCHAR(100),
    preco DECIMAL(10,2)
)

## Descrição do Projeto

Este projeto é uma aplicação web desenvolvida com **Spring Boot**, que simula uma livraria com cadastro e listagem de **Livros** e **Jogos**.

A aplicação segue o padrão MVC (Model-View-Controller) e utiliza:

- Controllers para gerenciar requisições
- Repositories para acesso a dados
- Templates HTML para interface

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven
- Thymeleaf
- HTML/CSS
- GitHub Actions (CI/CD)
- Azure (App Service + Azure SQL Database)

---

## Pré-requisitos

Antes de fazer o deploy na Azure, você precisa ter:

- **Git**
- **Azure CLI** instalado e autenticado (`az login`)
- **PowerShell** para executar o script `create-sql-server.ps1`
- **Bash** (Git Bash no Windows, WSL, ou Linux/Mac) para executar o `deploy-movtodimdim.sh`
- A ferramenta **sqlcmd** instalada (vamos usá-la para criar os objetos do banco automaticamente via script)

---

## Como adicionar a aplicação na nuvem da Azure (SQL Server + Deploy)

Este projeto foi pensado para ser publicado na Azure com:

1) **Criação do SQL Server / Azure SQL Database** e objetos do banco via `sqlcmd`
2) **Provisionamento e deploy do App Service** via script `deploy-movtodimdim.sh`
3) **CI/CD no GitHub Actions** usando Secrets para injetar as credenciais do banco

---

### 1) Criar o SQL Server e o banco (PowerShell)

Execute o script:

```powershell
.\create-sql-server.ps1
```

#### Por que PowerShell nesse script?

Porque o script aproveita o ambiente do Windows/PowerShell para orquestrar a criação dos recursos e, principalmente, porque vamos utilizar o **sqlcmd** (já instalado no ambiente) para:

- Conectar no SQL Server
- Criar automaticamente os objetos do banco (tabelas/estruturas)

Isso evita criar tudo manualmente.

---

### 2) Deploy do App Service (Bash)

1. Altere seu terminal para **Bash** (Git Bash/WSL/Linux/Mac).
2. Faça o upload/coloque o script `deploy-movtodimdim.sh`.
3. Instale a extensão necessária do Azure CLI:

```bash
az extension add --name application-insights
```

4. Conceda privilégio de execução no script:

```bash
chmod +x deploy-movtodimdim.sh
```

5. Edite o script e substitua **o RM** (documento todo) e o **repositório** (owner/repo) pelos seus dados.

6. Execute o script:

```bash
./deploy-movtodimdim.sh
```

> Acompanhe a execução: durante o processo pode ser necessário conceder permissão para o **Web App acessar o GitHub**.

---

### 3) Configurar Secrets no GitHub (para o workflow funcionar)

Depois do primeiro build (que normalmente **falha** por falta das variáveis), configure os Secrets no repositório:

1. Vá em **Settings → Secrets and variables → Actions**
2. Clique em **New repository secret**
3. Adicione os 3 secrets (um por vez):

- `SPRING_DATASOURCE_URL` = sua URL do banco
- `SPRING_DATASOURCE_USERNAME` = seu usuário
- `SPRING_DATASOURCE_PASSWORD` = sua senha

A aplicação lê essas variáveis via `application.properties`:

- `spring.datasource.url=${SPRING_DATASOURCE_URL}`
- `spring.datasource.username=${SPRING_DATASOURCE_USERNAME}`
- `spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}`

---

### 4) Workflow do GitHub Actions (CI/CD)

Este repositório possui um workflow de deploy para Azure App Service:

- `.github/workflows/main_movtodimdim-rm559597.yml`

Ele já está preparado para compilar com Java 17, buildar com Maven e fazer deploy do JAR no App Service.

#### Variáveis de ambiente no step de build

Garanta que o step **Build with Maven** possua a sessão `env` com as variáveis (atenção à indentação):

```yaml
- name: Build with Maven
  run: mvn clean install
  env:
    SPRING_DATASOURCE_URL: ${{ secrets.SPRING_DATASOURCE_URL }}
    SPRING_DATASOURCE_USERNAME: ${{ secrets.SPRING_DATASOURCE_USERNAME }}
    SPRING_DATASOURCE_PASSWORD: ${{ secrets.SPRING_DATASOURCE_PASSWORD }}
```

---

## Funcionalidades

- Cadastro de Livros
- Cadastro de Jogos
- Listagem de Livros e Jogos
- Página inicial

---

## Estrutura do Projeto

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

## Autor

- Julia Damasceno Busso - RM560293
- Gabriel Gomes Cardoso - Rm559597
- Jhonatan Quispe Torrez - rm560601
