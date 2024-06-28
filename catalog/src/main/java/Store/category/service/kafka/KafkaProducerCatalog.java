package Store.category.service.kafka;


import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerCatalog {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendCatalog(String email) {
        kafkaTemplate.send("person", email);
    }

}
