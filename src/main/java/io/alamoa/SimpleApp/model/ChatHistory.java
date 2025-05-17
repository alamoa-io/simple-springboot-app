package io.alamoa.SimpleApp.model;

public class ChatHistory {
    private Long id;
    private String question;
    private String answer;
    private String memo;

    public ChatHistory(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    // toString（デバッグ用）
    @Override
    public String toString() {
        return "ChatHistory{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
