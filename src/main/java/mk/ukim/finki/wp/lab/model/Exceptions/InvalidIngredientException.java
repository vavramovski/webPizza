package mk.ukim.finki.wp.lab.model.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidIngredientException extends RuntimeException {

    public InvalidIngredientException() {
        super(InvalidIngredientException.class.getSimpleName());
    }

}

