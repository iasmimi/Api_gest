📅 API de Gestão de Eventos e Participantes
Desenvolvido no IntelliJ IDEA
Sistema para gerenciamento completo de eventos e participantes

👥 Integrantes do Grupo
Parte	Nome	Responsabilidades
1	Nicolas	Configuração do projeto, entidades e relacionamentos
2	Gustavo	Repository, DTO, Service e lógica de inscrição
3	Kauã	Controller com endpoints e testes no Postman
4	Iasmin	Organização do repositório e documentação
🚀 Sobre o Projeto
Este projeto foi desenvolvido como trabalho acadêmico para a disciplina [Nome da Disciplina]. Trata-se de uma API RESTful construída com:

Java (versão [X.X])

Spring Boot

Banco de Dados H2 (para ambiente de desenvolvimento)

Maven (para gerenciamento de dependências)

Toda a implementação foi realizada no ambiente de desenvolvimento IntelliJ IDEA.

✨ Funcionalidades Principais
📌 Gestão de Eventos
Cadastro de eventos com nome, descrição, data, local e número de vagas

Listagem completa de eventos disponíveis

Atualização de informações dos eventos

Remoção de eventos do sistema

👥 Gestão de Participantes
Cadastro de participantes com nome, e-mail e telefone

Sistema de inscrição em eventos com controle de vagas

Cancelamento de inscrição quando necessário

Consulta de participantes por evento

🛠️ Como Configurar e Executar
Pré-requisitos
IntelliJ IDEA instalado

Java JDK [X.X]

Maven [X.X]

Passo a Passo
Clone o repositório

bash
git clone https://github.com/iasmimi/Api_gest.git
Abra o projeto no IntelliJ

File → Open → Selecione a pasta do projeto

Configure o JDK

File → Project Structure → Project SDK

Execute a aplicação

Encontre a classe ApiGestaoApplication.java

Clique no botão "Run" ou use Shift+F10

Acesse a API

bash
http://localhost:8080
text

## 🗂 Estrutura do Projeto
📦 Api_gest
├── 📂 src
│ ├── 📂 main
│ │ ├── 📂 java/com/api/gestao
│ │ │ ├── 📂 config
│ │ │ ├── 📂 controller
│ │ │ │ ├── EventoController.java
│ │ │ │ └── ParticipanteController.java
│ │ │ ├── 📂 dto
│ │ │ ├── 📂 model
│ │ │ ├── 📂 repository
│ │ │ ├── 📂 service
│ │ │ └── ApiGestaoApplication.java
│ │ └── 📂 resources
│ │ ├── application.properties
│ │ └── data.sql
│ └── 📂 test
└── pom.xml

🌟 Destaques Técnicos
Arquitetura limpa com separação clara de responsabilidades

Validação robusta de dados de entrada

Controle preciso de vagas em eventos

Relacionamento ManyToMany entre eventos e participantes

📌 Próximos Passos
Implementar autenticação de usuários

Adicionar sistema de avaliação de eventos

Desenvolver front-end para consumo da API

🔚 Considerações Finais
Este projeto foi desenvolvido como parte dos requisitos da disciplina, do curso de desenvolvimento de sistemas 
