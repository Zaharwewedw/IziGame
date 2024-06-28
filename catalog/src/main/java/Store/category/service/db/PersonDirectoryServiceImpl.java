package Store.category.service.db;

import Store.category.dto.PersonDirectoryDTO;
import Store.category.model.Game;
import Store.category.model.PersonDirectory;
import Store.category.repository.PersonDirectoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonDirectoryServiceImpl implements PersonDirectoryService {

    private final PersonDirectoryRepository personDirectoryRepository;

    @Override
    @Transactional
    public void savePersonDirectoryInDB(PersonDirectoryDTO person) {
        personDirectoryRepository.save(new PersonDirectory(person));
    }

    @Override
    @Transactional(readOnly = true)
    public Game getPersonDirectoryFromDB(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDirectory> getAllPersonDirectoryFromDB() {
        return null;
    }

    @Override
    @Transactional
    public void deletePersonDirectoryFromDB(Long id) {

    }

    @Override
    @Transactional
    public void updatePersonDirectoryFromDB(PersonDirectoryDTO person) {

    }
}
