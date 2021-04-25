package kz.iitu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"users"})
@NoArgsConstructor
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    @ApiModelProperty(notes = "Authors of Book")
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "publisher_id")
    @ApiModelProperty(notes = "Publisher of Book")
    private Publisher publisher;

    @JsonIgnore
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "books_categories", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
            @JoinColumn(name = "category_id") })
    private List<Category> categories;

}
