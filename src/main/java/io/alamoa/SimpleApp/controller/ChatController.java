package io.alamoa.SimpleApp.controller;

import io.alamoa.SimpleApp.model.ChatMessage;
import io.alamoa.SimpleApp.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserMessage("");
        model.addAttribute("chatMessage", chatMessage);
        model.addAttribute("lineSeparator", System.lineSeparator());
        return "chatView";
    }

    @PostMapping("/chat")
    public String handleChat(@ModelAttribute ChatMessage chatMessage, Model model) {
        String userMessage = chatMessage.getUserMessage();
        String chatGPTResponse = "これはChatGPTの応答です: " + userMessage;
        chatMessage.setChatGPTResponse(chatGPTResponse);

        model.addAttribute("chatMessage", chatMessage);
        model.addAttribute("lineSeparator", System.lineSeparator());
        return "chatView";
    }

}
