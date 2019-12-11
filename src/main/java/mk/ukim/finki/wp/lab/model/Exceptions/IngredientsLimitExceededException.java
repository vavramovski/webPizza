package mk.ukim.finki.wp.lab.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IngredientsLimitExceededException extends RuntimeException {

    public IngredientsLimitExceededException() {
        super(IngredientsLimitExceededException.class.getSimpleName());
    }

}
