package Store.category.service.db;

import Store.category.dto.controller_dto.PersonDirectoryDTO;
import Store.category.dto.kafka_dto.PersonPayGame;
import Store.category.model.Game;
import Store.category.model.PersonDirectory;

import java.util.List;

public interface PersonDirectoryService {

    void savePersonDirectoryInDB(PersonDirectoryDTO person);

    Game getPersonDirectoryFromDB(Long id);

    List<PersonDirectory> getAllPersonDirectoryFromDB();

    void deletePersonDirectoryFromDB(Long id);

    void updatePersonDirectoryFromDB(PersonDirectoryDTO person);

    public void savePayGameByEmail(PersonPayGame personPayGame);
}
