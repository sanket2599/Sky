package nz.co.skytv.trackingStatus.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * API Response Codes.
 * @author Sanket Kumar and Soumya Mitra
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseCode {

    public static final String SUCCESS = "200";
    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String DATABASE_EXCEPTION = "101";
    public static final String NO_DATA_FOUND = "404";
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String SYSTEM_ERROR = "100";
}
