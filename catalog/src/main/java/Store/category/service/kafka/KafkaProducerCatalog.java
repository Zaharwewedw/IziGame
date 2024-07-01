package Store.category.service.kafka;


import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerCatalog {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendCatalog(Object email) {
        kafkaTemplate.send("person", email);
    }

    public void messagePayPerson(Object message) {
        kafkaTemplate.send("PayPerson", message);
    }

}
