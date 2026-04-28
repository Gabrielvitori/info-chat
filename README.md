# 🐾 PetAjuda (Zoonoses Info-Chat)

🚀 **Status:** Em Produção | 🔗 **Acesse agora:** [www.petajuda.tech](https://www.petajuda.tech/)

O **PetAjuda** é uma plataforma inteligente e Fullstack desenvolvida como projeto de extensão universitária do curso de Análise e Desenvolvimento de Sistemas (ADS). O objetivo é promover a conscientização sobre o bem-estar animal, a posse responsável e a prevenção de zoonoses em João Pessoa (PB), oferecendo um assistente virtual baseado em Inteligência Artificial para responder às dúvidas da população em tempo real.

---

## 🌟 Funcionalidades
- **Assistente Virtual Inteligente (IA):** Chatbot integrado ao Google Gemini, fornecendo respostas rápidas, formatadas e precisas sobre saúde animal, vacinação e prevenção.
- **Informação Rápida:** Cards interativos para acesso imediato a temas críticos (Emergências, Vacinação Antirrábica, Zoonoses Comuns e Rede de Apoio).
- **Persistência de Dados:** Registro automático de todas as interações no banco de dados para futura análise do perfil de dúvidas da comunidade local.
- **Interface Responsiva:** Design limpo, acessível e responsivo, focado na usabilidade em dispositivos móveis e desktop, com suporte a renderização de Markdown.

---

## 🛠️ Stack Tecnológica

### Front-end
- **React (Vite):** Biblioteca principal para a construção da interface de usuário.
- **Tailwind CSS:** Framework utilitário para estilização ágil e responsiva.
- **React-Markdown & Lucide-React:** Renderização de texto formatado pela IA e iconografia.

### Back-end
- **Java 21:** Versão moderna da linguagem para alta performance.
- **Spring Boot 3.3.4:** Framework robusto para a criação da API REST.
- **Spring Data JPA & Hibernate:** Camada de abstração para persistência de dados.
- **MySQL:** Banco de dados relacional.
- **RestTemplate:** Comunicação HTTP direta e eficiente com a API do Google.

### Nuvem e Infraestrutura (Deploy)
- **Vercel:** Hospedagem contínua e distribuição global (CDN) do Front-end.
- **Railway:** Provisionamento de banco de dados MySQL e hospedagem do Back-end Spring Boot.
- **Hostinger:** Gerenciamento do domínio personalizado (`.tech`) com roteamento de DNS seguro.

---

## 🏗️ Arquitetura e Diferenciais Técnicos
Para garantir a máxima estabilidade, este projeto utiliza uma **integração nativa via protocolo HTTP (REST)** com o Google Gemini 2.5 Flash. A comunicação com a IA é feita construindo os *payloads* JSON manualmente. Isso permite um controle rigoroso sobre a Engenharia de Prompt, garantindo que o assistente siga estritamente as regras de formatação e o contexto especializado do Centro de Zoonoses.

A aplicação adota boas práticas de segurança, como configuração estrita de **CORS** para o domínio de produção e isolamento de credenciais através de **Variáveis de Ambiente**, permitindo uma transição fluida entre o ambiente de desenvolvimento (Localhost) e o ambiente de produção (Nuvem).

---

## 💻 Como Executar o Projeto Localmente

O projeto está configurado com fallback em variáveis de ambiente. Para rodar na sua máquina, siga os passos:

### 1. Banco de Dados
Crie o banco de dados no seu MySQL local:
```sql
CREATE DATABASE zoonoses_db;
```
## 2. Back-end (Spring Boot)
Acesse a pasta do Back-end. O arquivo application.properties já está configurado para tentar ler variáveis da nuvem e, caso não as encontre, utilizará os padrões locais (localhost, root, etc.).

Você só precisa injetar a sua chave da API do Gemini na inicialização da IDE, ou editar temporariamente o arquivo src/main/resources/application.properties alterando o valor padrão:

Properties
```
gemini.api.key=${GEMINI_API_KEY:COLE_SUA_CHAVE_AQUI}
```
Execute a aplicação na sua IDE favorita (A API rodará em http://localhost:8080).

### 3. Front-end (React)
Acesse a pasta do Front-end, instale as dependências e inicie o servidor:

```Bash
npm install
npm run dev
```
O sistema abrirá automaticamente em http://localhost:5173. Certifique-se de alterar as requisições de fetch no código para apontar para o seu localhost ao testar localmente.
