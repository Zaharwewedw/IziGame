package Store.authorization.repository;

import Store.authorization.model.Person;
import Store.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RepositoryRole extends JpaRepository<Role, Long> {

    @Transactional(readOnly = true)
    Optional<Role> getRoleByRoleUser(String roleUser);
}
