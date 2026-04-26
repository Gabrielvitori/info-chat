package com.zoonoses.infochat.controller;

import com.zoonoses.infochat.service.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> conversar(@RequestBody Map<String, String> payload) {
        String pergunta = payload.get("pergunta");
        String respostaIA = chatbotService.processarPergunta(pergunta);

        Map<String, String> resposta = new HashMap<>();
        resposta.put("resposta", respostaIA);

        return ResponseEntity.ok(resposta);
    }
}