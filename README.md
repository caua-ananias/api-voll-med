# API Voll.med

API Rest desenvolvida para o sistema Voll.med, uma clínica médica fictícia que precisa de um aplicativo para gestão de consultas. A API possui funcionalidades que permitem o cadastro de médicos e de pacientes, além do agendamento e cancelamento de consultas.

## 🔨 Funcionalidades do projeto

- `Cadastro de médicos`
- `Cadastro de pacientes`
- `Agendamento de consultas`
- `Cancelamento de consultas`

## ✔️ Tecnologias utilizadas

- `Java 17`
- `Spring Boot 3`
- `Maven`
- `MySQL`
- `Flyway`
- `Lombok`
- `JWT`

## 📁 Acesso ao projeto

Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/caua-ananias/api-voll-med).

## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com a IDE de sua preferência. Para isso, na tela de launcher:

- Clique em "Open an Existing Project" (ou alguma opção similar)
- Procure o local onde o projeto está e o selecione
- Por fim clique em "OK"

A IDE deve executar algumas tasks do Maven para configurar o projeto, aguarde até finalizar. Ao finalizar as tasks, você pode executar a aplicação.

## 📚 Documentação da API

A documentação da API está disponível através do Swagger UI. Após iniciar a aplicação, acesse:
http://localhost:8080/swagger-ui.html

### Autenticação

A API utiliza JWT para autenticação. Para obter um token, faça uma requisição POST para `/login` com as credenciais de usuário.

### Endpoints principais

- `POST /medicos` - Cadastra um novo médico
- `GET /medicos` - Lista todos os médicos ativos
- `PUT /medicos` - Atualiza dados de um médico
- `DELETE /medicos/{id}` - Exclui um médico

- `POST /pacientes` - Cadastra um novo paciente
- `GET /pacientes` - Lista todos os pacientes ativos
- `PUT /pacientes` - Atualiza dados de um paciente
- `DELETE /pacientes/{id}` - Exclui um paciente

- `POST /consultas` - Agenda uma consulta
- `DELETE /consultas` - Cancela uma consulta

## 🔧 Configuração do Ambiente

### Requisitos

- Java 17 ou superior
- MySQL

### Configuração do Banco de Dados

As configurações do banco de dados podem ser alteradas no arquivo `application.properties`:
```
properties
spring.datasource.url=jdbc:mysql://localhost:3306/vollmed_api
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Variáveis de Ambiente

A aplicação utiliza as seguintes variáveis de ambiente:

- `JWT_SECRET` - Chave secreta para geração de tokens JWT
- `DATASOURCE_URL` - URL do banco de dados (ambiente de produção)
- `DATASOURCE_USERNAME` - Usuário do banco de dados (ambiente de produção)
- `DATASOURCE_PASSWORD` - Senha do banco de dados (ambiente de produção)

## 📝 Licença

Este projeto foi desenvolvido durante os cursos de Java e Spring da Alura.
