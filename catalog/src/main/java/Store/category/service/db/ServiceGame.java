package Store.category.service.db;

import Store.category.dto.GameDTO;
import Store.category.model.Game;

import java.util.List;

public interface ServiceGame {

    void saveGameInDB(GameDTO person);

    Game getGameFromDB(Long id);

    List<Game> getAllGameFromDB();

    void deleteGameFromDB(Long id);

    void updateGameFromDB(GameDTO person);
}
