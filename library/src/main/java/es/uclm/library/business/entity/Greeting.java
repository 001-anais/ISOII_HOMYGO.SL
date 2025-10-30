package es.uclm.library.business.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String person;
    private String content;

    public Greeting() {}

    public Greeting(String person, String content) {
        this.person = person;
        this.content = content;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPerson() { return person; }
    public void setPerson(String person) { this.person = person; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

