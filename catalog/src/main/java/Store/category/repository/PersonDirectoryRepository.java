package Store.category.repository;

import Store.category.model.PersonDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PersonDirectoryRepository extends JpaRepository<PersonDirectory, Long> {

    Optional<PersonDirectory> getPersonDirectoriesByEmail(String email);
}
