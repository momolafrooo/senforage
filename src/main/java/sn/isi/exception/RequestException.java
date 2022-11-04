package sn.isi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestException extends RuntimeException {
    private String message;
    private HttpStatus status;
}
