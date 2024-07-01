package Store.category.handler.error;


import Store.category.handler.error.kafka_exception.PayGameException;
import Store.category.service.kafka.KafkaProducerCatalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler {
    KafkaProducerCatalog kafkaProducerCatalog;
    @ExceptionHandler
    public void catchResourceNotFoundException(PayGameException e) {
        log.error(e.getMessage(), e);
    }
    @ExceptionHandler
    public void catchResourceNotFoundException(JsonProcessingException e) {
        log.error(e.getMessage(), e);
    }
}
