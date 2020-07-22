package com.nabenik.kukulkan.model;


import javax.persistence.*;

@Entity
@Table(name="phrase")
public class Phrase {

    @Id
    @Column(name="phrase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long phraseId;

    @Column(name="author")
    private String author;

    @Column(name="phrase")
    private String phrase;

    public Long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(Long phraseId) {
        this.phraseId = phraseId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
