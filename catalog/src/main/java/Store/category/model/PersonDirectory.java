package Store.category.model;


import Store.category.dto.GameDTO;
import Store.category.dto.PersonDirectoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(schema = "gem")
public class PersonDirectory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @OneToMany
    private List<Game> game;

    public PersonDirectory(PersonDirectoryDTO personDirectoryDTO) {
        this.email = personDirectoryDTO.email();
    }

}
