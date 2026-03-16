package co.istad.chhaya.fswd_sbapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppGlobalException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationEx(MethodArgumentNotValidException e){
        List<FiledErrorResponse> filedErrorResponseList = new ArrayList<>();
        e.getFieldErrors().forEach(fieldError ->
                filedErrorResponseList.add(
                        new FiledErrorResponse(
                             fieldError.getField(),
                                fieldError.getDefaultMessage()

                        )
                ));
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Request data is valid...!")
                .timestamp(Instant.now())
                .errorDetail(filedErrorResponseList)
                .build();
    }

    @ExceptionHandler(value = ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleServiceEx(ResponseStatusException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(e.getStatusCode().toString())
                .code(e.getStatusCode().value())
                .message(e.getReason())
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(errorResponse, e.getStatusCode());

    }
}
