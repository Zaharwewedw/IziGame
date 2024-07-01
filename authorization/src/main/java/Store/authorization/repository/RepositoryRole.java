package Store.authorization.repository;

import Store.authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRole extends JpaRepository<Role, Long> {
}
