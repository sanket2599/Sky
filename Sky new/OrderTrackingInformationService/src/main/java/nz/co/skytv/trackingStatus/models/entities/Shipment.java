package nz.co.skytv.trackingStatus.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("shipment")
public class Shipment {
	@Id
	private String id;

	@JsonAlias("tracking_number")
	@JsonProperty("tracking_number")
	@Field("tracking_number")
	private String trackingNumber;
	
	@JsonAlias("shipment_id")
	@JsonProperty("shipment_id")
	@Field("shipment_id")
	private String shipmentId;
	
	@JsonAlias("order_number")
	@JsonProperty("order_number")
	@Field("order_number")
	private String orderNumber;

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

	@JsonAlias("updated_by")
	@JsonProperty("updated_by")
	@Field("updated_by")
	private String updatedBy;
}
