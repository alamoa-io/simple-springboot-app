package io.alamoa.SimpleApp.controller;

import io.alamoa.SimpleApp.mapper.ChatHistoriesMapper;
import io.alamoa.SimpleApp.model.ChatMessage;
import io.alamoa.SimpleApp.model.ChatHistory;
import io.alamoa.SimpleApp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    @Autowired
    private ChatHistoriesMapper userMapper;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String showChatPage(Model model) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserMessage("");
        model.addAttribute("chatMessage", chatMessage);
        model.addAttribute("lineSeparator", System.lineSeparator());

        List<ChatHistory> chatHistories = userMapper.findAll();
        model.addAttribute("chatHistories", chatHistories);
        return "chatView";
    }

    @PostMapping("/chat")
    public String handleChat(@ModelAttribute ChatMessage chatMessage, Model model) {
        String userMessage = chatMessage.getUserMessage();
        String response = chatService.generateResponse(userMessage);
        userMapper.insert(new ChatHistory(userMessage,response));
        chatMessage.setChatGPTResponse(response);

        model.addAttribute("userMessage", "");
        model.addAttribute("chatMessage", chatMessage);
        model.addAttribute("lineSeparator", System.lineSeparator());
        List<ChatHistory> chatHistories = userMapper.findAll();
        model.addAttribute("chatHistories", chatHistories);
        return "chatView";
    }

    @PostMapping("/chat/updateMemo")
    public String updateMemo(@RequestParam("id") int id,
                             @RequestParam("memo") String memo) {
        userMapper.updateMemo(id, memo);
        return "redirect:/chat"; // 更新後にリダイレクト
    }

    @PostMapping("/chat/delete")
    public String delete(@RequestParam("id") long id) {
        userMapper.deleteById(id);
        return "redirect:/chat";
    }

}
