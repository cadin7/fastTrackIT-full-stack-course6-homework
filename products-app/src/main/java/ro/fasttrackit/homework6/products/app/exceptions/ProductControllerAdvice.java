package ro.fasttrackit.homework6.products.app.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiException handleResourceNotFoundException(ResourceNotFoundException rnfe){
        return new ApiException(1001, rnfe.getMessage());
    }
}

@Value
class ApiException {
    int code;
    String message;
}
