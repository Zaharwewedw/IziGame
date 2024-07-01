package Store.authorization.service.db;

import Store.authorization.dto.dtoController.PersonDTO;
import Store.authorization.handler.person_error.UpdateException;
import Store.authorization.model.Person;
import Store.authorization.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public void savePersonInDB(PersonDTO person) {
        Person personSave = new Person(person);
        personRepository.save(personSave);
    }

    @Override
    @Transactional
    public Person getPersonFromDB(Long id) {
        return personRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Person> getAllPersonFromDB() {
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePersonFromDB(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updatePersonFromDB(PersonDTO person) {

        if (personRepository.getPersonByNickname(person.nickname()).isPresent())
            personRepository.save(new Person(person));

        throw new UpdateException("Такого пользываетля не существует");
    }
}
