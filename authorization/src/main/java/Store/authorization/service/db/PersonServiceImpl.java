package Store.authorization.service.db;

import Store.authorization.dto.dtoController.PersonDTO;
import Store.authorization.dto.dtoController.RoleDTO;
import Store.authorization.handler.person_error.UpdateException;
import Store.authorization.model.Person;
import Store.authorization.model.Role;
import Store.authorization.repository.PersonRepository;
import Store.authorization.repository.RepositoryRole;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final RepositoryRole repositoryRole;

    @Transactional
    @PostConstruct
    public void registerDefault() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(repositoryRole.save(new Role(new RoleDTO("ROLE_ADMIN"))));
        roleSet.add(repositoryRole.save(new Role(new RoleDTO("ROLE_USER"))));
        personRepository.save(Person.builder()
                .name("Zahar")
                .firstName("Tolstikov")
                .nickname("zahardo")
                .password(passwordEncoder.encode("qwer2001"))
                .email("tolst.0.2.5@bk.ru")
                .roleSet(roleSet)
                .build());
    }

    @Override
    @Transactional
    public void savePersonInDB(PersonDTO person) {
        Person personSave = new Person(person);
        Set<Role> roleSet = new HashSet<>();

        roleSet.add(repositoryRole.getRoleByRoleUser("ROLE_USER").get());
        personSave.setRoleSet(roleSet);

        personSave.setPassword(passwordEncoder.encode(person.password()));
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
