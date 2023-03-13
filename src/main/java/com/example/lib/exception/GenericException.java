package com.example.lib.exception;

import com.example.lib.dto.ErrorCode;
import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Data
public class GenericException extends RuntimeException {

    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

}
