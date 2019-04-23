package com.jw.exceptionHandler;

import com.jw.exception.ParameterInvalidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalErrorInfoHandler  extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = GlobalErrorInfoException.class)
//    public ResultBody errorHandlerOverJson(HttpServletRequest request,
//                                           GlobalErrorInfoException exception) {
//        ErrorInfoInterface errorInfo = exception.getErrorInfo();
//        ResultBody result = new ResultBody(errorInfo);
//        return result;
//    }

    /**
     * Handles EntityNotFoundException. Created to encapsulate errors with more detail than javax.persistence.EntityNotFoundException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiError object
     */
    @ExceptionHandler(ParameterInvalidException.class)
    protected ResponseEntity<Object> handleParameterInvalid(
            ParameterInvalidException ex) {
        ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
