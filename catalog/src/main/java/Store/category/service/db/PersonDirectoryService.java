package Store.category.service.db;

import Store.category.dto.PersonDirectoryDTO;
import Store.category.model.Game;
import Store.category.model.PersonDirectory;

import java.util.List;

public interface PersonDirectoryService {

    void savePersonDirectoryInDB(PersonDirectoryDTO person);

    Game getPersonDirectoryFromDB(Long id);

    List<PersonDirectory> getAllPersonDirectoryFromDB();

    void deletePersonDirectoryFromDB(Long id);

    void updatePersonDirectoryFromDB(PersonDirectoryDTO person);
}
