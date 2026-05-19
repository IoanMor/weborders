package my.project.weborders.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

   @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAll(Exception e){
       log.error("ERROR:/" + e + "\n"+ e.getMessage());

       return ResponseEntity.status(500).body("Что то пошло не так");
   }
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResource(NoResourceFoundException e) {
        return ResponseEntity.status(404).build();
    }


}
