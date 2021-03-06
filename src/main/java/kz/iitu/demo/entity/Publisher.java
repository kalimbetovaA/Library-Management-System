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
@Table(name = "publishers")
public class Publisher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Publisher ID")
    private Long id;
    @ApiModelProperty(notes = "The Publisher Name")
    private String name;
    @ApiModelProperty(notes = "The Publisher Description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> books;
}
