package Store.category.service.db;

import Store.category.dto.controller_dto.GameDTO;
import Store.category.dto.kafka_dto.PersonPayGame;
import Store.category.model.Game;
import Store.category.model.PersonDirectory;
import Store.category.repository.GameRepository;
import Store.category.repository.PersonDirectoryRepository;
import Store.category.service.kafka.KafkaProducerCatalog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceGameImpl implements ServiceGame {

    private final GameRepository gameRepository;
    private final PersonDirectoryRepository personDirectoryRepository;
    private final KafkaProducerCatalog kafkaProducerCatalog;

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
    @Transactional
    public void savePayGameByEmail(PersonPayGame personPayGame) {
        Optional<Game> gameOpt = gameRepository.getGameByGenreAndName(personPayGame.genreGame(), personPayGame.nameGame());
        Optional<PersonDirectory> personDirectoryOpt = personDirectoryRepository.getPersonDirectoriesByEmail(personPayGame.email());
        if (gameOpt.isPresent() && personDirectoryOpt.isPresent()) {
            Game game = gameOpt.get();
            PersonDirectory personDirectory = personDirectoryOpt.get();
            if (!game.getPersonDirectories().contains(personDirectory)) {
                game.getPersonDirectories().add(personDirectory);
                personDirectory.getGame().add(game);
                gameRepository.save(game);
                personDirectoryRepository.save(personDirectory);
                kafkaProducerCatalog.messagePayPerson("игра успешно куплена");
            }
        } else {
            kafkaProducerCatalog.messagePayPerson("Игру не возможно купить");
        }
    }
    @Override
    public void updateGameFromDB(GameDTO person) {
        gameRepository.save(new Game(person));
    }
}
