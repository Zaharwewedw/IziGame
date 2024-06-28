package Store.category.model;


import Store.category.dto.GameDTO;
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

    @ManyToOne
    private PersonDirectory game;

    public Game(GameDTO gameDTO) {
        this.name = gameDTO.name();
        this.genre = gameDTO.genre();
        this.price = gameDTO.price();
    }
}
