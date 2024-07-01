package Store.authorization.handler;


import Store.authorization.handler.person_error.UpdateException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(UpdateException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public void catchResourceNotFoundException(JsonProcessingException e) {
        log.error(e.getMessage(), e);
    }
}
