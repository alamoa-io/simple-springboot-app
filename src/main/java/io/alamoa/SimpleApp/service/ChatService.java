package io.alamoa.SimpleApp.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String generateResponse(String userMessage) {
        return "これはあなたのメッセージへの応答です: 「" + userMessage + "」";
    }
}
