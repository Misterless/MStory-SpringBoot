package site.metacoding.blogv4.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.metacoding.blogv4.handler.ex.CustomApiException;
import site.metacoding.blogv4.handler.ex.CustomException;
import site.metacoding.blogv4.util.Script;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(Exception e){ //fetch 요청시
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(CustomException.class)
    public String htmlException(Exception e){ //일반적 요청 Get(a tag) Post(form tag)

        return Script.back(e.getMessage());
    }
}
