package com.nabenik.kukulkan.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pillinada")
public class Pillinada implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pillinada_id")
    private Long pillinadaId;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "description")
    private String description;

    public Long getPillinadaId() {
        return pillinadaId;
    }

    public void setPillinadaId(Long pillinadaId) {
        this.pillinadaId = pillinadaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
