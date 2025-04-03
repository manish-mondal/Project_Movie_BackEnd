package com.project0.movie.exception;

import com.project0.movie.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustimizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //chapter 180
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                ex.getMessage(),request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR );

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(Exception ex, WebRequest request) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {


        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
