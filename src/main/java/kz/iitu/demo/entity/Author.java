package kz.iitu.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String about;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return id+") name: " + name + "\n"+
                "about: " + about + "\n";
    }
}
