package Store.authorization.dto.dtoController;

import jakarta.validation.constraints.Email;

public record PersonDTO(String name, String firstName,
                        @Email String email, String password,
                        String nickname) {
}
