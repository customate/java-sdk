import com.customate.client.builders.*;
import com.customate.client.enums.*;
import com.customate.client.models.*;
import com.customate.client.services.*;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is for auto testing open banking using Microsoft Playwright.
 * The Jenkins job runs this, which writes the Natwest URI to the filesystem.
 * The test script reads the URI and performs a test.
 *
 * Date: 26-Apr-21
 * Time: 1:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class TestOpenBankingApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestOpenBankingApplication.class);

	public static void main(String[] args) {
		try {
			// Create a profile - emails and phone number must be unique in the database
			Profile profile = createProfile("paulmccartney500@music.com", "+447773100500");

			// Force-verify the profile
			VerificationResponse verificationResponse = forceVerifyProfile(profile);

			// Create a GBP open banking payment to load funds into the profile
			PaymentOpenBanking paymentOpenBanking = createGbpOpenBankingPayment(profile.getId());
			String uri = paymentOpenBanking.getPaymentOpenBankingData()
							.getPaymentOpenBankingDataAttributes()
							.getPaymentOpenBankingDataAttributesMetadata()
							.getUri();

			// Write the URI to the file system (delete the file if it exists first)
			Path path = Paths.get("uri.txt");
			Files.deleteIfExists(path);

			Path fileName = Path.of("uri.txt");
			Files.writeString(fileName, uri);

			// Delete the profile
			int statusCode = deleteProfile(profile.getId());

		} catch (RuntimeException e) {
			LOGGER.error("Exception: " + e.getMessage());
		} catch (IOException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
	}


	// Create a profile
	private static Profile createProfile(String email, String phoneNumber) {
		try {
			// Create an address (required fields: line1, city, locality, postcode)
			Address address = new AddressBuilder().setLine1("Westminster Cathedral").setLine2("Victoria Street")
					.setLine3("Westminster").setCity("London").setLocality("Greater London").setPostcode("SW1P 1LT")
					.setCountry("GB").build();

			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			// Create a profile (required fields: type, firstName, lastName, email, phoneNumber, address)
			Profile newProfile = new ProfileBuilder()
					.setType(ProfileType.personal).setTitle(Title.mr).setFirstName("James").setMiddleName("Paul")
					.setLastName("McCartney").setEmail(email).setPhoneNumber(phoneNumber)
					.setBirthDate("1942-06-18").setAddress(address).setGender(Gender.male).setMetadata(metadata).build();

			return ProfileService.create(newProfile);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Force-verify a profile (doesn't check the country of birth, mother's maiden name, passport or driving licence)
	private static VerificationResponse forceVerifyProfile(Profile profile) {
		try {
			return ProfileService.forceVerify(profile.getId());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create an open banking payment to a profile
	private static PaymentOpenBanking createGbpOpenBankingPayment(UUID profileId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			PaymentOpenBankingGbpCreate paymentOpenBankingGbpCreate = new PaymentOpenBankingGbpBuilder()
					.setAmount(10000).setDescription("Deposit for Flat 1").setCountry("GB").setCurrency(Currency.GBP)
					.setWebhookUri("https://webhook.site/8b3911e1-7d5d-42a0-9d8c-27e198e96070")
					.setRedirectUri("https://gocustomate.com/").setMetadata(metadata).setProviderId("ob-sandbox-natwest")
					.setPayerName("Paul McCartney").setBeneficiaryName("Tesco LTD").build();

			return PaymentService.createOpenBankingGbp(profileId, paymentOpenBankingGbpCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete a profile (should return status code 204)
	private static int deleteProfile(UUID id) {
		try {
			return ProfileService.delete(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


}
