package nz.co.skytv.trackingStatus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nz.co.skytv.trackingStatus.models.entities.Shipment;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;
import nz.co.skytv.trackingStatus.models.responses.ShipmentCallbackResponse;
import nz.co.skytv.trackingStatus.models.responses.TrackingStatusResponse;

/**
 * TrackingStatusService Interface.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */

public interface TrackingStatusService {

	/**
	 * Function to retrieve a particular order tracking status by its order number
	 * 
	 * @param orderNumber
	 * @return Tracking Status
	 */
	Object getTrackingStatusByOrderNumber(String orderNumber);

	/**
	 * @param accountNumber
	 * @param houseNumber
	 * @return List<TrackingStatus>
	 */
	List<Object> getTrackingStatusByAccountNumber(String accountNumber, String houseNumber);

	/**
	 * @param trackingNumber
	 * @param trackingStatus 
	 * @return TrackingStatus
	 */
	Shipment getTrackingStatusByTrackingNumber(String trackingNumber, String trackingStatus);

	Shipment postShipmentId(String shipmentId,ShipmentCallbackResponse callbackResponse);
	
	

}
