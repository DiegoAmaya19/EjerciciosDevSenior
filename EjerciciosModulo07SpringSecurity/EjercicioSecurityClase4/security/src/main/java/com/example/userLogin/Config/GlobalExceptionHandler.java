package com.example.userLogin.Config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.userLogin.Exception.BadLoginException;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

public class GlobalExceptionHandler {
    
    @ExceptionHandler(BadLoginException.class)
    public ResponseEntity<ApiErrorResponse> handleBadLoginException(BadLoginException ex, HttpServletRequest request){
        
        var response = new ApiErrorResponse(HttpStatus.UNAUTHORIZED,"Credenciales invalidas", request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @Data
    public class ApiErrorResponse{
    
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime tiempotamp;

        private Integer status;
        private String error;
        private String message;
        private String path;

        public ApiErrorResponse(HttpStatus status, String message, String path) {
            this.tiempotamp = LocalDateTime.now();
            this.status = status.value();
            this.error = status.getReasonPhrase();
            this.message = message;
            this.path = path;
        }
    }
}
