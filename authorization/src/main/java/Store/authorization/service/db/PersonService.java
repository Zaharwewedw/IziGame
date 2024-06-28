package Store.authorization.service.db;

import Store.authorization.dto.dtoController.PersonDTO;
import Store.authorization.model.Person;

import java.util.List;

public interface PersonService {

    void savePersonInDB(PersonDTO person);

    Person getPersonFromDB(Long id);

    List<Person> getAllPersonFromDB();

    void deletePersonFromDB(Long id);

    void updatePersonFromDB(PersonDTO person);
}
