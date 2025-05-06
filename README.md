# Proposta

MottuSense é uma solução inteligente desenvolvida para a Mottu, focada no mapeamento automatizado do pátio e na gestão eficiente das motos da frota.
Utilizando sensores IoT e uma arquitetura em nuvem com APIs .o sistema permite monitoramento em tempo real, controle de entrada e saída dos veículos, e integração com um app mobile para operadores.
Combinando banco de dados relacional e não relacional, DevOps, testes de qualidade e tecnologias modernas de desenvolvimento mobile e backend, o MottuSense garante rastreabilidade, performance e escalabilidade — tudo alinhado com os pilares da Mottu: tecnologia, mobilidade e oportunidade.

🛵 Nome da Solução: MottuSense
🔤 Significado:
"Mottu" (nome da empresa)
"Sense" de sensorial, percepção, inteligência → representa a capacidade da solução de "sentir" e gerenciar o pátio de motos com IoT.

## Diferencial

- Monitoramento em tempo real das motos atraves dos sensores
- localização exata das motos


# MottuSense API

MottuSense API é uma aplicação Spring Boot desenvolvida para gerenciar motos, clientes, pátios e sensores de localizaçao vinculados as motos. Ela oferece operações CRUD para o gerenciamento de motos,patios,sensores de localização e clientes, e inclui uma funcionalidade de busca para filtrar motos por parâmetros como placa e modelo.

## Funcionalidades

- **Operações CRUD**: Criar, consultar, atualizar e deletar motos, clientes, pátios e sensores de localizaçao.
- **Funcionalidade de Busca**: Filtrar motos por placa e modelo.
- **Cache**: Otimização de desempenho com uso de cache.
- **Seeder de Banco de Dados**: Pré-carrega o banco de dados com dados de exemplo para testes.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **Banco de Dados H2** (banco em memória para desenvolvimento e testes)
- **Spring Data JPA**
- **Spring Cache**
- **Lombok**
- **Swagger**

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven** (para gerenciamento de dependências)

## Como Executar

Siga os passos abaixo para configurar e executar o projeto localmente:

### 1. Clone o Repositório

```bash
git clone https://github.com/JuanPabloRuiz583/MottuSenseApi.git
cd mottusense-api
```

### 2. Compile o Projeto

Use o Maven para compilar o projeto e baixar as dependências:

```bash
mvn clean install
```

### 3. Execute a Aplicação

Inicie a aplicação com o comando:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

### 4. Acesse os Endpoints

Você pode usar ferramentas como **Postman** ou **cURL** para interagir com a API. Exemplos de endpoints:

- **Listar Todas as Motos**: `GET /motos`
- **Buscar Motos**: `GET /motos/search?placa=ABC1234&modelo=Honda`
- **Criar uma Moto**: `POST /motos`
- **Atualizar uma Moto**: `PUT /motos/{id}`
- **Deletar uma Moto**: `DELETE /motos/{id}`

### 5. Console do Banco de Dados H2

O console do banco de dados H2 está disponível em `http://localhost:8080/h2-console`. Use as credenciais abaixo:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuário**: `sa`
- **Senha**: *(deixe em branco)*

## Seeder de Banco de Dados

A aplicação inclui um seeder (`DatabaseSeeder`) que pré-carrega o banco de dados com dados de exemplo para testes. Esses dados incluem:

- Clientes de exemplo
- Pátios de exemplo
- Motos vinculadas aos clientes e pátios

## Estrutura do Projeto

```
src/main/java/br/com/fiap/MottuSenseApi
├── controller    # Controladores REST
├── dto           # Data Transfer Objects
├── model         # Classes de Entidade
├── repository    # Repositórios JPA
├── service       # Lógica de Negócio
├── config        # Classes de Configuração (ex.: DatabaseSeeder)
```

## Contribuindo

