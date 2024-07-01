package Store.category.service.kafka;


import Store.category.dto.controller_dto.PersonDirectoryDTO;
import Store.category.dto.kafka_dto.PersonPayGame;
import Store.category.service.db.PersonDirectoryService;
import Store.category.service.db.ServiceGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogConsumerKafka {

    private final ServiceGame serviceGame;
    private final PersonDirectoryService personDirectoryService;

    @KafkaListener(topics = "person", groupId = "consumer_catalog")
    public void listenCatalog(String message) {
        System.out.println(message + "11");
    }

    @KafkaListener(topics = "personEmail", groupId = "consumer_catalog")
    public void listenEmailPerson(String email) {
        personDirectoryService.savePersonDirectoryInDB(new PersonDirectoryDTO(email));
    }

    @SneakyThrows
    @KafkaListener(topics = "personPayGame", groupId = "consumer_catalog")
    public void payGamePerson(String pay) {

        ObjectMapper objectMapper = new ObjectMapper();
        PersonPayGame personPayGame = objectMapper.readValue(pay, PersonPayGame.class);

        serviceGame.savePayGameByEmail(personPayGame);


    }
}
