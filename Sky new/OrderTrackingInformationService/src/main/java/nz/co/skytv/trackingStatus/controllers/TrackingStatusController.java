package nz.co.skytv.trackingStatus.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nz.co.skytv.trackingStatus.common.Constants;
import nz.co.skytv.trackingStatus.common.Messages;
import nz.co.skytv.trackingStatus.common.ResponseCode;
import nz.co.skytv.trackingStatus.exception.APIException;
import nz.co.skytv.trackingStatus.exception.ErrorResponse;
import nz.co.skytv.trackingStatus.models.entities.Shipment;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;
import nz.co.skytv.trackingStatus.models.responses.ShipmentCallbackResponse;
import nz.co.skytv.trackingStatus.models.responses.TrackingStatusResponse;
import nz.co.skytv.trackingStatus.services.TrackingStatusService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tracking Status Controller Configuration.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */

@RestController
@RequestMapping(value = "/item-tracking/v1")
public class TrackingStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingStatusController.class);

	@Autowired
	private TrackingStatusService trackingStatusService;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * @param orderNumber
	 * @return responseEntity
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "trackingStatus/{order_number}", produces = Constants.CONTENT_TYPE_APPLICATION_JSON)
	public ResponseEntity<Object> getTrackingStatusDetails(@PathVariable("order_number") String orderNumber)
			throws JsonProcessingException {

		ResponseEntity<Object> responseEntity = null;
		if ((orderNumber == null || orderNumber.equals(""))) {
			// Sending Response as Invalid Input in case orderNumber is not
			// sent in request
			LOGGER.error(Messages.TRACKING_STATUS_REQUEST_PARAMS_EMPTY);
			responseEntity = new ResponseEntity<>(
					new ErrorResponse(ResponseCode.BAD_REQUEST, Messages.INVALID_INPUT, Messages.INVALID_INPUT),
					HttpStatus.BAD_REQUEST);

		} else {

			try {
				// Invoke Service method to retrieve Tracking Status based on orderNumber

				LOGGER.debug(Messages.RECEIVED_REQ_GET_TRACKING_STATUS);

				Object trackingStatusResponse = trackingStatusService.getTrackingStatusByOrderNumber(orderNumber);

				LOGGER.info(Messages.TRACKING_STATUS_RETRIEVED);
				String trackingStatusResponseJson = objectMapper.writeValueAsString(trackingStatusResponse);
				LOGGER.debug(Messages.PREPARED_RESPONSE_GET_TRACKING_STATUS, trackingStatusResponseJson);

				responseEntity = new ResponseEntity<>(trackingStatusResponse, HttpStatus.OK);

			} catch (APIException ex) {
				// Exception Occurred if No Data found, or Error occurred while preparing
				// response Data
				LOGGER.error(Messages.API_EXCEPTION_GET_TRACKING_STATUS, ex.getErrorResponse().getMessage());
				// Sending Error Response
				responseEntity = new ResponseEntity<>(ex.getErrorResponse(),
						HttpStatus.resolve(Integer.parseInt(ex.getErrorResponse().getCode())));

			} catch (DataAccessResourceFailureException ex) {
				LOGGER.error(Messages.DATA_ACCESS_RESOURCE_EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response when Database Access Failure Occurs
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);

			} catch (Exception ex) {
				LOGGER.error(Messages.EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response with Status Code Internal Server Error
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return responseEntity;
	}

	/**
	 * @param houseNumber
	 * @param accountNumber
	 * @return responseEntity
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "trackingStatus/{account_number}", params = "houseNumber", produces = Constants.CONTENT_TYPE_APPLICATION_JSON)
	public ResponseEntity<Object> getTrackingStatusDetailsByAccount(@RequestParam("houseNumber") String houseNumber,
			@PathVariable("account_number") String accountNumber) throws JsonProcessingException {

		ResponseEntity<Object> responseEntity = null;
		if ((accountNumber == null || accountNumber.equals("")) && (houseNumber == null || houseNumber.equals(""))) {
			// Sending Response as Invalid Input in case orderNumber is not
			// sent in request
			LOGGER.error(Messages.TRACKING_STATUS_REQUEST_PARAMS_EMPTY);
			responseEntity = new ResponseEntity<>(
					new ErrorResponse(ResponseCode.BAD_REQUEST, Messages.INVALID_INPUT, Messages.INVALID_INPUT),
					HttpStatus.BAD_REQUEST);

		} else {

			try {
				// Invoke Service method to retrieve Tracking Status based on orderNumber

				LOGGER.debug(Messages.RECEIVED_REQ_GET_TRACKING_STATUS);

				List<Object> trackingStatusResponse = trackingStatusService
						.getTrackingStatusByAccountNumber(accountNumber, houseNumber);
				LOGGER.info(Messages.TRACKING_STATUS_RETRIEVED);

				String trackingStatusResponseJson = objectMapper.writeValueAsString(trackingStatusResponse);
				LOGGER.debug(Messages.PREPARED_RESPONSE_GET_TRACKING_STATUS, trackingStatusResponseJson);

				responseEntity = new ResponseEntity<>(trackingStatusResponse, HttpStatus.OK);

			} catch (APIException ex) {
				// Exception Occurred if No Data found, or Error occurred while preparing
				// response Data
				LOGGER.error(Messages.API_EXCEPTION_GET_TRACKING_STATUS, ex.getErrorResponse().getMessage());
				// Sending Error Response
				responseEntity = new ResponseEntity<>(ex.getErrorResponse(),
						HttpStatus.resolve(Integer.parseInt(ex.getErrorResponse().getCode())));

			} catch (DataAccessResourceFailureException ex) {
				LOGGER.error(Messages.DATA_ACCESS_RESOURCE_EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response when Database Access Failure Occurs
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);

			} catch (Exception ex) {
				LOGGER.error(Messages.EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response with Status Code Internal Server Error
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return responseEntity;
	}

	@GetMapping(value = "trackingStatus/{tracking_status}", params = "trackingNumber", produces = Constants.CONTENT_TYPE_APPLICATION_JSON)
	public ResponseEntity<Object> getTrackingStatusDetailsByTrackingNumber(
			@RequestParam("trackingNumber") String trackingNumber,
			@PathVariable("tracking_status") String trackingStatus) throws JsonProcessingException {
		ResponseEntity<Object> responseEntity = null;
		if ((trackingStatus == null || trackingStatus.equals(""))
				&& (trackingNumber == null || trackingNumber.equals(""))) {
			// Sending Response as Invalid Input in case orderNumber is not
			// sent in request
			LOGGER.error(Messages.TRACKING_STATUS_REQUEST_PARAMS_EMPTY);
			responseEntity = new ResponseEntity<>(
					new ErrorResponse(ResponseCode.BAD_REQUEST, Messages.INVALID_INPUT, Messages.INVALID_INPUT),
					HttpStatus.BAD_REQUEST);

		} else {

			try {
				// Invoke Service method to retrieve Tracking Status based on orderNumber

				LOGGER.debug(Messages.RECEIVED_REQ_GET_TRACKING_STATUS);

				Shipment trackingStatusResponse = trackingStatusService
						.getTrackingStatusByTrackingNumber(trackingStatus, trackingNumber);
				LOGGER.info(Messages.TRACKING_STATUS_RETRIEVED);

				String trackingStatusResponseJson = objectMapper.writeValueAsString(trackingStatusResponse);
				LOGGER.debug(Messages.PREPARED_RESPONSE_GET_TRACKING_STATUS, trackingStatusResponseJson);

				responseEntity = new ResponseEntity<>(trackingStatusResponse, HttpStatus.OK);

			} catch (APIException ex) {
				// Exception Occurred if No Data found, or Error occurred while preparing
				// response Data
				LOGGER.error(Messages.API_EXCEPTION_GET_TRACKING_STATUS, ex.getErrorResponse().getMessage());
				// Sending Error Response
				responseEntity = new ResponseEntity<>(ex.getErrorResponse(),
						HttpStatus.resolve(Integer.parseInt(ex.getErrorResponse().getCode())));

			} catch (DataAccessResourceFailureException ex) {
				LOGGER.error(Messages.DATA_ACCESS_RESOURCE_EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response when Database Access Failure Occurs
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);

			} catch (Exception ex) {
				LOGGER.error(Messages.EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response with Status Code Internal Server Error
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return responseEntity;
	}

	@PostMapping(value = "tracking-callback/{shipment_id}")
	public ResponseEntity<Object> postShipmentStatusUpdate(@PathVariable("shipment_id") String shipmentId,
			@RequestBody ShipmentCallbackResponse callbackResponse) throws JsonProcessingException {
		ResponseEntity<Object> responseEntity = null;
		if ((shipmentId == null || shipmentId.equals(""))) {
			
			LOGGER.error(Messages.TRACKING_SHIPMENT_ID_PARAMS_EMPTY);
			responseEntity = new ResponseEntity<>(
					new ErrorResponse(ResponseCode.BAD_REQUEST, Messages.INVALID_INPUT, Messages.INVALID_INPUT),
					HttpStatus.BAD_REQUEST);

		}else {

			try {
				// Invoke Service method to retrieve Tracking Status based on orderNumber

				LOGGER.debug(Messages.RECEIVED_REQ_TO_POST_SHIPMENT_DETAILS);

				Shipment shipment = trackingStatusService
						.postShipmentId(shipmentId,callbackResponse);
				LOGGER.info(Messages.TRACKING_STATUS_RETRIEVED);

				String shipmentResponseJson = objectMapper.writeValueAsString(shipment);
				LOGGER.debug(Messages.PREPARED_RESPONSE_GET_TRACKING_STATUS, shipmentResponseJson);

				responseEntity = new ResponseEntity<>(shipment, HttpStatus.OK);

			} catch (APIException ex) {
				// Exception Occurred if No Data found, or Error occurred while preparing
				// response Data
				LOGGER.error(Messages.API_EXCEPTION_GET_TRACKING_STATUS, ex.getErrorResponse().getMessage());
				// Sending Error Response
				responseEntity = new ResponseEntity<>(ex.getErrorResponse(),
						HttpStatus.resolve(Integer.parseInt(ex.getErrorResponse().getCode())));

			} catch (DataAccessResourceFailureException ex) {
				LOGGER.error(Messages.DATA_ACCESS_RESOURCE_EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response when Database Access Failure Occurs
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);

			} catch (Exception ex) {
				LOGGER.error(Messages.EXCEPTION_GET_TRACKING_STATUS, ex.getMessage());
				// Sending Error Response with Status Code Internal Server Error
				responseEntity = new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR,
						ex.getMessage(), Messages.INTERNALSERVERERROR), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		return null;
	}

}
