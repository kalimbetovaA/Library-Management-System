package kz.iitu.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String description;
    private Long author_id;
    private Long publisher_id;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    @Override
    public String toString() {
        return id+") name: " + name + "\n"+
                "description: " + description + "\n";
    }
}
