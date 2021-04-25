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
@ToString(exclude = {"books"})
@NoArgsConstructor
@Table(name = "authors")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Author ID")
    private Long id;
    @ApiModelProperty(notes = "The Author Name")
    private String name;
    @ApiModelProperty(notes = "The Author Info")
    private String about;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Book> books;
}
