package Store.category.service.db;

import Store.category.dto.GameDTO;
import Store.category.model.Game;
import Store.category.repository.GameRepository;
import Store.category.service.db.ServiceGame;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceGameImpl implements ServiceGame {

    private final GameRepository gameRepository;

    @Override
    @Transactional
    public void saveGameInDB(GameDTO game) {
        gameRepository.save(new Game(game));
    }

    @Override
    public Game getGameFromDB(Long id) {
        return gameRepository.getReferenceById(id);
    }

    @Override
    public List<Game> getAllGameFromDB() {
        return gameRepository.findAll();
    }

    @Override
    public void deleteGameFromDB(Long id) {

    }

    @Override
    public void updateGameFromDB(GameDTO person) {
        gameRepository.save(new Game(person));
    }
}
