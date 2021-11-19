package nz.co.skytv.trackingStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import nz.co.skytv.trackingStatus.common.Messages;

/**
 * Application Main File.
 * 
 * @author Sanket Kumar and Soumya Mitra
 */
@SpringBootApplication
@ComponentScan("nz.co.skytv")
@EnableMongoRepositories("nz.co.skytv.trackingStatus.repository")
public class TrackingStatusServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingStatusServiceApplication.class);

	/**
	 * Main Function of Application.
	 * 
	 * @param args Command Line Arguments
	 * @return
	 */
	public static void main(String[] args) {
		SpringApplication.run(TrackingStatusServiceApplication.class, args);
		LOGGER.info(Messages.APP_STARTED_SUCCESS);
	}

}
