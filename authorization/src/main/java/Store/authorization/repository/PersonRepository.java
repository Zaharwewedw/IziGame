package Store.authorization.repository;

import Store.authorization.model.Person;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Transactional
    void deleteById(Long id);

    Optional<Person> getPersonById(Long id);

    @Transactional(readOnly = true)
    Optional<Person> getPersonByNickname(String nic);
}
