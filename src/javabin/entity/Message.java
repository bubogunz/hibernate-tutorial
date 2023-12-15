package javabin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID",unique=true, nullable = false)
    private Long id;

    @Column(name="TEXT")
    private String text;

    public Message() {}
    public Message(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", text=" + text + "]";
    }

}












