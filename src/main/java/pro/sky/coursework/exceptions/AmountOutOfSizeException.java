package pro.sky.coursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountOutOfSizeException extends RuntimeException {

    public AmountOutOfSizeException(String message) {
        super(message);
    }
}
