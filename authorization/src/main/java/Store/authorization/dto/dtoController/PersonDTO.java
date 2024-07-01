package Store.authorization.dto.dtoController;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record PersonDTO(
        String name,
        String firstName,
        @Email(message = "The email is not correct")
        String email,
        @Size(min = 4, message = "The allowed password characters are at least 4")
        String password,
        String nickname) {
}
