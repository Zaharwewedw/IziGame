package Store.authorization.controller.controllerDB;

import Store.authorization.dto.dtoController.PersonDTO;
import Store.authorization.model.Person;
import Store.authorization.service.db.PersonService;
import Store.authorization.service.kafka.KafkaProducerCatalog;
import Store.authorization.util.UserValidation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
public class RestControllerPerson {

    private final PersonService personService;

    private final UserValidation userValidator;

    private final KafkaProducerCatalog kafkaProducerCatalog;

    @GetMapping("{id}")
    public ResponseEntity<Person> getLastPerson(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.getPersonFromDB(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        return new ResponseEntity<>(personService.getAllPersonFromDB(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePersonFromDB(@Valid @RequestBody PersonDTO personDTO,
                                              BindingResult result) {

        userValidator.validate(personDTO, result);
        if (result.hasErrors()) return getError(result);

        personService.savePersonInDB(personDTO);
        kafkaProducerCatalog.sendSaveEmailCatalog(personDTO.email());

        return  ResponseEntity.ok("Пользователь успешно добавлен");
    }

    @PutMapping
    public ResponseEntity<?> updatePersonInDB(@Valid @RequestBody PersonDTO personDTO,
                                              BindingResult result) {
        userValidator.validate(personDTO, result);
        if (result.hasErrors()) return getError(result);

        personService.updatePersonFromDB(personDTO);
        return  ResponseEntity.ok("Пользователь успешно обновлен");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersonFromDB(@PathVariable("id") Long id) {
        personService.deletePersonFromDB(id);
        return  ResponseEntity.ok("Пользователь успешно удолен");
    }

    private ResponseEntity<?> getError(BindingResult result) {
        return ResponseEntity.badRequest().body(result.getAllErrors().stream()
                .map(err -> err instanceof FieldError ? ((FieldError) err).getField() + ":"
                        + err.getDefaultMessage() : err.getDefaultMessage()).collect(Collectors.toList()));
    }
}
