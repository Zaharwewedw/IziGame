package Store.retailer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "GameShop")
public class Shop {

    @Id
    private String id;

    private String name;

    private String description;

}
