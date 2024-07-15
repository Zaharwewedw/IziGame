package Store.authorization.handler.person_error;

public class PersonNotFountDataBase extends RuntimeException {

    public PersonNotFountDataBase(String message){
        super(message);
    }
}
