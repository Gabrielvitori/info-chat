# 🐾  Zoonoses Info-Chat

O **Zoonoses Info-Chat** é uma plataforma inteligente desenvolvida como projeto de extensão do curso de Análise e Desenvolvimento de Sistemas (ADS). O objetivo é promover a conscientização sobre o bem-estar animal e a prevenção de zoonoses, oferecendo um assistente virtual baseado em Inteligência Artificial para tirar dúvidas da população em tempo real.

## 🚀 Funcionalidades
- **Assistente Virtual Inteligente:** Chatbot integrado ao modelo Gemini (Google) que fornece respostas rápidas e formatadas sobre saúde animal, vacinação e prevenção.
- **Informação Rápida:** Cards interativos para acesso imediato a temas críticos (Emergências, Vacinação Antirrábica, Zoonoses Comuns e Rede de Apoio).
- **Persistência de Dados:** Registro automático de todas as interações no banco de dados para futura análise do perfil de dúvidas da comunidade.
- **Interface Responsiva e Acessível:** Design limpo focado na usabilidade, com suporte a renderização de Markdown para facilitar a leitura das respostas da IA.

## 🛠️ Stack Tecnológica

### Front-end
- **React (Vite):** Biblioteca principal para a construção da interface de usuário.
- **Tailwind CSS:** Framework utilitário para estilização rápida e responsiva.
- **Lucide-React:** Conjunto de ícones vetoriais.
- **React-Markdown:** Renderização de respostas estruturadas (listas, negritos) enviadas pela IA.

### Back-end
- **Java 21:** Versão moderna da linguagem garantindo alta performance.
- **Spring Boot 3.3.4:** Framework robusto para a criação da API REST.
- **Spring Data JPA:** Camada de abstração para facilitar a persistência e consultas no banco.
- **MySQL:** Banco de dados relacional.
- **RestTemplate:** Utilizado para a comunicação HTTP direta e eficiente com a API externa.

### Inteligência Artificial
- **Google Gemini 2.5 Flash:** Modelo de linguagem de alta velocidade utilizado para o processamento de linguagem natural do assistente.

## 🏗️ Arquitetura e Diferenciais Técnicos
Para garantir a máxima estabilidade e contornar problemas de compatibilidade com bibliotecas em versões *Milestone*, este projeto utiliza uma **integração nativa via protocolo HTTP (REST)**. A comunicação com a IA é feita construindo os *payloads* JSON manualmente. Isso permite um controle rigoroso sobre a Engenharia de Prompt, garantindo que o assistente siga estritamente as regras de formatação e o contexto especializado do Centro de Zoonoses.

## 🔧 Como Executar o Projeto

### 1. Banco de Dados
Crie o banco de dados no seu MySQL local:
```sql
CREATE DATABASE zoonoses_db;
```
### 2. Back-end
Configure as credenciais no arquivo src/main/resources/application.properties:

```Properties
spring.datasource.url=jdbc:mysql://localhost:3306/zoonoses_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
gemini.api.key=SUA_CHAVE_API_AQUI
Execute a aplicação Spring Boot (ela rodará na porta 8080).
```

### 3. Front-end
Na pasta do projeto React, instale as dependências e inicie o servidor de desenvolvimento:
```
Bash
npm install
npm run dev
```
Acesse no navegador através da porta local fornecida pelo Vite (geralmente http://localhost:5173).

