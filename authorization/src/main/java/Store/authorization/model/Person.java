package Store.authorization.model;


import Store.authorization.dto.dtoController.PersonDTO;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Email
    @UniqueElements
    private String email;

    private String password;

    @UniqueElements
    private String nickname;

    public Person (PersonDTO personDTO) {
        this.name = personDTO.name();
        this.firstName = personDTO.firstName();
        this.email = personDTO.email();
        this.password = personDTO.password();
        this.nickname = personDTO.nickname();
    }
}
