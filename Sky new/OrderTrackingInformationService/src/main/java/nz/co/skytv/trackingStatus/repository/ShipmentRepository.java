package nz.co.skytv.trackingStatus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import nz.co.skytv.trackingStatus.models.entities.Shipment;

/**
 * Shipment Repository Interface.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */
@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {
	
	/**
	 * @param trackingNumber
	 * @param trackingStatus
	 * @return Shipment
	 */
	@Query("{ tracking_status : ?0,tracking_number : ?1 }")
	Shipment getTrackingStatusByTrackingNo(String trackingStatus, String trackingNumber);
	
	/**
	 * @param orderNumber
	 * @return Shipment
	 */
	@Query("{ order_number : ?0 }")
	Shipment getTrackingStatusByOrderNo(String orderNumber);

	/**
	 * @param shipmentId
	 * @return Shipment
	 */
	@Query("{ shipment_id : ?0 }")
	Shipment getShipmentId(String shipmentId);
}
