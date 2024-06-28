package Store.category.repository;

import Store.category.model.PersonDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDirectoryRepository extends JpaRepository<PersonDirectory, Long> {
}
