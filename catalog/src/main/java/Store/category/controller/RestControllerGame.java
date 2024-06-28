package Store.category.controller;


import Store.category.dto.GameDTO;
import Store.category.model.Game;
import Store.category.service.db.ServiceGame;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class RestControllerGame {

    private final ServiceGame serviceGame;

    @GetMapping("{id}")
    public ResponseEntity<Game> getLastGame(@PathVariable("id") Long id) {
        return new ResponseEntity<>(serviceGame.getGameFromDB(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGame() {
        return new ResponseEntity<>(serviceGame.getAllGameFromDB(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveGameInBD(GameDTO personDTO) {

        serviceGame.saveGameInDB(personDTO);
        return ResponseEntity.ok("игра успешна добавлен");

    }

    @PutMapping
    public ResponseEntity<?> updateGameInBD(GameDTO personDTO) {

        serviceGame.updateGameFromDB(personDTO);
        return ResponseEntity.ok("игра успешна обновлена");
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {

        serviceGame.deleteGameFromDB(id);

        return ResponseEntity.ok("игра успешна удолена");
    }
}
