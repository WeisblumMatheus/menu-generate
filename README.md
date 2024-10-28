# Gerador de Cardápio 📋🥘

Bem-vindo ao Gerador de Cardápio para o projeto Quentinhas Praia da Urca! Este projeto tem como objetivo criar cardápios estilizados em PDF de maneira prática e automática, com o intuito de facilitar e diminuir o trabalho necessário para criar cardápios para o negócio dos meus pais, que vendem quentinhas. Antes, o cardápio precisava ser editado manualmente em programas de edição, o que gerava muito trabalho e tomava tempo. Com este projeto, houve uma grande economia de tempo e esforço.

## Funcionalidades Principais 🚀

- **Cadastro de itens de cardápio**: Insira uma lista de itens e preços que serão automaticamente formatados.
- **Geração automática de PDF**: Crie um cardápio em PDF estilizado a partir dos dados fornecidos.
- **Estilização personalizada**: Cardápio com visual moderno e organizado, incluindo uma seção para bebidas fixas.
- **Compatibilidade total com JSON**: API que permite receber dados em formato JSON para fácil integração com outros sistemas.

## Tecnologias Utilizadas 🛠️

- **Java 21**
- **Spring Boot** para gerenciamento de dependências e controle de rotas
- **Maven** para automação de build
- **Thymeleaf** para renderização de templates
- **iTextPDF** para geração de PDFs
- **HTML e CSS** para estruturação e estilização do layout
- **Docker** para containerização do ambiente

## Estrutura de Diretórios 📁

```plaintext
/src
├── /main
│   ├── /java/com/quentinhas/cardapio/controller    # Controladores da aplicação
│   ├── /java/com/quentinhas/cardapio/service       # Serviços de negócios
│   └── /resources/templates                        # Arquivos HTML do Thymeleaf
└── /target                                         # Artefatos de build gerados
pom.xml                                             # Gerenciador de dependências
Dockerfile                                          # Configuração do Docker para containerização
```

## Como Rodar o Projeto 🏃‍♂️

### Pré-requisitos

- **Java 21+**
- **Maven**
- **Docker** (opcional, para rodar em container)

### Passo a Passo

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/quentinhas-cardapio.git
    cd quentinhas-cardapio
    ```

2. Compile e faça o build:
    ```bash
    mvn clean install
    ```

3. Execute a aplicação:
    ```bash
    java -jar target/cardapio-0.0.1-SNAPSHOT.jar
    ```

4. Para rodar com Docker, use:
    ```bash
    docker build -t quentinhas-cardapio .
    docker run -p 8080:8080 quentinhas-cardapio
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Rotas da API 🌐

### GET `/v1/menu`

Retorna a página de formulário de entrada dos itens de cardápio.

**Resposta**: Renderiza o template `gerar_tela.html` para que o usuário possa inserir dados.

### POST `/v1/menu/gerar-cardapio`

Recebe uma lista de itens do cardápio no corpo da requisição e gera um PDF com o cardápio estilizado.

**Body (JSON)**:
```json
[
  { "foodName": "Frango Grelhado", "price": "15.00" },
  { "foodName": "Peixe Frito", "price": "20.00" },
  { "foodName": "Carne Assada", "price": "18.00" }
]
```