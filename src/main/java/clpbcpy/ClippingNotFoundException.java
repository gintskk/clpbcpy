package clpbcpy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Clipping not found")
public class ClippingNotFoundException extends RuntimeException {
}
