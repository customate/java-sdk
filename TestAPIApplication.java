package com.customate.client;

import com.customate.client.builders.*;
import com.customate.client.enums.*;
import com.customate.client.models.*;
import com.customate.client.services.*;
import com.customate.client.utils.JsonHelper;

import com.fasterxml.jackson.databind.JsonNode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Tests some the endpoints to check that the APIs are running OK.
 *
  * Date: 08-Mar-21
 * Time: 1:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@SpringBootApplication
public class TestSDKApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSDKApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestSDKApplication.class, args);

		try {
			LOGGER.info("\n");

			// Get the API status
			Status status = getStatus();
			LOGGER.info("API Status\n" + status.asJson() + "\n\n");

			// Get profile 1
			Profile profile1 = getProfile(UUID.fromString("d871c453-18fe-497e-a84a-01b0f14d7a7c"));
			LOGGER.info("Profile 1\n" + profile1.asJson() + "\n\n");

			// Get profile 2
			Profile profile2 = getProfile(UUID.fromString("86fe6f3b-42ae-4516-b959-ba89ff6f67a8"));
			LOGGER.info("Profile 2\n" + profile2.asJson() + "\n\n");

			// Get the wallets for profile 1
			WalletPage wallets1 = getWallets(profile1.getId());
			LOGGER.info("Wallets for profile 1, ID: " + profile1.getId() + "\n" + wallets1.asJson() + "\n\n");

			// Get the wallets for profile 2
			WalletPage wallets2 = getWallets(profile2.getId());
			LOGGER.info("Wallets for profile 2, ID: " + profile2.getId() + "\n" + wallets2.asJson() + "\n\n");

			// Create a wallet to wallet payment from profile 1 to profile 2
			Payment fundingSourceToPayeePayment = createFundingSourceToPayeePayment(profile1.getId(),
					UUID.fromString("4e9bcad1-485a-4fef-8470-f32abe9ea834"), UUID.fromString("727929a4-0cb4-47de-a3cd-dc0eeaebefa5"));
			LOGGER.info("Wallet to wallet payment from profile 1 to profile 2:" + "\n" + fundingSourceToPayeePayment.asJson() + "\n\n");

			// Get the wallet to wallet payment
			Payment payment = getPayment(profile1.getId(), fundingSourceToPayeePayment.getId());
			LOGGER.info("Wallet to wallet payment from profile 1 to profile 2:\n" + payment.asJson() + "\n\n");

			// Get the wallets for profile 1 after the payment
			WalletPage afterPaymentWallets1 = getWallets(profile1.getId());
			LOGGER.info("After the payment, wallets for profile 1, ID: " + profile1.getId() + "\n" + afterPaymentWallets1.asJson() + "\n\n");

			// Get the wallets for profile 2 after the payment
			WalletPage afterPaymentWallets2 = getWallets(profile2.getId());
			LOGGER.info("After the payment, wallets for profile 2, ID: " + profile2.getId() + "\n" + afterPaymentWallets2.asJson() + "\n\n");

			// Create a wallet to wallet payment from profile 2 to profile 1 (to restore the balances)
			Payment fundingSourceToPayeePayment2 = createFundingSourceToPayeePayment(profile2.getId(),
					UUID.fromString("a028596e-cdcd-4e21-93b6-77c4609085c3"),  UUID.fromString("e07648f2-0900-4d7c-9f41-973b9daf3430"));
			LOGGER.info("Wallet to wallet payment from profile 2 to profile 1:" + "\n" + fundingSourceToPayeePayment2.asJson() + "\n\n");

		} catch (RuntimeException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
	}

	// Get the API status
	private static Status getStatus() {
		try {
			return StatusService.get();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Get a profile
	private static Profile getProfile(UUID id) {
		try {
			return ProfileService.get(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Get all wallets for a profile
	private static WalletPage getWallets(UUID profileId) {
		try {
			return WalletService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Create a wallet to wallet payment from the profile to the payee using the generic payments endpoint
	private static Payment createFundingSourceToPayeePayment(UUID profileId, UUID fundingSourceId, UUID payeeId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd").format(date);

			PaymentFundingSourceToPayeeCreate paymentFundingSourceToPayeeCreate = new PaymentFundingSourceToPayeeBuilder()
					.setAmount(1000).setDescription("Payment from FS wallet to payee wallet").setExecutionDate(now)
					.setCurrency(Currency.GBP).setMetadata(metadata).setFundingSourceId(fundingSourceId).setPayeeId(payeeId).build();

			return PaymentService.create(profileId, paymentFundingSourceToPayeeCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Get all payments for a profile
	private static PaymentPage getPayments(UUID profileId) {
		try {
			return PaymentService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Get a payment belonging to a profile
	private static Payment getPayment(UUID profileId, UUID paymentId) {
		try {
			return PaymentService.get(profileId, paymentId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	// Get all transactions for a profile
	private static TransactionPage getTransactions(UUID profileId) {
		try {
			return TransactionService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

}
