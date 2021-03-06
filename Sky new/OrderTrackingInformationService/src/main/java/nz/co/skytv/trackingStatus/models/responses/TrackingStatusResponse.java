package nz.co.skytv.trackingStatus.models.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nz.co.skytv.trackingStatus.models.entities.TrackingStatus;

/**
 * Tracking Status Response Class.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingStatusResponse {

	@JsonAlias("order_number")
	@JsonProperty("order_number")
	@Field("order_number")
	private String orderNumber;

	@JsonAlias("account_number")
	@JsonProperty("account_number")
	@Field("account_number")
	private String accountNumber;

	@JsonAlias("order_date")
	@JsonProperty("order_date")
	@Field("order_date")
	private String orderDate;

	@JsonAlias("order_status")
	@JsonProperty("order_status")
	@Field("order_status")
	private String orderStatus;

	@JsonAlias("expected_delivery_date")
	@JsonProperty("expected_delivery_date")
	@Field("expected_delivery_date")
	private String expectedDeliveryDate;

	@JsonAlias("requested_delivery_date")
	@JsonProperty("requested_delivery_date")
	@Field("requested_delivery_date")
	private String requestedDeliveryDate;

	@JsonAlias("email_address")
	@JsonProperty("email_address")
	@Field("email_address")
	private String emailAddress;

	@JsonAlias("primary_contact_no")
	@JsonProperty("primary_contact_no")
	@Field("primary_contact_no")
	private String primaryContactNo;

	@JsonAlias("house_number")
	@JsonProperty("house_number")
	@Field("house_number")
	private String houseNumber;
	
	@JsonAlias("tracking_number")
	@JsonProperty("tracking_number")
	@Field("tracking_number")
	private String trackingNumber;

	@JsonAlias("tracking_status")
	@JsonProperty("tracking_status")
	@Field("tracking_status")
	private String trackingStatus;

	@JsonAlias("tracking_status_checked_on")
	@JsonProperty("tracking_status_checked_on")
	@Field("tracking_status_checked_on")
	private String trackingStatusCheckedOn;

	@JsonAlias("shipment_from_location")
	@JsonProperty("shipment_from_location")
	@Field("shipment_from_location")
	private String shipmentFromLocation;

	@JsonAlias("shipment_to_location")
	@JsonProperty("shipment_to_location")
	@Field("shipment_to_location")
	private String shipmentToLocation;

	@JsonAlias("updated_on")
	@JsonProperty("updated_on")
	@Field("updated_on")
	private String updatedOn;

}
