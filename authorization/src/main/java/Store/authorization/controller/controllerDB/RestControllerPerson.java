package Store.authorization.controller.controllerDB;

import Store.authorization.dto.dtoController.PersonDTO;
import Store.authorization.model.Person;
import Store.authorization.service.db.PersonService;
import Store.authorization.service.kafka.KafkaProducerCatalog;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
public class RestControllerPerson {

    private final PersonService personService;

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
    public ResponseEntity<?> savePersonFromDB(@RequestBody PersonDTO personDTO) {
        personService.savePersonInDB(personDTO);
        kafkaProducerCatalog.sendSaveEmailCatalog(personDTO.email());
        return  ResponseEntity.ok("Пользователь успешно добавлен");
    }

    @PutMapping
    public ResponseEntity<?> updatePersonInDB(@RequestBody PersonDTO personDTO) {
        personService.updatePersonFromDB(personDTO);
        return  ResponseEntity.ok("Пользователь успешно обновлен");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePersonFromDB(@PathVariable("id") Long id) {
        personService.deletePersonFromDB(id);
        return  ResponseEntity.ok("Пользователь успешно удолен");
    }
}
