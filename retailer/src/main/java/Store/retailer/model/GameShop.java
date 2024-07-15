package Store.retailer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "GameShop")
public class GameShop {

    @Id
    private String id;

    private String name;

    private String description;

}
