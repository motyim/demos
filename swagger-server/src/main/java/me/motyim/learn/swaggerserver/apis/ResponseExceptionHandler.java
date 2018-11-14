package me.motyim.learn.swaggerserver.apis;

import lombok.extern.slf4j.Slf4j;
import me.motyim.learn.swaggerserver.exception.UserNotFoundException;
import me.motyim.learn.swaggerserver.response.ErrorDetails;
import me.motyim.learn.swaggerserver.response.Response;
import me.motyim.learn.swaggerserver.enums.ResponseEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/11/2018
 */
@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
                ex.getBindingResult().toString());
        Response<ErrorDetails> response = new Response<>(ResponseEnum.VALIDATION_ERROR ,errorDetails);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    //handle validation exception on primitive params
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity constraintViolationHandler(ConstraintViolationException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
                ex.getConstraintViolations().iterator().next().getMessage());
        Response<ErrorDetails> response = new Response<>(ResponseEnum.VALIDATION_ERROR ,errorDetails);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Response> hangleNoUserFound(UserNotFoundException ex){
        ex.printStackTrace();
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error In Operation",
                ex.getMessage());
        Response<ErrorDetails> response = new Response<>(ResponseEnum.ERROR ,errorDetails);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Response<ErrorDetails>> hangleException(Exception ex){
        ex.printStackTrace();
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "General Exception",
                ex.getMessage());
        Response<ErrorDetails> response = new Response<>(ResponseEnum.ERRORINSERVER ,errorDetails);
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
