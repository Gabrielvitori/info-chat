package com.zoonoses.infochat.service;

import com.zoonoses.infochat.entity.InteracaoChat;
import com.zoonoses.infochat.repository.InteracaoChatRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatbotService {

    private final InteracaoChatRepository repository;
    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    public ChatbotService(InteracaoChatRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
    }

    @Transactional
    public String processarPergunta(String pergunta) {

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;

        String instrucaoSistema = "Você é um assistente especialista do Centro de Zoonoses de João Pessoa. " +
                "Siga ESTAS REGRAS ESTRITAS de formatação:\n" +
                "1. Seja extremamente objetivo, direto e conciso.\n" +
                "2. NUNCA escreva parágrafos longos. Quebre as ideias em frases curtas.\n" +
                "3. Use tópicos e marcadores para listar informações, sintomas ou dicas.\n" +
                "4. Vá direto ao ponto, sem introduções ou conclusões muito longas.\n" +
                "Agora, responda de forma clara a esta dúvida: " + pergunta;

        Map<String, Object> part = new HashMap<>();
        part.put("text", instrucaoSistema);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", List.of(part));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", List.of(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

            Map<String, Object> body = response.getBody();
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) body.get("candidates");
            Map<String, Object> candidateContent = (Map<String, Object>) candidates.get(0).get("content");
            List<Map<String, Object>> parts = (List<Map<String, Object>>) candidateContent.get("parts");
            String respostaIa = (String) parts.get(0).get("text");

            InteracaoChat interacao = new InteracaoChat();
            interacao.setPerguntaUsuario(pergunta);
            interacao.setRespostaIa(respostaIa);
            repository.save(interacao);

            return respostaIa;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao contatar os servidores da Google. Por favor, tente novamente mais tarde.";
        }
    }
}