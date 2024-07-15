package Store.retailer.repository;

import Store.retailer.model.GameShop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<GameShop, String> {

}
