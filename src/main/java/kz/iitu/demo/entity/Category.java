package kz.iitu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Category ID")
    private Long id;

    @ApiModelProperty(notes = "The Category Name")
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Book> books;

}
