package kz.iitu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Role ID")
    private Long id;
    @ApiModelProperty(notes = "The Role Name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
