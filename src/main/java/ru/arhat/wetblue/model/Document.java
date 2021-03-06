package ru.arhat.wetblue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by etovladislav on 21.06.16.
 */
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
