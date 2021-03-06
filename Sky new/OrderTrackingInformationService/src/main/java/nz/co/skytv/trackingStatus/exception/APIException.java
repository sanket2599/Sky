package nz.co.skytv.trackingStatus.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * API Exception Configuration.
 * @author Sanket Kumar and Soumya Mitra
 */

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class APIException extends RuntimeException {

    private final transient ErrorResponse errorResponse = new ErrorResponse();

    /**
     * Parameterised Constructor for Initializing Error Response.
     * 
     * @param exceptionMessage Exception Message
     * @param httpStatus       HttpStatus of Error
     */
    public APIException(String exceptionType, String exceptionMessage, HttpStatus httpStatus) {
        errorResponse.setCode(Integer.toString(httpStatus.value()));
        errorResponse.setMessage(exceptionType);
        errorResponse.setDescription(exceptionMessage);
    }
}
