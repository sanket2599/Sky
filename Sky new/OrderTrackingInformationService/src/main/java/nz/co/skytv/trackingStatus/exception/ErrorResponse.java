package nz.co.skytv.trackingStatus.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ErrorResponse Class.
 * @author Sanket Kumar and Soumya Mitra
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String code;
    private String description;
    private String message;
}
