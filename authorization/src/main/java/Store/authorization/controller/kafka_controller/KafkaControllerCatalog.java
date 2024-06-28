package Store.authorization.controller.kafka_controller;


import Store.authorization.service.kafka.KafkaProducerCatalog;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
@AllArgsConstructor
public class KafkaControllerCatalog {

    private final KafkaProducerCatalog kafkaProducerCatalog;

    @PostMapping
    public String sendPersonEmail(@RequestBody String email) {

        kafkaProducerCatalog.sendCatalog(email);

        return "Success";
    }

   /* @PostMapping
    public String sendPersonPayGame(@RequestBody String email) {

        kafkaProducerCatalog.sendCatalog(email);

        return "Success";
    }*/
}
