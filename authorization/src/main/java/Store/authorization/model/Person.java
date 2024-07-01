package Store.authorization.model;


import Store.authorization.dto.dtoController.PersonDTO;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "per")
public class Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstName;

    private String email;

    private String password;

    private String nickname;

    @ManyToMany
    @JoinTable(name = "users_roles", schema = "per")
    private Set<Role> roleSet = new HashSet<>();

    public Person (PersonDTO personDTO) {
        this.name = personDTO.name();
        this.firstName = personDTO.firstName();
        this.email = personDTO.email();
        this.nickname = personDTO.nickname();
    }
}
