package Store.category.handler.error;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AppError {

    private String message;

    private int status;
}
