package pl.strefakursow.springadvanced.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
@Getter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String name;


    @ManyToMany(mappedBy = "roles")
    private List<User> user;
}
