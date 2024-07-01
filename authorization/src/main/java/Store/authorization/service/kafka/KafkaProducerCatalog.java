package Store.authorization.service.kafka;


import Store.authorization.dto.dtoKafka.PersonPayGame;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerCatalog {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendCatalog(String email) {
        kafkaTemplate.send("person", email);
    }

    public void sendSaveEmailCatalog(String email) {
        kafkaTemplate.send("personEmail", email);
    }

    public void sendPayGamePerson(String email) {
        kafkaTemplate.send("personPayGame", email);
    }

}
