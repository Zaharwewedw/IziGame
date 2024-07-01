package Store.category.model;


import Store.category.dto.controller_dto.GameDTO;
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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private Integer price;

    @ManyToMany
    @JoinTable(
            schema = "gem",
            name = "catalag",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "person_directory_id")
    )
    private List<PersonDirectory> personDirectories;

    public Game(GameDTO gameDTO) {
        this.name = gameDTO.name();
        this.genre = gameDTO.genre();
        this.price = gameDTO.price();
    }
}
