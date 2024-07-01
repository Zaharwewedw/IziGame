package Store.authorization.service.security_service;

import Store.authorization.model.Person;
import Store.authorization.repository.PersonRepository;
import Store.authorization.security.UserDetailsImp;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServerImpl implements UserDetailsService {

    private final PersonRepository personRepository;


    public Person getUserByUsernameController(String username) {
        Optional<Person> user = personRepository.getPersonByNickname(username);
        return user.get();
    }

    public Person getUserPrincipalByUsername(String username) {
        return  personRepository.getPersonByNickname(username).get();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = personRepository.getPersonByNickname(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetailsImp(user.get(), personRepository);
    }
}
