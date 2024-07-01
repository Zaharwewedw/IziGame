package Store.authorization.controller.kafka_controller;


import Store.authorization.dto.dtoKafka.PersonPayGame;
import Store.authorization.service.kafka.KafkaProducerCatalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
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

   @SneakyThrows(value = JsonProcessingException.class)
   @PostMapping("/pay")
    public String sendPersonPayGame(@RequestBody PersonPayGame pay) {

       ObjectMapper objectMapper = new ObjectMapper();
       String json = objectMapper.writeValueAsString(pay);
       kafkaProducerCatalog.sendPayGamePerson(json);

        return "Success";
    }
}
