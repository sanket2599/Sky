package nz.co.skytv.trackingStatus.common;

import org.slf4j.Marker;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Application Messages.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Messages {

	// API Response Messages
	public static final String SUCCESS = "Success";
	public static final String SYSTEMERROR = "System Error. Please contact system admin";
	public static final String INTERNALSERVERERROR = "Internal Server Error";
	public static final String DATABASEEXCEPTION = "Database Exception";
	public static final String NODATAFOUND = "No Data Found";
	public static final String BADREQUEST = "Bad Request";
	public static final String INVALID_INPUT = "Invalid Input";

	// Utility Functions Messages
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final String ALPHABET_A_Z_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHABET_A_Z_SMALL = "abcdefghijklmnopqrstuvxyz";
	public static final String DIGITS_0_9 = "0123456789";
	public static final String APP_STARTED_SUCCESS = "Application Started Successfully";
	public static final String ERROR_FORMATTING_DATE = "Error occured while formatting Date Format : %s";
	public static final String ERROR_CONVERT_EPOCH_TO_DATE = "Error occured while converting Epoch Timestamp to Date : %s";
	public static final String ERROR_CONVERT_DATE_TO_EPOCH = "Error occured while converting Date to Epoch Timestamp : %s";
	public static final String EXCEPTION_READING_MAPPING_FILES = "Exception occurred while reading Mapping Files: {}";
	public static final String IO_EXCEPTION_READING_MAPPING_FILES = "IO Exception occurred while reading Mapping Files: {}";
	public static final String READ_CUSTOMER_MAPPING_FILES_SUCCESS = "Customer Service Mapping Files Read Successfully";
	public static final String REQUEST_INTERNAL_EXCEPTION_OCCURRED = "Error occurred in parsing Request: {}";

	// MongoDB Connector Messages
	public static final String CLOSING_APP_INCORRECT_DB_CREDENTIALS = "Closing Application. Please Check your MongoDB Credentials";
	public static final String EXCEPTION_CHECKING_DB_CONNECTION = "Exception occured while checking MongoDB Connection: {}";

	public static final String KEYWORD_NICKNAME = "NickName";
	public static final String KEYWORD_NAME = "name";
	public static final String DEFAULT_ACCOUNT_NUMBER = "";
	public static final String EVALUATED_MONGO_QUERY = "Evaluated MongoDB Query: {}";

	// Product API Messages
	public static final String MONGODB_RESULT_FOR_GET_TRACKING_STATUS_BY_ID = "Received Data from MongoDB for Get Tracking Status By Id, Result: {}";
	public static final String RECEIVED_REQ_GET_TRACKING_STATUS = "Received API Request for Get Tracking Status";
	public static final String TRACKING_STATUS_RETRIEVED = "Tracking Status retrieved from Database";
	public static final String PREPARED_RESPONSE_GET_TRACKING_STATUS = "Prepared API Response for Get Tracking Status, Result: {}";
	public static final String TRACKING_STATUS_REQUEST_PARAMS_EMPTY = "Request Parameters received Empty in request";
	public static final String API_EXCEPTION_GET_TRACKING_STATUS = "API Exception: Occurred in retriving order Number";
	public static final String DATA_ACCESS_RESOURCE_EXCEPTION_GET_TRACKING_STATUS = "Data Access Resource Excepion Occurred in retriving order number";
	public static final String EXCEPTION_GET_TRACKING_STATUS = "Excepion Occurred in retriving tracking status";
	public static final String TRACKING_SHIPMENT_ID_PARAMS_EMPTY = "Shipment id is empty";
	public static final String RECEIVED_REQ_TO_POST_SHIPMENT_DETAILS = "Received API Request to Post Shipment Details";
	public static final String MONGODB_RESULT_FOR_UPDATE_SHIPMENT_STATUS_BY_ID = "Shipment callback updated";

}
