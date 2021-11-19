package nz.co.skytv.trackingStatus.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nz.co.skytv.trackingStatus.common.Messages;
import nz.co.skytv.trackingStatus.models.entities.Shipment;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;
import nz.co.skytv.trackingStatus.models.responses.ShipmentCallbackResponse;
import nz.co.skytv.trackingStatus.models.responses.TrackingStatusMapper;
import nz.co.skytv.trackingStatus.models.responses.TrackingStatusResponse;
import nz.co.skytv.trackingStatus.repository.ShipmentRepository;
import nz.co.skytv.trackingStatus.repository.TrackingStatusRepository;

/**
 * Tracking Status Service Class.
 * 
 * @author Sanket Kumar and Soumya Mitra
 *
 */
@Service
public class TrackingStatusServiceImpl implements TrackingStatusService {

	@Autowired
	private TrackingStatusRepository trackingStatusRepo;

	@Autowired
	private ShipmentRepository shipmentRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingStatusServiceImpl.class);

	/**
	 * Function to Get Tracking Status By Order Number.
	 *
	 * @param orderNumber
	 * 
	 * @return TrackingStatus
	 */
	@Override
	public Object getTrackingStatusByOrderNumber(String orderNumber) {

		TrackingStatus trackingStatus = this.trackingStatusRepo.getTrackingStatusByOrderNo(orderNumber);
		Object object = null;
		if (((TrackingStatus) trackingStatus).getOrderStatus().equals("shipped")) {
			TrackingStatusMapper mapper = new TrackingStatusMapper();
			Shipment shipment = this.shipmentRepo.getTrackingStatusByOrderNo(orderNumber);
			object = new TrackingStatusMapper();
			object = mapper.getTrackingStatusResponse(trackingStatus, shipment);

		} else {
			object = trackingStatus;
		}
		LOGGER.debug(Messages.MONGODB_RESULT_FOR_GET_TRACKING_STATUS_BY_ID, trackingStatus);
		return object;
	}

	/**
	 * Function to Get Tracking Status By Account Number and House Number.
	 *
	 * @param accountNumber
	 * @param houseNumber
	 * 
	 * @return List<TrackingStatus>
	 */

	@Override
	public List<Object> getTrackingStatusByAccountNumber(String accountNumber, String houseNumber) {

		List<TrackingStatus> trackingStatus = this.trackingStatusRepo.getTrackingStatus(accountNumber, houseNumber);
		List<Object> objects = new ArrayList<>();
		for(TrackingStatus tracker:trackingStatus) {
			Object object = null;
			if ((tracker).getOrderStatus().equals("shipped")) {
				TrackingStatusMapper mapper = new TrackingStatusMapper();
				Shipment shipment = this.shipmentRepo.getTrackingStatusByOrderNo(tracker.getOrderNumber());
				object =  new TrackingStatusMapper();
				object =  mapper.getTrackingStatusResponse(tracker, shipment);
				objects.add(object);

			} else {
				object = trackingStatus;
				objects.add(object);
			}
		}
		LOGGER.debug(Messages.MONGODB_RESULT_FOR_GET_TRACKING_STATUS_BY_ID, trackingStatus);
		return objects;
	}

	/**
	 * Function to Get Tracking Status By Tracking Number.
	 *
	 * @param trackingNumber
	 * 
	 * @return TrackingStatus
	 */
	@Override
	public Shipment getTrackingStatusByTrackingNumber(String trackingStatus, String trackingNumber) {

		Shipment shipment = this.shipmentRepo.getTrackingStatusByTrackingNo(trackingStatus, trackingNumber);

		LOGGER.debug(Messages.MONGODB_RESULT_FOR_GET_TRACKING_STATUS_BY_ID, shipment);

		return shipment;
	}

	@Override
	public Shipment postShipmentId(String shipmentId,ShipmentCallbackResponse callbackResponse) {
		Shipment shipment = this.shipmentRepo.getShipmentId(shipmentId);
		
		if(shipment!=null) {
			shipment.setTrackingStatus(callbackResponse.getTrackingStatus());
			shipment.setTrackingStatusCheckedOn(LocalDate.now().toString());
			shipment.setShipmentFromLocation(callbackResponse.getShipmentFromLocation());
			shipment.setShipmentToLocation(callbackResponse.getShipmentToLocation());
			shipment.setUpdatedOn(LocalDate.now().toString());
			shipment.setUpdatedBy(callbackResponse.getUpdatedBy());
			shipmentRepo.save(shipment);
		}else {
			return null;
		}

		LOGGER.debug(Messages.MONGODB_RESULT_FOR_UPDATE_SHIPMENT_STATUS_BY_ID, shipment);

		return shipment;
	}

}
