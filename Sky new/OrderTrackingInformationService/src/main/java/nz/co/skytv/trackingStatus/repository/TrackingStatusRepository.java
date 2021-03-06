package nz.co.skytv.trackingStatus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import nz.co.skytv.trackingStatus.models.entities.Shipment;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;

/**
 * Tracking Status Repository Interface.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */
@Repository
public interface TrackingStatusRepository extends MongoRepository<TrackingStatus, String> {

	/**
	 * Function to Find Tracking Status by AccountNumber and HouseNumber
	 * 
	 * @param accountNumber
	 * @param houseNumber
	 * @return List<TrackingStatus>
	 */
	@Query("{ account_number : ?0, house_number : ?1 }")
	List<TrackingStatus> getTrackingStatus(String accountNumber, String houseNumber);

	/**
	 * Function to Find Tracking Status by OrderNumber
	 * 
	 * @param orderNumber
	 * @return TrackingStatus
	 */
	@Query("{ order_number : ?0}")
	TrackingStatus getTrackingStatusByOrderNo(String orderNumber);

	
}