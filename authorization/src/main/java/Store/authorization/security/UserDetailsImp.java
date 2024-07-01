package Store.authorization.security;

import Store.authorization.model.Person;
import Store.authorization.model.Role;
import Store.authorization.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@AllArgsConstructor
public class UserDetailsImp implements UserDetails {

    private final Person person;

    private final PersonRepository personRepository;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Optional<Person> optionalUser = personRepository.getPersonByNickname(person.getNickname());
        Set<Role> roles = optionalUser.map(Person::getRoleSet).orElse(new HashSet<>());
        return new ArrayList<>(roles);
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}