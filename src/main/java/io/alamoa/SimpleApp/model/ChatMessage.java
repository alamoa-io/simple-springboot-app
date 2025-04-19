package io.alamoa.SimpleApp.service;

import io.alamoa.SimpleApp.logic.ChatLogic;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatLogic chatLogic;

    public ChatService(ChatLogic chatLogic) {
        this.chatLogic = chatLogic;
    }
    public String generateResponse(String userMessage) {
        return chatLogic.getChatResponse(userMessage);
    }
}
