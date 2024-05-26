# Gestão de Resíduos

## Descrição

Este projeto é um sistema de gestão de resíduos, desenvolvido em Java utilizando o framework Spring. Ele permite que os usuários realizem o cadastro, login e a gestão de coletas de resíduos, incluindo cadastrar, atualizar, obter e excluir coletas.

## Funcionalidades

- **Cadastro de Usuário**: Permite que novos usuários se registrem no sistema.
- **Login**: Autenticação de usuários utilizando Spring Security.
- **Gestão de Coletas**:
  - **Cadastro de Coleta**: Adição de novas coletas ao sistema.
  - **Atualização de Coleta**: Edição de informações de coletas existentes.
  - **Obtenção de Coletas**: Consulta de coletas registradas no sistema.
  - **Exclusão de Coletas**: Remoção de coletas do sistema.

## Tecnologias Utilizadas

- **Java**
- **Spring Framework**
  - Spring Boot
  - Spring Data JPA
  - Spring Security
- **Oracle Database**

## Pré-requisitos

- **JDK 11** ou superior
- **Maven** (opcional, se utilizar o wrapper `mvnw`)
- **Oracle Database** (configurado e em execução)

## Como Executar o Projeto

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/gestao-residuos.git
cd gestao-residuos
```

### Configurar o Banco de Dados

Certifique-se de que você tenha um banco de dados Oracle em execução e configure as propriedades de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/xe
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
```

### Executar a Aplicação

Usando Maven:

```bash
mvn spring-boot:run
```

Ou usando o wrapper do Maven:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

### Autenticação

- **Registrar Usuário**: `POST /api/auth/register`
- **Login**: `POST /api/auth/login`

### Coletas

- **Cadastrar Coleta**: `POST /api/coletas`
- **Atualizar Coleta**: `PUT /api/coletas/`
- **Obter Coletas**: `GET /api/coletas`
- **Excluir Coleta**: `DELETE /api/coletas/{id}`

## Segurança

A aplicação utiliza **Spring Security** para autenticação e autorização. Após o login, o usuário recebe um token JWT que deve ser usado para acessar os endpoints protegidos.
