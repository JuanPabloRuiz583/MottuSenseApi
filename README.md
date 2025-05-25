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

A aplicação estará disponível em: http://localhost:8080/swagger-ui.html

### 4. Acesse os Endpoints

Você pode usar ferramentas como **Postman** ou **Swagger** para interagir com a API. Exemplos de endpoints:

# **ClienteController** (`/clientes`)
- **GET** `/clientes`: Retorna uma lista paginada de clientes.
- **GET** `/clientes/{id}`: Retorna os detalhes de um cliente pelo ID.
- **POST** `/clientes`: Cria um novo cliente.
- **PUT** `/clientes/{id}`: Atualiza os dados de um cliente pelo ID.
- **DELETE** `/clientes/{id}`: Remove um cliente pelo ID.

# **MotoController** (`/motos`)
- **GET** `/motos`: Retorna uma lista paginada de motos.
- **GET** `/motos/{id}`: Retorna os detalhes de uma moto pelo ID.
- **POST** `/motos`: Cria uma nova moto.
- **PUT** `/motos/{id}`: Atualiza os dados de uma moto pelo ID.
- **DELETE** `/motos/{id}`: Remove uma moto pelo ID.
- **GET** `/motos/search`: Busca motos por parâmetros opcionais (`placa`, `modelo`).

# **PatioController** (`/patios`)
- **GET** `/patios`: Retorna uma lista de pátios.
- **GET** `/patios/{id}`: Retorna os detalhes de um pátio pelo ID.
- **POST** `/patios`: Cria um novo pátio.
- **PUT** `/patios/{id}`: Atualiza os dados de um pátio pelo ID.
- **DELETE** `/patios/{id}`: Remove um pátio pelo ID.

# **SensorLocalizacaoController** (`/sensores`)
- **GET** `/sensores`: Retorna uma lista de sensores de localização.
- **GET** `/sensores/{id}`: Retorna os detalhes de um sensor pelo ID.
- **POST** `/sensores`: Cria um novo sensor de localização.
- **PUT** `/sensores/{id}`: Atualiza os dados de um sensor pelo ID.
- **DELETE** `/sensores/{id}`: Remove um sensor pelo ID.

 Observações Importantes

- **MotoController**: Só é possível criar uma moto se o cliente e o pátio existirem.
- **ClienteController**: As operações de criação e atualização de clientes exigem validação dos dados enviados.
- **PatioController**: As operações de criação e atualização de pátios exigem validação dos dados enviados.
- **SensorLocalizacaoController**: As operações de criação e atualização de sensores de localização exigem validação dos dados enviados e que seja vinculado a uma moto existente.

### Swagger

Link do swagger: http://localhost:8080/swagger-ui.html


### 5. Console do Banco de Dados H2

O console do banco de dados H2 está disponível em `http://localhost:8080/h2-console`. Use as credenciais abaixo:

- **JDBC URL**: jdbc:h2:mem:MottuSenseApi
- **Usuário**: sa
- **Senha**: password

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

## Integrantes

Barbara Dias Santos rm: 556974

Natasha Lopes Rocha Oliveira rm: 554816

Juan Pablo Ruiz de Souza rm: 557727

