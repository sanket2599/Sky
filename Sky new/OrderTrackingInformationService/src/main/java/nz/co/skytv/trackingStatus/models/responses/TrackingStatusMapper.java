package nz.co.skytv.trackingStatus.models.responses;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import nz.co.skytv.trackingStatus.models.entities.Shipment;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;

@NoArgsConstructor
@Data
public class TrackingStatusMapper {

	public TrackingStatusResponse getTrackingStatusResponse(TrackingStatus trackingStatus, Shipment shipment) {

		TrackingStatusResponse response = new TrackingStatusResponse();
		response.setOrderNumber(trackingStatus.getOrderNumber());
		response.setAccountNumber(trackingStatus.getAccountNumber());
		response.setOrderDate(trackingStatus.getOrderDate());
		response.setOrderStatus(trackingStatus.getOrderStatus());
		response.setExpectedDeliveryDate(trackingStatus.getExpectedDeliveryDate());
		response.setRequestedDeliveryDate(trackingStatus.getRequestedDeliveryDate());
		response.setEmailAddress(trackingStatus.getEmailAddress());
		response.setPrimaryContactNo(trackingStatus.getPrimaryContactNo());
		response.setHouseNumber(trackingStatus.getHouseNumber());

		response.setTrackingNumber(shipment.getTrackingNumber());
		response.setTrackingStatus(shipment.getTrackingStatus());
		response.setTrackingStatusCheckedOn(shipment.getTrackingStatusCheckedOn());
		response.setShipmentFromLocation(shipment.getShipmentFromLocation());
		response.setShipmentToLocation(shipment.getShipmentToLocation());
		response.setUpdatedOn(shipment.getUpdatedOn());
		return response;
	}

}
