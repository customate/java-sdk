package com.customate.client;

import com.customate.client.builders.*;
import com.customate.client.enums.*;
import com.customate.client.enums.Currency;
import com.customate.client.models.*;
import com.customate.client.services.*;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

/**
 * Tests all the endpoints in the Customate Java SDK.
 *
 * Method createGbpOpenBankingPayment() loads funds into a user's wallet and requires user intervention:
 * Paste the URI into a browser, enter username: test_executed and any PIN and confirm the payment.
 * You have 2 minutes to do this (configurable below). The other payments rely on funds being available.
 *
 * Similarly, createOpenBankingMandatePayment() relies on the user to authorise the mandate.
 * Paste the URI into a browser, enter customer number 123456789012, PIN 572, password 436 and confirm the mandate.
 *
 * Date: 08-Mar-21
 * Time: 1:46 PM
 *
 * @author Sav Balac
 * @version 1.5
 */
@SpringBootApplication
public class TestSDKApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSDKApplication.class);

	// Tests all the endpoints
	public static void main(String[] args) {
		SpringApplication.run(TestSDKApplication.class, args);
		try {
			LOGGER.info("\n");

			// Get the API status
			Status status = getStatus();
			LOGGER.info("API Status\n" + status.asJson() + "\n");

			// Create a webhook
			Webhook webhook = createWebhook("https://webhook.site/9ea74946-4ef6-49b9-8ff6-2bbec59be700");
			LOGGER.info("Create webhook\n" + webhook.asJson() + "\n");

			// Rename the webhook
			webhook.setCallbackUrl("https://www.renamedsite.com/listener");
			Webhook webhook1 = updateWebhook(webhook);
			LOGGER.info("Update webhook\n" + webhook1.asJson() + "\n");

			// Get the webhook
			Webhook webhook2 = getWebhook(webhook1.getId());
			LOGGER.info("Get webhook, ID: " + webhook2.getId() + "\n" + webhook2.asJson() + "\n");

			// Get all webhooks
			WebhookPage webhooks = getWebhooks();
			LOGGER.info("All webhooks\n" + webhooks.asJson() + "\n");

			// Get a page of webhooks
			WebhookPage webhookPage = getWebhookPage(1, 1);
			LOGGER.info("Page 1 with 1 webhook per page\n" + webhookPage.asJson() + "\n");

			// Create a profile - emails and phone number must be unique in the database
			Profile profile = createProfile("johnlennon520606@music.com", "+447773200606");
			LOGGER.info("Create profile\n" + profile.asJson() + "\n");

			// Force-verify the profile
			VerificationResponse verificationResponse = forceVerifyProfile(profile);
			LOGGER.info("Force-verification of profile\n" + verificationResponse.asJson() + "\n");

			// Get the newly-created profile
			Profile verifiedProfile = getProfile(profile.getId());
			LOGGER.info("Get profile\n" + verifiedProfile.asJson() + "\n");

			// Create a second profile - emails and phone number must be unique in the database
			Profile profile2 = createProfile("paulmccartney473@music.com", "+447773200473");
			LOGGER.info("Create profile 2\n" + profile2.asJson() + "\n");

			// Verify the second profile (this will fail as we're not using real data)
			//VerificationResponse verificationResponse2 = verifyProfile(profile2);
			//LOGGER.info("Verify profile 2\n" + verificationResponse2.asJson() + "\n");

			// Force-verify the second profile
			VerificationResponse verificationResponse3 = forceVerifyProfile(profile2);
			LOGGER.info("Force-verification of profile 2\n" + verificationResponse3.asJson() + "\n");

			// Update the profile's address from Westminster Cathedral to Westminster Abbey
			Profile updatedProfile = updateProfile(profile);
			LOGGER.info("Update profile\n" + updatedProfile.asJson() + "\n");

			// Get all profiles
			ProfilePage profiles = getProfiles();
			LOGGER.info("All profiles\n" + profiles.asJson() + "\n");

			// Get a page of profiles
			ProfilePage profilePage = getProfilePage(1, 4);
			LOGGER.info("Page 1 with 4 profiles per page\n" + profilePage.asJson() + "\n");

			// Get the wallets for the profile
			WalletPage wallets = getWallets(profile.getId());
			LOGGER.info("Wallets for profile, ID: " + profile.getId() + "\n" + wallets.asJson() + "\n");

			// Get a page of wallets
			WalletPage walletPage = getWalletPage(profile.getId(), 1, 1);
			LOGGER.info("Page 1 with 1 wallet per page for profile, ID: " + profile.getId() + "\n" + walletPage.asJson() + "\n");

			// Get all wallets (balances) for this client, with pagination and totals, for the specified currency and date (start of day)
			// There is no limit to the page size, so you can get all wallets in one call
			Date now = new Date();
			AllWalletPage allWalletPage = getAllWalletPage(Currency.GBP, now, 1, 1000);
			LOGGER.info("Page 1 with 1000 wallets per page for this client" + "\n" + allWalletPage.asJson() + "\n");

			// Get the funding sources for the profile
			FundingSourcePage fundingSources = getFundingSources(profile.getId());
			LOGGER.info("Funding sources for profile, ID: " + profile.getId() + "\n" + fundingSources.asJson() + "\n");

			// Get a page of funding sources
			FundingSourcePage fundingSourcePage = getFundingSourcePage(profile.getId(), 1, 1);
			LOGGER.info("Page 1 with 1 funding source per page for profile, ID: " + profile.getId() + "\n" +
					fundingSourcePage.asJson() + "\n");

			// Create a GBP bank account payee for profile 2
			Payee bankAccountPayeeProfile2 = createBankAccountPayee(profile2.getId());
			LOGGER.info("Create bank account payee for profile 2, ID: " + profile2.getId() + "\n" +
					bankAccountPayeeProfile2.asJson() + "\n");

			// Get all payees for the profile
			PayeePage payees = getPayees(profile.getId());
			LOGGER.info("Payees for profile, ID: " + profile.getId() + "\n" + payees.asJson() + "\n");

			// Get a page of payees for the profile
			PayeePage payeePage = getPayeePage(profile.getId(), 1, 2);
			LOGGER.info("Page 1 with 2 payees per page for profile, ID: " + profile.getId() + "\n" + payeePage.asJson() + "\n");

			// Get the newly-created payee
			Payee payee1 = getPayee(profile.getId(), bankAccountPayeeProfile2.getId());
			LOGGER.info("Get payee:\n" + payee1.asJson() + "\n");

			// Update the payee (the payee ID is not returned)
			Payee payee2 = updatePayee(profile.getId(), payee1.getId());
			LOGGER.info("Payee, updated to: " + payee2.getTitle() + ", ID: " + payee1.getId() +
					" for profile, ID: " + profile.getId() + "\n" + payee2.asJson() + "\n");

			// Validate the payee (will fail as the data is not real)
			//Payee payee3 = validatePayee(profile.getId(), payee1.getId());
			//LOGGER.info("Payee, updated to: " + payee3.getTitle() + ", ID: " + payee1.getId() +
			//        " for profile, ID: " + profile.getId() + "\n" + payee3.asJson() + "\n");

			// Get open banking providers in the UK
			PaymentOpenBankingProviderPage paymentOpenBankingProviderPage = getOpenBankingProviders(Currency.GBP, "GB");
			LOGGER.info("Open banking providers (banks) in the UK: " + "\n" + paymentOpenBankingProviderPage.asJson() + "\n");

			// Create a GBP open banking payment to load funds into the profile
			PaymentOpenBanking paymentOpenBankingGbp = createGbpOpenBankingPayment(profile.getId());
			LOGGER.info("GBP open banking to wallet payment for profile, ID: " + profile.getId() + "\n" + paymentOpenBankingGbp.asJson() + "\n");
			LOGGER.info("Paste the URI into a browser, enter username: test_executed and any PIN and confirm the payment. YOU HAVE 2 MINUTES!\n");

			// Create a GBP open banking payment to load funds into profile 2
			PaymentOpenBanking paymentOpenBankingGbp2 = createGbpOpenBankingPayment(profile2.getId());
			LOGGER.info("GBP open banking to wallet payment for profile, ID: " + profile2.getId() + "\n" + paymentOpenBankingGbp2.asJson() + "\n");
			LOGGER.info("Paste the URI into a browser, enter username: test_executed and any PIN and confirm the payment. YOU HAVE 2 MINUTES!\n");

			// To complete the open banking payments, user intervention is required, i.e. paste the auth_uri into a browser.
			// The following payments expect profile 1 to have funds in their GBP wallet.
			// Only the live system transfers real funds.  YOU HAVE 2 MINUTES TO CONFIRM THE PAYMENTS!
			try {
				Thread.sleep(120000); // 120 seconds
			} catch (InterruptedException e) {
				LOGGER.error("InterruptedException: " + e.getMessage());
			}

			// Create an EUR open banking payment to load funds into the profile (will fail as the IBAN is not real)
			//PaymentOpenBanking paymentOpenBankingEur = createEurOpenBankingPayment(profile.getId());
			//if (paymentOpenBankingEur != null) {
			//    LOGGER.info("EUR open banking to wallet payment for profile, ID: " + profile.getId() + "\n" + paymentOpenBankingEur.asJson() + "\n");
			//} else {
			//    LOGGER.info("EUR Open banking to wallet payment failed (invalid IBAN) for profile, ID: " + profile.getId() + "\n");
			//}

			// Get open banking mandate providers in the UK
			OpenBankingMandateProviderPage openBankingMandateProviderPage = getOpenBankingMandateProviders();
			LOGGER.info("Open banking mandate providers (banks) in the UK: " + "\n" + openBankingMandateProviderPage.asJson() + "\n");

			// Create a mandate
			OpenBankingMandateResponse newMandate = createOpenBankingMandate(profile.getId());
			LOGGER.info("New mandate, for profile, ID: " + profile.getId() + "\n" + newMandate.asJson() + "\n");
			LOGGER.info("Paste the URI into a browser, enter customer number 123456789012, PIN 572, password 436 and confirm the mandate. YOU HAVE 2 MINUTES!\n");

			// To authorise the open banking mandate (and to then make payments using that mandate),
			// user intervention is required, i.e. paste the uri into a browser.
			// Only the live system transfers real funds.  YOU HAVE 2 MINUTES TO CONFIRM THE MANDATE!
			try {
				Thread.sleep(120000); // 120 seconds
			} catch (InterruptedException e) {
				LOGGER.error("InterruptedException: " + e.getMessage());
			}

			// Get all mandates for the profile
			OpenBankingMandatePage mandates = getOpenBankingMandates(profile.getId());
			LOGGER.info("Mandates for profile, ID: " + profile.getId() + "\n" + mandates.asJson() + "\n");

			// Get a page of mandates
			OpenBankingMandatePage mandatePage = getOpenBankingMandatePage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 mandates per page for profile, ID: " + profile.getId() + "\n" + mandatePage.asJson() + "\n");

			// Get the mandate
			OpenBankingMandate firstMandate = getOpenBankingMandate(profile.getId(), newMandate.getId());
			LOGGER.info("Open banking mandate for profile, ID: " + profile.getId() + "\n" + firstMandate.asJson() + "\n");

			// Create a mandate payment
			PaymentOpenBanking mandatePayment = createOpenBankingMandatePayment(profile.getId(), newMandate.getId());
			LOGGER.info("New mandate payment, for profile, ID: " + profile.getId() + "\n" + mandatePayment.asJson() + "\n");

			// Wait two minutes for the mandate payment to process
			try {
				Thread.sleep(120000); // 120 seconds
			} catch (InterruptedException e) {
				LOGGER.error("InterruptedException: " + e.getMessage());
			}

			// Delete the mandate
			int statusCode = deleteOpenBankingMandate(profile.getId(), newMandate.getId());
			LOGGER.info("Deleted open banking mandate, ID: " + newMandate.getId() + " from profile, ID: " +
					profile.getId() + ", status code: " + statusCode + "\n");

			// Create a GBP wallet to bank account payment for profile 1
			Payment walletToBankAccountPayment = createWalletToBankAccountPayment(profile2.getId(), bankAccountPayeeProfile2.getId());
			LOGGER.info("Wallet to bank account payment from profile, ID: " + profile.getId() + "\n" + walletToBankAccountPayment.asJson() + "\n");

			// Get the payee ID of profile 2 so that profile 1 can do a wallet to wallet payment
			UUID gbpPayeeIdProfile2 = null;
			PayeePage payeesProfile2 = getPayees(profile2.getId());
			for (Payee payee : payeesProfile2.getItems()) {
				if (payee.getCurrency().equals(Currency.GBP) && payee.getPayeeType().equals(PayeeType.wallet)) {
					gbpPayeeIdProfile2 = payee.getId();
				}
			}

			// Get the funding source ID of profile 1 so that profile 1 can do a wallet to wallet payment using the generic create() method
			UUID gbpFundingSourceId = null;
			FundingSourcePage fundingSourcesProfile1 = getFundingSources(profile.getId());
			for (FundingSource fs : fundingSourcesProfile1.getItems()) {
				if (fs.getCurrency().equals(Currency.GBP) &&
						fs.getFundingSourceType().equals(FundingSourceType.wallet)) {
					gbpFundingSourceId = fs.getId();
				}
			}

			// Create a wallet to wallet payment
			Payment walletToWalletPayment = createWalletToWalletPayment(profile.getId(), gbpPayeeIdProfile2);
			LOGGER.info("Wallet to wallet payment: " + "\n" + walletToWalletPayment.asJson() + "\n");

			// Get all payments for the profile
			PaymentPage payments = getPayments(profile.getId());
			LOGGER.info("Payments for profile, ID: " + profile.getId() + "\n" + payments.asJson() + "\n");

			// Get all payments for the profile, filtered and sorted
			Date date = new Date();
			String startOfToday = new SimpleDateFormat("yyyy-MM-dd").format(date);
			Map<String, String> filters = new HashMap<String, String>();
			filters.put("status.exact", "success");
			filters.put("scenario.in", "OpenBankingToWallet,OpenBankingMandateToWallet");
			filters.put("creation_date.after", startOfToday);
			String sortField = "creation_date";
			PaymentPage filteredPayments = getPayments(profile.getId(), filters, sortField, SortOrder.desc);
			LOGGER.info("Success OpenBankingToWallet and OpenBankingMandateToWallet payments completed after 2023-03-17 for profile, ID: " +
					profile.getId() + "\n" + filteredPayments.asJson() + "\n");

			// Get a page of payments for the profile
			PaymentPage paymentPage = getPaymentPage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 payments for profile, ID: " + profile.getId() + "\n" + paymentPage.asJson() + "\n");

			// Get a page of payments for the profile, filtered and sorted
			PaymentPage filteredPaymentPage = getPaymentPage(profile.getId(), filters, sortField, SortOrder.desc, 1, 3);
			LOGGER.info("Page 1 with 3 filtered payments for profile, ID: " + profile.getId() + "\n" + filteredPaymentPage.asJson() + "\n");

			// Get the wallet to bank account payment
			Payment payment = getPayment(profile.getId(), walletToBankAccountPayment.getId());
			LOGGER.info("Wallet to bank account payment:\n" + payment.asJson() + "\n");

			// Get the payee ID of profile 1 so that profile 1 can do a services payment
			UUID gbpPayeeIdProfile1 = null;
			PayeePage payeesProfile1 = getPayees(profile.getId());
			for (Payee payee : payeesProfile1.getItems()) {
				if (payee.getCurrency().equals(Currency.GBP) && payee.getPayeeType().equals(PayeeType.wallet)) {
					gbpPayeeIdProfile1 = payee.getId();
				}
			}

			UUID eurPayeeIdProfile1 = null;
			for (Payee payee : payeesProfile1.getItems()) {
				if (payee.getCurrency().equals(Currency.EUR) && payee.getPayeeType().equals(PayeeType.wallet)) {
					eurPayeeIdProfile1 = payee.getId();
				}
			}

			// Create a services payment which simulates an incoming bank payment (sandbox only).
			// Returns the ID of the saxo_transferinstruction in the sandbox database.
			SaxoTransferInstruction saxoTransferInstruction = createServicePayment(profile.getId(), gbpPayeeIdProfile1);
			LOGGER.info("Service payment\n" + saxoTransferInstruction.asJson() + "\n");

			// Create a payment using the generic payments endpoint
			// Will fail as the funding source isn't valid yet
			//Payment ddToWalletPayment = createFundingSourceToPayeePayment(profile.getId(), fundingSource.getId(), gbpPayeeIdProfile2);
			//LOGGER.info("DD to wallet payment paying profile 2, ID: " + profile2.getId() + "\n" + ddToWalletPayment.asJson() + "\n");

			// Get the list of non-processing dates (dates in the future that banks cannot process payments as they are closed).
			// There will be 2 dates (Saturday, Sunday), or more if there's a public holiday during the week.
			LocalDate today = LocalDate.now();
			LocalDate nextWeek = today.plusWeeks(1);
			LocalDate twoWeeksTime = today.plusWeeks(2);
			NonProcessingDates nonProcessingDates = getNonProcessingDates(today, nextWeek);
			LOGGER.info("Dates in the next 7 days when banks are closed and cannot process payments\n" + nonProcessingDates.asJson() + "\n");

			// Get all transactions for the profile
			TransactionPage transactions = getTransactions(profile.getId());
			LOGGER.info("Transactions for profile, ID: " + profile.getId() + "\n" + transactions.asJson() + "\n");

			// Get all transactions for the profile, filtered and sorted
			Map<String, String> transactionFilters = new HashMap<String, String>();
			transactionFilters.put("status.exact", "success");
			transactionFilters.put("name.in", "OpenBankingToWallet,OpenBankingMandateToWallet");
			transactionFilters.put("completion_date.after", startOfToday);
			TransactionPage filteredTransactions = getTransactions(profile.getId(), transactionFilters, "creation_date", SortOrder.desc);
			LOGGER.info("Success OpenBankingToWallet and OpenBankingMandateToWallet transactions completed after 2023-03-17 for profile, ID: " +
					profile.getId() + "\n" + filteredTransactions.asJson() + "\n");

			// Get a page of transactions
			TransactionPage transactionPage = getTransactionPage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 transactions for profile, ID: " + profile.getId() + "\n" + transactionPage.asJson() + "\n");

			// Get a page of transactions, filtered and sorted
			TransactionPage filteredTransactionPage = getTransactionPage(profile.getId(), transactionFilters, "creation_date", SortOrder.desc, 1, 3);
			LOGGER.info("Page 1 with 3 filtered transactions for profile, ID: " + profile.getId() + "\n" + filteredTransactionPage.asJson() + "\n");

			// Get a transaction
			if (transactionPage.getItems().size() > 0) {
				Transaction transaction = transactionPage.getItems().get(0);
				LOGGER.info("Transaction for profile, ID: " + profile.getId() + "\n" + transaction.asJson() + "\n");
			}

			// Create a Peer-to-peer (P2P) currency exchange - this exchanges GBP from profile 1 with EUR from profile 2
			// Need to specify the profile 2's payee ID in EUR
			// Hard-coded EUR payee ID that has funds in localhost: 3d7b7bde-261d-49a3-a9cf-579beb20fd63
			//UUID eurCounterpartyPayeeId = UUID.fromString("3d7b7bde-261d-49a3-a9cf-579beb20fd63");
			//P2PCurrencyExchange p2pCurrencyExchange = createP2PCurrencyExchange(profile.getId(), eurCounterpartyPayeeId);
			//LOGGER.info("P2P currency exchange, 30p for 3 Euro cents\n" + p2pCurrencyExchange.asJson() + "\n");

			// Get the list of currency exchanges (will be empty)
			P2PCurrencyExchangePage p2pCurrencyExchanges = getP2PCurrencyExchanges(profile.getId());
			LOGGER.info("P2P currency exchanges for profile, ID: " + profile.getId() + "\n" + p2pCurrencyExchanges.asJson() + "\n");

			// Get a page of currency exchanges
			P2PCurrencyExchangePage p2pCurrencyExchangePage = getP2PCurrencyExchangePage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 P2P currency exchanges for profile, ID: " + profile.getId() + "\n" + p2pCurrencyExchangePage.asJson() + "\n");

			// Currency exchange - this exchanges funds in one currency for another for the profile - get a quoted exchange rate
			//CurrencyExchange currencyExchange = getCurrencyExchangeQuote(profile.getId());
			//LOGGER.info("Currency exchange, including quote, for profile ID: " + profile.getId() + "\n" + currencyExchange.asJson() + "\n");

			// Currency exchange - execute the trade
			//CurrencyExchangeExecuteQuoteResponse exchangeRateResponse = executeCurrencyExchange(profile.getId(), currencyExchange.getId());
			//LOGGER.info("Executed currency exchange for profile, ID: " + profile.getId() + "\n" + exchangeRateResponse.asJson() + "\n");

			// Create a schedule, paying profile 2
			Schedule schedule = createSchedule(profile.getId(), gbpFundingSourceId, gbpPayeeIdProfile2);
			LOGGER.info("7 day schedule, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + schedule.asJson() + "\n");

			// Update the schedule, extending it by another week
			Schedule schedule1 = updateSchedule(profile.getId(), schedule);
			LOGGER.info("14 day schedule, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + schedule1.asJson() + "\n");

			// Get the schedules for the profile
			SchedulePage schedules = getSchedules(profile.getId());
			LOGGER.info("Schedules for profile, ID: " + profile.getId() + "\n" + schedules.asJson() + "\n");

			// Get a page of schedules
			SchedulePage schedulePage = getSchedulePage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 schedule per page for profile, ID: " + profile.getId() + "\n" + schedulePage.asJson() + "\n");

			// Get a schedule
			Schedule schedule2 = getSchedule(profile.getId(), schedule.getId());
			LOGGER.info("Get schedule, ID: " + schedule.getId() + " for profile, ID: " + profile.getId() + "\n" + schedule2.asJson() + "\n");

			// Create another schedule, paying profile 2
			Schedule schedule3 = createSchedule(profile.getId(), gbpFundingSourceId, gbpPayeeIdProfile2);
			LOGGER.info("Another schedule, 7 days, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + schedule3.asJson() + "\n");

			// Pay overdue payments - will fail as there won't be any overdue payments (the schedule has just been created)
			//int statusCode = payOverduePayments(profile.getId(), schedule);
			//LOGGER.info("(Should fail) Overdue payments paid for schedule, ID: " + schedule.getId() + ", status code: " + statusCode + "\n");

			// Get the balance of GBP wallet for profile 1
			FundingSource fs = getFundingSource(profile.getId(), gbpFundingSourceId);
			LOGGER.info("GBP funding source for profile, ID: " + fs.asJson() + "\n");

			// Cancel the first schedule
			statusCode = cancelSchedule(profile.getId(), schedule.getId());
			LOGGER.info("Cancel schedule, ID: " + schedule.getId() + ", status code: " + statusCode + "\n");

			// Cancel the second schedule
			statusCode = cancelSchedule(profile.getId(), schedule3.getId());
			LOGGER.info("Cancel schedule, ID: " + schedule3.getId() + ", status code: " + statusCode + "\n");

			// Delete the webhook
			statusCode = deleteWebhook(webhookPage.getItems().get(0).getId());
			LOGGER.info("Delete webhook, ID: 17ef373f-aff6-4a6d-99e5-98190f1b699e, status code: " + statusCode + "\n");

			// Delete the wallet to wallet payment (should fail as it's processing or complete)
			statusCode = deletePayment(profile.getId(), walletToWalletPayment.getId());
			LOGGER.info("(Should fail) Delete the wallet to wallet payment, ID: " + walletToWalletPayment.getId() +
					", status code: " + statusCode + "\n");

			// Get all payments for the profile (after trying to delete the wallet to wallet payment)
			PaymentPage payments2 = getPayments(profile.getId());
			LOGGER.info("Payments for profile, ID: " + profile.getId() + "\n" + payments2.asJson() + "\n");

			// Delete the payee
			statusCode = deletePayee(profile.getId(), bankAccountPayeeProfile2.getId());
			LOGGER.info("Delete payee, ID: " + bankAccountPayeeProfile2.getId() + " from profile, ID: " +
					profile.getId() + ", status code: " + statusCode + "\n");

			// Delete the profiles
			statusCode = deleteProfile(profile.getId());
			LOGGER.info("Delete profile, ID: " + profile.getId() + ", status code: " + statusCode + "\n");

			statusCode = deleteProfile(profile2.getId());
			LOGGER.info("Delete profile, ID: " + profile2.getId() + ", status code: " + statusCode + "\n");

		} catch (RuntimeException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
	}

	/**
	 * These methods call the API services. Use these examples in your code.
	 */

	// Get the API status
	private static Status getStatus() {
		try {
			return StatusService.get();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
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


	// Verify a profile (check the country of birth, mother's maiden name, passport or driving licence - will fail as this is dummy data)
	private static VerificationResponse verifyProfile(Profile profile) {
		try {
			Passport passport = new PassportBuilder().setOriginCountry("GB")
					.setNumber("PD12345678IRL1234567M1234567<<<<<<<<<<<<<<<0").setExpiryDate("2031-09-23").build();
			DriverLicence driverLicence = new DriverLicenceBuilder().setNumber("EUEGE123456BM9NM")
					.setPostcode("B126DY").setIssueDate("2011-10-27").build();
			VerificationRequest verificationRequest = new VerificationRequestBuilder().setBirthCountry("IE")
					.setMotherMaidenName("Smithy").setPassport(passport).setDriverLicence(driverLicence).build();
			return ProfileService.verify(profile.getId(), verificationRequest);
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


	// Update a profile
	private static Profile updateProfile(Profile profile) {
		try {
			// Update a profile's address to Westminster Abbey
			Address address = new AddressBuilder().setLine1("Westminster Abbey").setLine2("Victoria Street")
					.setLine3("Westminster").setCity("London").setLocality("Greater London").setPostcode("SW1P 1LT")
					.setCountry("GB").build();
			profile.setAddress(address);
			profile.setType(ProfileType.personal);
			return ProfileService.update(profile);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get all profiles
	private static ProfilePage getProfiles() {
		try {
			// Get all profiles
			return ProfileService.getAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of profiles
	private static ProfilePage getProfilePage(int pageNum, int pageSize) {
		try {
			// Get the first page of profiles, with 4 per page
			return ProfileService.getPage(pageNum, pageSize);
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


	// Get all wallets for a profile
	private static WalletPage getWallets(UUID profileId) {
		try {
			return WalletService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of wallets for a profile
	private static WalletPage getWalletPage(UUID profileId, int pageNum, int pageSize) {
		try {
			return WalletService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Gets all wallets for the client - balances, pagination and totals, for the currency and date (start of day)
	// There is no limit to the page size, so you can get all wallets in one call
	private static AllWalletPage getAllWalletPage(Currency currency, Date date, int pageNum, int pageSize) {
		try {
			return WalletService.getAllWallets(currency, date, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get all schedules for a profile
	private static SchedulePage getSchedules(UUID profileId) {
		try {
			return ScheduleService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of schedules for a profile
	private static SchedulePage getSchedulePage(UUID profileId, int pageNum, int pageSize) {
		try {
			return ScheduleService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a schedule for a profile
	private static Schedule getSchedule(UUID profileId, UUID scheduleId) {
		try {
			return ScheduleService.get(profileId, scheduleId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a schedule for a profile
	private static Schedule createSchedule(UUID profileId, UUID fundingSourceId, UUID payeeId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			// Append the datetime to the schedule to make it unique
			Date date = new Date();
			String today = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
			String title = "Test Daily Schedule " + now;

			ScheduleCreate scheduleCreate = new ScheduleBuilder().setTitle(title).setCurrency(Currency.GBP)
					.setSchedulePurpose(SchedulePurpose.pay).setSchedulePeriod(SchedulePeriod.daily).setNumberOfPayments(7)
					.setRegularPaymentStartDate(today).setRegularPaymentAmount(500).setDepositPaymentDate(today)
					.setDepositPaymentAmount(100).setDescription("7 day schedule paying £5 a day with a deposit of £1")
					.setMetadata(metadata).setFundingSourceId(fundingSourceId).setPayeeId(payeeId).build();

			return ScheduleService.create(profileId, scheduleCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Updates a schedule
	private static Schedule updateSchedule(UUID profileId, Schedule schedule) {
		try {
			// Set the number of payments to 14 and change the title
			String newTitle = "Updated " + schedule.getTitle();
			ScheduleUpdate scheduleUpdate = new ScheduleUpdateBuilder().copySchedule(schedule).setNumberOfPayments(14)
					.setTitle(newTitle).setDescription("14 day schedule paying £5 a day with a deposit of £1").build();

			return ScheduleService.update(profileId, schedule.getId(), scheduleUpdate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Pay overdue payments for a schedule
	private static int payOverduePayments(UUID profileId, Schedule schedule) {
		try {
			return ScheduleService.payOverduePayments(profileId, schedule);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


	// Cancel a schedule (should return status code 204)
	private static int cancelSchedule(UUID profileId, UUID scheduleId) {
		try {
			return ScheduleService.cancel(profileId, scheduleId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


	// Get the funding sources for a profile
	private static FundingSourcePage getFundingSources(UUID profileId) {
		try {
			return FundingSourceService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of funding sources for a profile
	private static FundingSourcePage getFundingSourcePage(UUID profileId, int pageNum, int pageSize) {
		try {
			return FundingSourceService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a funding source
	private static FundingSource getFundingSource(UUID profileId, UUID fundingSourceId) {
		try {
			return FundingSourceService.get(profileId, fundingSourceId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete a funding source (should return status code 204)
	private static int deleteFundingSource(UUID profileId, UUID fundingSourceId) {
		try {
			return FundingSourceService.delete(profileId, fundingSourceId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


	// Get all payees for a profile
	private static PayeePage getPayees(UUID profileId) {
		try {
			return PayeeService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of payees for a profile
	private static PayeePage getPayeePage(UUID profileId, int pageNum, int pageSize) {
		try {
			return PayeeService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a payee for a profile
	private static Payee getPayee(UUID profileId, UUID payeeId) {
		try {
			return PayeeService.get(profileId, payeeId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a (GBP bank account) payee for a profile
	private static Payee createBankAccountPayee(UUID profileId) {
		try {
			// Create an address (for the recipient)
			Address address = new AddressBuilder().setLine1("3 Privet Drive").setLine2("Little Whinging")
					.setLine3("Big Whinging").setCity("Muggle City").setLocality("Surrey")
					.setPostcode("MC1 1AA").setCountry("GB").build();

			// Create a recipient (for the payee data)
			Recipient recipient = new RecipientBuilder().setFullName("Mr John Lucky")
					.setEmail("johnlucky@money.com").setAddress(address).build();

			// Create a payee account (for the payee data)
			Random rand = new Random();
			String randSortCode = "" + rand.nextInt(100000);
			String randAccountNumber = "" + rand.nextInt(10000000);

			PayeeAccount payeeAccount = new PayeeAccountBuilder()
					.setSortCode(randSortCode).setAccountNumber(randAccountNumber).build();

			// Create payee data (for the payee)
			PayeeCreateData payeeCreateData = new PayeeDataBuilder()
					.setRecipient(recipient).setPayeeAccount(payeeAccount).build();

			// Create a payee
			UUID uuid = UUID.randomUUID();
			String uniqueTitle = "NatWest " + uuid;
			PayeeCreate payeeCreate = new PayeeBuilder().setTitle(uniqueTitle).setPayeeType(PayeeType.bank_account)
					.setCurrency(Currency.GBP).setPayeeCreateData(payeeCreateData).build();

			return PayeeService.create(profileId, payeeCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Update a payee (the payee ID is not returned)
	private static Payee updatePayee(UUID profileId, UUID payeeId) {
		try {
			// Create a new title (must be unique)
			UUID uuid = UUID.randomUUID();
			String newTitle = "Payee " + uuid;

			// Create a payee address
			PayeeAddress payeeAddress = new PayeeAddressBuilder()
					.setAddressLine1("4 Privet Drive").setAddressLine2("Little Whinging")
					.setAddressLine3("Big Whinging").setCity("Muggle City").setLocality("Surrey")
					.setPostcode("MC1 1AA").setCountry("GB").build();

			// Create a recipient
			PayeeUpdateRecipient payeeUpdateRecipient =
					new PayeeRecipientUpdateBuilder()
							.setEmail("updated-" + uuid + "@email.com").setPayeeAddress(payeeAddress).build();

			// Create a payee (for update)
			PayeeUpdate payeeUpdate = new PayeeUpdateBuilder().setTitle(newTitle)
					.setPayeeUpdateRecipient(payeeUpdateRecipient).build();

			return PayeeService.update(profileId, payeeId, payeeUpdate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Validate a payee with a new title and new recipient's name, date of birth, email and address
	private static Payee validatePayee(UUID profileId, UUID payeeId) {
		try {
			// Create a new title (must be unique)
			UUID uuid = UUID.randomUUID();
			String newTitle = "Payee " + uuid;

			// Create a payee address
			PayeeAddress payeeAddress = new PayeeAddressBuilder()
					.setAddressLine1("5 Privet Drive").setAddressLine2("Little Whinging")
					.setAddressLine3("Big Whinging").setCity("Muggle City").setLocality("Surrey")
					.setPostcode("MC1 1AA").setCountry("GB").build();

			// Create a recipient
			PayeeValidateRecipient payeeValidateRecipient =
					new PayeeRecipientValidateBuilder().setFirstName("Mickey").setLastName("Mouse").setBirthDate("1920-01-01")
							.setEmail("updated-" + uuid + "@email.com").setPayeeAddress(payeeAddress).build();

			// Create a payee (for validation)
			PayeeValidate payeeValidate = new PayeeValidateBuilder().setTitle(newTitle)
					.setPayeeValidateRecipient(payeeValidateRecipient).build();

			return PayeeService.validate(profileId, payeeId, payeeValidate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete a payee (should return status code 204)
	private static int deletePayee(UUID profileId, UUID payeeId) {
		try {
			return PayeeService.delete(profileId, payeeId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


	// Get open banking providers
	private static PaymentOpenBankingProviderPage getOpenBankingProviders(Currency currency, String country) {
		try {
			return PaymentService.getOpenBankingProviders(currency, country);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create an open banking payment to a profile.
	private static PaymentOpenBanking createGbpOpenBankingPayment(UUID profileId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			PaymentOpenBankingGbpCreate paymentOpenBankingGbpCreate = new PaymentOpenBankingGbpBuilder()
					.setAmount(10000).setDescription("Deposit for Flat 1").setCountry("GB").setCurrency(Currency.GBP)
					.setWebhookUri("https://webhook.site/8b3911e1-7d5d-42a0-9d8c-27e198e96070")
					.setRedirectUri("https://www.bbc.co.uk").setMetadata(metadata).setProviderId("mock-payments-gb-redirect")
					.setPayerName("Paul McCartney").setBeneficiaryName("Paul McCartney").build();

			return PaymentService.createOpenBankingGbp(profileId, paymentOpenBankingGbpCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a Euro open banking payment to a profile (will fail as it's not using a real IBAN).
	private static PaymentOpenBanking createEurOpenBankingPayment(UUID profileId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			PaymentOpenBankingEurCreate paymentOpenBankingEurCreate = new PaymentOpenBankingEurBuilder()
					.setAmount(10000).setDescription("Deposit for Flat 1").setCountry("ES").setCurrency(Currency.EUR)
					.setWebhookUri("https://webhook.site/8b3911e1-7d5d-42a0-9d8c-27e198e96070")
					.setRedirectUri("https://www.bbc.co.uk").setMetadata(metadata).setProviderId("xs2a-redsys-banco-santander")
					.setPayerIban("GB13ABBY09012706978360").setPayerName("Paul McCartney")
					.setBeneficiaryName("Paul McCartney").build();

			return PaymentService.createOpenBankingEur(profileId, paymentOpenBankingEurCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a wallet to bank account payment from the profile to the payee
	private static Payment createWalletToBankAccountPayment(UUID profileId, UUID payeeId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd").format(date);

			PaymentWalletToPayeeCreate paymentWalletToPayeeCreate = new PaymentWalletToPayeeBuilder()
					.setAmount(100).setDescription("Payment to bank account").setExecutionDate(now)
					.setCurrency(Currency.GBP).setMetadata(metadata).setPayeeId(payeeId).build();

			return PaymentService.createWalletToBankAccount(profileId, paymentWalletToPayeeCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a wallet to wallet payment from the profile to the payee
	private static Payment createWalletToWalletPayment(UUID profileId, UUID payeeId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd").format(date);

			PaymentWalletToPayeeCreate paymentWalletToPayeeCreate = new PaymentWalletToPayeeBuilder()
					.setAmount(100).setDescription("Payment to wallet").setExecutionDate(now)
					.setCurrency(Currency.GBP).setMetadata(metadata).setPayeeId(payeeId).build();

			return PaymentService.createWalletToWallet(profileId, paymentWalletToPayeeCreate);
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


	// Create an open banking mandate for a profile.
	private static OpenBankingMandateResponse createOpenBankingMandate(UUID profileId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			LocalDate today = LocalDate.now();
			LocalDate nextYear = today.plusYears(1);

			OpenBankingMandateCreate openBankingMandateCreate = new OpenBankingMandateBuilder()
					.setProviderId("ob-natwest-vrp-sandbox").setCountry("GB").setCurrency(Currency.GBP)
					.setPayerName("Paul McCartney").setPayerEmail("paulmccartney@music.com")
					.setBeneficiaryName("Paul McCartney").setMaximumIndividualAmount(100000).setMaximumPaymentAmount(1200000)
					.setMaximumPaymentPeriod(OpenBankingMandatePeriod.Yearly).setReference("Rent for Flat 1")
					.setRedirectUrl("https://www.bbc.co.uk").setValidFromDate(today.toString())
					.setValidToDate(nextYear.toString()).build();

			return OpenBankingMandateService.createOpenBankingMandate(profileId, openBankingMandateCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create an open banking mandate payment to a profile.
	private static PaymentOpenBanking createOpenBankingMandatePayment(UUID profileId, UUID mandateId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			PaymentOpenBankingMandateCreate paymentOpenBankingMandateCreate = new PaymentOpenBankingMandateBuilder()
					.setAmount(100).setDescription("Deposit for Flat 1").setCurrency(Currency.GBP)
					.setMetadata(metadata).setBeneficiaryName("Paul McCartney").setMandateId(mandateId).build();

			return PaymentService.createOpenBankingGbp(profileId, paymentOpenBankingMandateCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a P2P currency exchange with a counterparty payee
	private static P2PCurrencyExchange createP2PCurrencyExchange(UUID profileId, UUID counterpartyPayeeId) {
		try {
			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd").format(date);

			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			BigDecimal exchangeRate = new BigDecimal(0.1);

			P2PCurrencyExchangeCreate p2PCurrencyExchangeCreate = new P2PCurrencyExchangeBuilder()
					.setAmount(30).setCurrency(Currency.GBP).setExchangeRate(exchangeRate).setPayeeId(counterpartyPayeeId)
					.setExecutionDate(now).setDescription("P2P 30 GBP for 3 EUR").setMetadata(metadata).build();

			return P2PCurrencyExchangeService.createP2PCurrencyExchange(profileId, p2PCurrencyExchangeCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get all currency exchanges for a profile
	private static P2PCurrencyExchangePage getP2PCurrencyExchanges(UUID profileId) {
		try {
			return P2PCurrencyExchangeService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of currency exchanges for a profile
	private static P2PCurrencyExchangePage getP2PCurrencyExchangePage(UUID profileId, int pageNum, int pageSize) {
		try {
			return P2PCurrencyExchangeService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a currency exchange belonging to a profile
	private static P2PCurrencyExchange getP2PCurrencyExchange(UUID profileId, UUID currencyExchangeId) {
		try {
			return P2PCurrencyExchangeService.get(profileId, currencyExchangeId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a currency exchange quote
	private static CurrencyExchange getCurrencyExchangeQuote(UUID profileId) {
		try {
			// Create some metadata (optional)
			JsonNode metadata = JsonHelper.createEmptyObjectNode();
			JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

			CurrencyExchangeCreate currencyExchangeCreate = new CurrencyExchangeBuilder()
					.setAmount(100).setCurrencyToSell(Currency.GBP).setCurrencyToBuy(Currency.EUR)
					.setDescription("100 GBP for EUR").setMetadata(metadata).build();

			return CurrencyExchangeService.getQuote(profileId, currencyExchangeCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	private static CurrencyExchangeExecuteQuoteResponse executeCurrencyExchange(UUID profileId, UUID quoteId) {
		try {
			return CurrencyExchangeService.execute(profileId, quoteId);
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


	// Get all payments for a profile, using a map of filters and a sort field & sort order (asc or desc)
	private static PaymentPage getPayments(UUID profileId, Map<String, String> filters, String sortField, SortOrder sortOrder) {
		try {
			return PaymentService.getAll(profileId, filters, sortField, sortOrder);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of payments for a profile
	private static PaymentPage getPaymentPage(UUID profileId, int pageNum, int pageSize) {
		try {
			return PaymentService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of payments for a profile, using a map of filters and a sort field & sort order (asc or desc)
	private static PaymentPage getPaymentPage(UUID profileId, Map<String, String> filters,
											  String sortField, SortOrder sortOrder, int pageNum, int pageSize) {
		try {
			return PaymentService.getPage(profileId, filters, sortField, sortOrder, pageNum, pageSize);
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


	// Creates a services payment which simulates an incoming bank payment (sandbox only).
	// Returns the ID of the saxo_transferinstruction in the sandbox database.
	private static SaxoTransferInstruction createServicePayment(UUID profileId, UUID payeeId) {
		try {
			PaymentServiceCreate paymentServiceCreate = new PaymentServiceBuilder().setAmount(5000)
					.setDescription("Service Payment").setPaymentScenario(PaymentScenario.IncomingBankTransfer)
					.setPayeeId(payeeId).build();
			return PaymentService.createService(profileId, paymentServiceCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get the list of non-processing dates (dates that banks cannot process payments as they are closed)
	private static NonProcessingDates getNonProcessingDates(LocalDate intervalStartDate, LocalDate intervalEndDate) {
		try {
			return PaymentService.getNonProcessingDates(intervalStartDate, intervalEndDate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete a payment (should return status code 204)
	private static int deletePayment(UUID profileId, UUID paymentId) {
		try {
			return PaymentService.delete(profileId, paymentId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


	// Get open banking mandate providers (GB and GBP only)
	private static OpenBankingMandateProviderPage getOpenBankingMandateProviders() {
		try {
			return OpenBankingMandateService.getOpenBankingMandateProviders();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get all open banking mandates for a profile
	private static OpenBankingMandatePage getOpenBankingMandates(UUID profileId) {
		try {
			return OpenBankingMandateService.getAll(profileId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of open banking mandates for a profile
	private static OpenBankingMandatePage getOpenBankingMandatePage(UUID profileId, int pageNum, int pageSize) {
		try {
			return OpenBankingMandateService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get an open banking mandate belonging to a profile
	private static OpenBankingMandate getOpenBankingMandate(UUID profileId, UUID mandateId) {
		try {
			return OpenBankingMandateService.get(profileId, mandateId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete an open banking mandate (should return status code 204)
	private static int deleteOpenBankingMandate(UUID profileId, UUID mandateId) {
		try {
			return OpenBankingMandateService.delete(profileId, mandateId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
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


	// Get all transactions for a profile, using a map of filters and a sort field & sort order (asc or desc)
	private static TransactionPage getTransactions(UUID profileId, Map<String, String> filters, String sortField, SortOrder sortOrder) {
		try {
			return TransactionService.getAll(profileId, filters, sortField, sortOrder);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of transactions for a profile
	private static TransactionPage getTransactionPage(UUID profileId, int pageNum, int pageSize) {
		try {
			return TransactionService.getPage(profileId, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of transactions for a profile, using a map of filters and a sort field & sort order (asc or desc)
	private static TransactionPage getTransactionPage(UUID profileId, Map<String, String> filters,
													  String sortField, SortOrder sortOrder, int pageNum, int pageSize) {
		try {
			return TransactionService.getPage(profileId, filters, sortField, sortOrder, pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a transaction belonging to a profile
	private static Transaction getTransaction(UUID profileId, UUID transactionId) {
		try {
			return TransactionService.get(profileId, transactionId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Create a webhook
	private static Webhook createWebhook(String callbackUrl) {
		try {
			WebhookCreate webhookCreate = new WebhookBuilder().setCallbackUrl(callbackUrl).build();
			return WebhookService.create(webhookCreate);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get all webhooks
	private static WebhookPage getWebhooks() {
		try {
			return WebhookService.getAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a page of webhooks
	private static WebhookPage getWebhookPage(int pageNum, int pageSize) {
		try {
			return WebhookService.getPage(pageNum, pageSize);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Get a webhook
	private static Webhook getWebhook(UUID id) {
		try {
			return WebhookService.get(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Update a webhook
	private static Webhook updateWebhook(Webhook webhook) {
		try {
			return WebhookService.update(webhook);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


	// Delete a webhook (should return status code 204)
	private static int deleteWebhook(UUID id) {
		try {
			return WebhookService.delete(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 500;
		}
	}


}
