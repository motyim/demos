package me.motyim.learn.swaggerserver.apis;

import lombok.extern.slf4j.Slf4j;
import me.motyim.learn.swaggerserver.exception.UserNotFoundException;
import me.motyim.learn.swaggerserver.response.ErrorDetails;
import me.motyim.learn.swaggerserver.response.Response;
import me.motyim.learn.swaggerserver.response.ResponseEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
        log.info("Into Error Handler");
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
                ex.getBindingResult().toString());
        Response<ErrorDetails> response = new Response<>(ResponseEnum.ERROR ,errorDetails);
        log.info("Exist Error Handler");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    // TODO: 11/12/2018 Finish this seniro 
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Response> hangleNoUserFound(UserNotFoundException ex){
        return null;
    }
}
