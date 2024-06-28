package Store.category.service.kafka;


import Store.category.dto.PersonDirectoryDTO;
import Store.category.service.db.PersonDirectoryService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogConsumerKafka {

    private final PersonDirectoryService personDirectoryService;

    @KafkaListener(topics = "person", groupId = "consumer_catalog")
    public void listenCatalog(String message) {
        System.out.println(message);
    }

    @KafkaListener(topics = "personEmail", groupId = "consumer_catalog")
    public void listenEmailPerson(String email) {
        personDirectoryService.savePersonDirectoryInDB(new PersonDirectoryDTO(email));
    }
}
