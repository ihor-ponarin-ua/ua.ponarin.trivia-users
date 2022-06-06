package ua.ponarin.triviausers.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Log4j2
public class UsersExceptionHandler {
    @ExceptionHandler({
            javax.validation.ConstraintViolationException.class,
            org.hibernate.exception.ConstraintViolationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleConstraintViolationException(RuntimeException ex) {
        log.warn(ex);
    }
}