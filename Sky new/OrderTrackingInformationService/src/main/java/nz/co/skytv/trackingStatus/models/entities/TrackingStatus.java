package nz.co.skytv.trackingStatus.models.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Tracking Status Class
 * 
 * @author Sanket Kumar and Soumya Mitra
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order_master")
public class TrackingStatus {

	@Id
	private String id;

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
}
