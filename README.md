# 🐾 PetAjuda (Zoonoses Info-Chat)

🚀 **Status:** Em Produção | 🔗 **Acesse agora:** [www.petajuda.tech](https://www.petajuda.tech/)

O **PetAjuda** é uma plataforma inteligente e Fullstack desenvolvida como projeto de extensão universitária do curso de Análise e Desenvolvimento de Sistemas (ADS). O objetivo é promover a conscientização sobre o bem-estar animal, a posse responsável e a prevenção de zoonoses em João Pessoa (PB), oferecendo um assistente virtual baseado em Inteligência Artificial para responder às dúvidas da população em tempo real.

---

## 📁 Estrutura do Projeto (Monorepo)

```text
petajuda-fullstack/
├── backend/                  # API REST (Java 21 + Spring Boot + JPA/MySQL)
│   ├── .mvn/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/zoonoses/infochat/
│   │   │   │   ├── config/       # Configurações globais (CORS)
│   │   │   │   ├── controller/   # Endpoints REST (/api/chat)
│   │   │   │   ├── entity/       # Entidades JPA (interacao_chat)
│   │   │   │   ├── repository/   # Repositórios Spring Data JPA
│   │   │   │   ├── service/      # Regras de negócio e integração com Gemini
│   │   │   │   └── InfochatApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── mvnw / mvnw.cmd
│   └── pom.xml
├── frontend/                 # Interface Web (React + Vite + Tailwind CSS)
│   ├── public/
│   ├── src/
│   ├── index.html
│   ├── package.json
│   ├── vercel.json               # Rewrite de /api/* para o servidor na AWS EC2
│   └── vite.config.js            # Proxy local de /api para http://localhost:8080
├── .gitignore
└── README.md
```

---

## 🌟 Funcionalidades
- **Assistente Virtual Inteligente (IA):** Chatbot integrado ao Google Gemini, fornecendo respostas rápidas, formatadas e precisas sobre saúde animal, vacinação e prevenção.
- **Informação Rápida:** Cards interativos para acesso imediato a temas críticos (Emergências, Vacinação Antirrábica, Zoonoses Comuns e Rede de Apoio).
- **Persistência de Dados:** Registro automático de todas as interações no banco de dados para futura análise do perfil de dúvidas da comunidade local.
- **Interface Responsiva:** Design limpo, acessível e responsivo, focado na usabilidade em dispositivos móveis e desktop, com suporte a renderização de Markdown.

---

## 🛠️ Stack Tecnológica

### Front-end (`frontend/`)
- **React (Vite):** Biblioteca principal para a construção da interface de usuário.
- **Tailwind CSS:** Framework utilitário para estilização ágil e responsiva.
- **React-Markdown & Lucide-React:** Renderização de texto formatado pela IA e iconografia.

### Back-end (`backend/`)
- **Java 21:** Versão moderna da linguagem para alta performance.
- **Spring Boot 4.0.6:** Framework robusto para a criação da API REST.
- **Spring Data JPA & Hibernate:** Camada de abstração para persistência de dados.
- **MySQL:** Banco de dados relacional.
- **RestTemplate:** Comunicação HTTP direta e eficiente com a API do Google Gemini.

### Nuvem e Infraestrutura (Deploy)
- **Vercel:** Hospedagem contínua, distribuição global (CDN) do Front-end (com *Root Directory* configurado para `frontend`) e proxy reverso `/api/*` via `vercel.json`.
- **AWS EC2:** Hospedagem da API Back-end Spring Boot em produção.
- **AWS RDS (MySQL):** Banco de dados relacional gerenciado na nuvem conectado ao Back-end na EC2.
- **Hostinger:** Gerenciamento do domínio personalizado (`www.petajuda.tech`) com roteamento de DNS.

---

## 🏗️ Arquitetura e Diferenciais Técnicos
Para garantir a máxima estabilidade, este projeto utiliza uma **integração nativa via protocolo HTTP (REST)** com o Google Gemini 2.5 Flash. A comunicação com a IA é feita construindo os *payloads* JSON manualmente, permitindo controle rigoroso sobre a Engenharia de Prompt para manter o assistente dentro do contexto especializado do Centro de Zoonoses.

A aplicação adota boas práticas de segurança, como configuração centralizada de **CORS** em `CorsConfig`, proxy reverso HTTPS -> HTTP na Vercel para evitar erros de *Mixed Content*, e isolamento de credenciais através de **Variáveis de Ambiente**, permitindo transição fluida entre o ambiente local e a nuvem (AWS).

---

## 💻 Como Executar o Projeto Localmente

O projeto está configurado com *fallback* em variáveis de ambiente. Para rodar na sua máquina, siga os passos:

### 1. Banco de Dados
Crie o banco de dados no seu MySQL local:
```sql
CREATE DATABASE zoonoses_db;
```

### 2. Back-end (Spring Boot)
Acesse a pasta `backend/`. O arquivo `backend/src/main/resources/application.properties` já utiliza variáveis de ambiente (`PORT`, `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`, `GEMINI_API_KEY`) com valores padrão locais como *fallback*.

Defina a variável `GEMINI_API_KEY` no ambiente (ou na configuração de execução da IDE) e execute:

```bash
cd backend
./mvnw spring-boot:run
```
*(No Windows PowerShell/CMD, utilize `.\mvnw.cmd spring-boot:run`. A API rodará em `http://localhost:8080`.)*

### 3. Front-end (React + Vite)
Em outro terminal, acesse a pasta `frontend/`, instale as dependências e inicie o servidor de desenvolvimento:

```bash
cd frontend
npm install
npm run dev
```
O Vite iniciará em `http://localhost:5173` e redirecionará automaticamente todas as requisições `/api/*` para `http://localhost:8080` através do proxy configurado em `frontend/vite.config.js`.
