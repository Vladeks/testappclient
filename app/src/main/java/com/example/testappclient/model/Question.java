package com.example.testappclient.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Question {

    private Long id;
    private String text;
    private QuestionType type;
    private Set<Answer> answers = new HashSet<>();

    public Question() {
    }

    public Question( String text, QuestionType type) {
        this.text = text;
        this.type = type;
    }

    public Question( String text, QuestionType type, Set<Answer> answers) {
        this.text = text;
        this.type = type;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = QuestionType.valueOf(type);
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
