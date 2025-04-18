package io.alamoa.SimpleApp.model;

public class ChatMessage {
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    String userMessage;

    public String getChatGPTResponse() {
        return chatGPTResponse;
    }

    public void setChatGPTResponse(String chatGPTResponse) {
        this.chatGPTResponse = chatGPTResponse;
    }

    String chatGPTResponse;
}
