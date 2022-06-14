package com.customate.client;

import com.customate.client.builders.*;
import com.customate.client.enums.*;
import com.customate.client.models.*;
import com.customate.client.services.*;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Tests all the endpoints in the Customate Java SDK.
 *
 * One method, createOpenBankingPayment(), loads funds into a user's wallet and requires user intervention:
 * Paste the URI into a browser, enter customer no. 123456789012, PIN 572, password 436 and confirm the payment.
 * You have 1 minute to do this (configurable below). The other payments rely on funds being available.
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

    // Tests all the endpoints
    public static void main(String[] args) {
        SpringApplication.run(TestSDKApplication.class, args);
        try {
            LOGGER.info("\n");

            // Get the API status
            Status status = getStatus();
            LOGGER.info("API Status\n" + status.asJson() + "\n");

            // Create a profile - emails and phone number must be unique in the database
            Profile profile = createProfile("johnlennon520537@music.com", "+447773200537");
            LOGGER.info("Create profile\n" + profile.asJson() + "\n");

            // Force-verify the profile
            VerificationResponse verificationResponse = forceVerifyProfile(profile);
            LOGGER.info("Force-verify of profile\n" + verificationResponse.asJson() + "\n");

			// Get the newly-created profile
			Profile verifiedProfile = getProfile(profile.getId());
			LOGGER.info("Get profile\n" + verifiedProfile.asJson() + "\n");

			// Create a second profile - emails and phone number must be unique in the database
			Profile profile2 = createProfile("paulmccartney405@music.com", "+447773200405");
			LOGGER.info("Create profile 2\n" + profile2.asJson() + "\n");

			// Verify the second profile (this will fail as we're not using real data)
			VerificationResponse verificationResponse2 = verifyProfile(profile2);
			LOGGER.info("Verify profile 2\n" + verificationResponse2.asJson() + "\n");

			// Force-verify the second profile
			VerificationResponse verificationResponse3 = forceVerifyProfile(profile2);
			LOGGER.info("Force-verify of profile 2\n" + verificationResponse3.asJson() + "\n");

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

			// Create a direct debit funding source for the profile
			FundingSource fundingSource = createDirectDebitFundingSource(profile.getId());
			LOGGER.info("Create direct debit funding source for profile, ID: " + profile.getId() + "\n" + fundingSource.asJson() + "\n");

			// Get the newly-created funding source
			FundingSource fundingSource1 = getFundingSource(profile.getId(), fundingSource.getId());
			LOGGER.info("Get funding source, ID: " + fundingSource1.getId() + " for profile, ID: " +
					profile.getId() + "\n" + fundingSource1.asJson() + "\n");

			// Update the funding source
			FundingSource fundingSource2 = updateFundingSource(profile.getId(), fundingSource1.getId());
			LOGGER.info("Funding source, updated to: " + fundingSource2.getTitle() + ", ID: " + fundingSource1.getId() +
					" for profile, ID: " + profile.getId() + "\n" + fundingSource2.asJson() + "\n");

			// Validate the funding source (will fail as the data is not real)
            //FundingSource fundingSource3 = validateFundingSource(profile.getId(), fundingSource1.getId());
            //LOGGER.info("Funding source, validated: " + fundingSource3.getTitle() + ", ID: " + fundingSource1.getId() +
            //        " for profile, ID: " + profile.getId() + "\n" + fundingSource3.asJson() + "\n");

			// Create another (direct debit) funding source for the profile, using the generic create funding source method
			FundingSource fundingSourceDD = createFundingSource(profile.getId());
			LOGGER.info("Create funding source (using the generic create method) for profile, ID: " + profile.getId() + "\n" + fundingSourceDD.asJson() + "\n");

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
			LOGGER.info("Paste the URI into a browser and confirm the payment in their sandbox. YOU HAVE 1 MINUTE!\n");

			// To complete the open banking payment, user intervention is required, i.e. paste the auth_uri into a browser.
			// The following payments expect profile 1 to have funds in their GBP wallet.
			// Only the live system transfers real funds.  YOU HAVE 1 MINUTE TO CONFIRM THE PAYMENT!
			try {
				Thread.sleep(60000); // 60 seconds
			} catch (InterruptedException e) {
				LOGGER.error("InterruptedException: " + e.getMessage());
			}

            // Create an EUR open banking payment to load funds into the profile (will fail as the IBAN is not real)
            PaymentOpenBanking paymentOpenBankingEur = createEurOpenBankingPayment(profile.getId());
			if (paymentOpenBankingEur != null) {
                LOGGER.info("EUR open banking to wallet payment for profile, ID: " + profile.getId() + "\n" + paymentOpenBankingEur.asJson() + "\n");
            } else {
                LOGGER.info("EUR Open banking to wallet payment failed (invalid IBAN) for profile, ID: " + profile.getId() + "\n");
            }

			// Create a GBP wallet to bank account payment for profile 2
			Payment walletToBankAccountPayment = createWalletToBankAccountPayment(profile2.getId(), bankAccountPayeeProfile2.getId());
			LOGGER.info("Wallet to bank account payment from profile, ID: " + profile2.getId() + "\n" + walletToBankAccountPayment.asJson() + "\n");

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

			// Create a single direct debit to wallet payment, paying profile 2.
			// The funding source must be of type direct debit and the payee must be of type wallet.
            // This will fail as the funding source hasn't isn't valid yet.
			//Payment directDebitToWalletPayment = createDirectDebitToWalletPayment(profile2.getId(), fundingSource.getId(), gbpPayeeIdProfile2);
			//LOGGER.info("Single direct debit to wallet payment paying profile 2, ID: " + profile2.getId() + "\n" + directDebitToWalletPayment.asJson() + "\n");

			// Get all payments for the profile
			PaymentPage payments = getPayments(profile.getId());
			LOGGER.info("Payments for profile, ID: " + profile.getId() + "\n" + payments.asJson() + "\n");

			// Get a page of payments for the profile
			PaymentPage paymentPage = getPaymentPage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 payments for profile, ID: " + profile.getId() + "\n" + paymentPage.asJson() + "\n");

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

			// Get the list of non-processing dates, specifying the unverified direct debit funding source ID and bank account payee ID.
			// It takes 7 days to verify the funding source and 7 days to process a DD payment, so there are 14 dates.
			NonProcessingDates nonProcessingDatesId = getNonProcessingDates(today, twoWeeksTime, fundingSource.getId(), bankAccountPayeeProfile2.getId());
			LOGGER.info("Dates that banks are closed and cannot process payments for DD funding source and bank account payee\n" +
					nonProcessingDatesId.asJson() + "\n");

			// Get the list of non-processing dates, specifying the direct debit funding source type and bank account payee type.
			// It takes 7 days to process a DD payment, so there are 7 dates.
			NonProcessingDates nonProcessingDatesType = getNonProcessingDates(today, nextWeek, FundingSourceType.direct_debit, PayeeType.bank_account);
			LOGGER.info("Dates that banks are closed and cannot process payments for DD funding source type and bank account payee type\n" +
					nonProcessingDatesType.asJson() + "\n");

			// Get all transactions for the profile
			TransactionPage transactions = getTransactions(profile.getId());
			LOGGER.info("Transactions for profile, ID: " + profile.getId() + "\n" + transactions.asJson() + "\n");

			// Get a page of transactions
			TransactionPage transactionPage = getTransactionPage(profile.getId(), 1, 3);
			LOGGER.info("Page 1 with 3 transaction for profile, ID: " + profile.getId() + "\n" + transactionPage.asJson() + "\n");

			// Get a transaction
            if (transactions.getItems().size() > 0) {
                Transaction transaction = transactions.getItems().get(0);
                LOGGER.info("Transaction for profile, ID: " + profile.getId() + "\n" + transaction.asJson() + "\n");
            }

			// Create a schedule, paying profile 2
			Schedule schedule = createSchedule(profile.getId(), gbpFundingSourceId, gbpPayeeIdProfile2);
			LOGGER.info("7 day schedule, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + schedule.asJson() + "\n");

			// Update the schedule, extending it by another week
			Schedule schedule1 = updateSchedule(profile.getId(), schedule);
			LOGGER.info("14 day schedule, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + schedule1.asJson() + "\n");

			// Create a direct debit to wallet schedule, paying profile 2
            // Will fail as the funding source is not valid yet
			//Schedule scheduleDD = createDirectDebitToWalletSchedule(profile.getId(), fundingSource.getId(), gbpPayeeIdProfile2);
			//LOGGER.info("7 day DD schedule, profile 1 paying profile 2, £5 a day with a deposit of £1\n" + scheduleDD.asJson() + "\n");

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
			int statusCode = payOverduePayments(profile.getId(), schedule);
			LOGGER.info("(Should fail) Overdue payments paid for schedule, ID: " + schedule.getId() + ", status code: " + statusCode + "\n");

			// Check the balance of GBP wallet for profile 1
			FundingSource fs = getFundingSource(profile.getId(), gbpFundingSourceId);
			LOGGER.info("(Balance should be 7600) GBP funding source for profile, ID: " + fs.asJson() + "\n");

			// Cancel the first schedule
			statusCode = cancelSchedule(profile.getId(), schedule.getId());
			LOGGER.info("Cancel schedule, ID: " + schedule.getId() + ", status code: " + statusCode + "\n");

			// Cancel the second schedule
			statusCode = cancelSchedule(profile.getId(), schedule3.getId());
			LOGGER.info("Cancel schedule, ID: " + schedule3.getId() + ", status code: " + statusCode + "\n");

			// Create a webhook
			Webhook webhook = createWebhook("https://webhook.site/5e4cfa5d-0ae5-447c-ba36-0ecd99adc231");
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

			// Delete the webhook
			statusCode = deleteWebhook(UUID.fromString("17ef373f-aff6-4a6d-99e5-98190f1b699e"));
			LOGGER.info("Delete webhook, ID: 17ef373f-aff6-4a6d-99e5-98190f1b699e, status code: " + statusCode + "\n");
			statusCode = deleteWebhook(UUID.fromString("db98c945-b56e-4bfb-ba9b-dfe578936cdc"));
            LOGGER.info("Delete webhook, ID: db98c945-b56e-4bfb-ba9b-dfe578936cdc, status code: " + statusCode + "\n");

			// Delete the wallet to wallet payment (should fail as it's processing or complete)
			statusCode = deletePayment(profile.getId(), walletToWalletPayment.getId());
			LOGGER.info("(Should fail) Delete the wallet to wallet payment, ID: " + walletToWalletPayment.getId() +
					", status code: " + statusCode + "\n");

			// Get all payments for the profile (after trying to delete the wallet to wallet payment)
			PaymentPage payments2 = getPayments(profile.getId());
			LOGGER.info("Payments for profile, ID: " + profile.getId() + "\n" + payments2.asJson() + "\n");

			// Delete the funding source
			statusCode = deleteFundingSource(profile.getId(), fundingSource.getId());
			LOGGER.info("(Should fail) Delete funding source, ID: " + fundingSource.getId() + " from profile, ID: " +
					profile.getId() + ", status code: " + statusCode + "\n");

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


    // Create a direct debit to wallet schedule for a profile.
    // The funding source must be of type direct debit and the payee must be of type wallet.
    private static Schedule createDirectDebitToWalletSchedule(UUID profileId, UUID fundingSourceId, UUID payeeId) {
        try {
            // Create some metadata (optional)
            JsonNode metadata = JsonHelper.createEmptyObjectNode();
            JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

            // Append the datetime to the schedule to make it unique
            Date date = new Date();
            String today = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
            String title = "Test Daily Direct Debit to Wallet Schedule " + now;

            ScheduleDDToWalletCreate scheduleDDToWalletCreate = new ScheduleDDToWalletBuilder().setTitle(title)
                    .setSchedulePurpose(SchedulePurpose.pay).setSchedulePeriod(SchedulePeriod.daily).setNumberOfPayments(7)
                    .setRegularPaymentStartDate(today).setRegularPaymentAmount(500).setDepositPaymentDate(today)
                    .setDepositPaymentAmount(100).setDescription("7 day DD to wallet schedule paying £5 a day with a deposit of £1")
                    .setMetadata(metadata).setFundingSourceId(fundingSourceId).setPayeeId(payeeId).build();

            return ScheduleService.createDirectDebitToWallet(profileId, scheduleDDToWalletCreate);
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


    // Create a funding source for a profile
    private static FundingSource createFundingSource(UUID profileId) {
        try {
            FundingSourcePayer fundingSourceCreatePayer = new FundingSourcePayerBuilder().setFullName("Jack Smith").build();

            FundingSourceAccount fundingSourceAccount =
                    new FundingSourceAccountBuilder().setSortCode("040004").setAccountNumber("37618166").build();

            FundingSourceCreateData fundingSourceCreateData = new FundingSourceDataBuilder()
                    .setFundingSourceOwnership(FundingSourceOwnership.single).setFundingSourcePayer(fundingSourceCreatePayer)
                    .setFundingSourceAccount(fundingSourceAccount).build();

            FundingSourceCreate fundingSourceCreate =
                    new FundingSourceBuilder().setTitle("Direct Debit Source")
                            .setCurrency(Currency.GBP).setFundingSourceType(FundingSourceType.direct_debit)
                            .setFundingSourceCreateData(fundingSourceCreateData).build();

            return FundingSourceService.create(profileId, fundingSourceCreate);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


    // Create a direct debit funding source for a profile
    private static FundingSource createDirectDebitFundingSource(UUID profileId) {
        try {
            FundingSourcePayer fundingSourceCreatePayer = new FundingSourcePayerBuilder().setFullName("Tom Jones").build();

            FundingSourceAccount fundingSourceAccount =
                    new FundingSourceAccountBuilder().setSortCode("090129").setAccountNumber("07978459").build();

            FundingSourceCreateData fundingSourceCreateData = new FundingSourceDataBuilder()
                    .setFundingSourceOwnership(FundingSourceOwnership.single).setFundingSourcePayer(fundingSourceCreatePayer)
                    .setFundingSourceAccount(fundingSourceAccount).build();

            FundingSourceDDCreate fundingSourceDDCreate =
                    new FundingSourceDDBuilder().setTitle("Direct Debit Source 2")
                            .setCurrency(Currency.GBP).setFundingSourceCreateData(fundingSourceCreateData).build();

            return FundingSourceService.createDirectDebit(profileId, fundingSourceDDCreate);
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


    // Update a funding source with a new title and new payer's email and address
    private static FundingSource updateFundingSource(UUID profileId, UUID fundingSourceId) {
        try {
            // Create a new title (must be unique)
            UUID uuid = UUID.randomUUID();
            String newTitle = "Direct Debit Source " + uuid;

            // Create a funding source address
            FundingSourceAddress fundingSourceAddress = new FundingSourceAddressBuilder()
                    .setAddressLine1("4 Privet Drive").setAddressLine2("Little Whinging")
                    .setAddressLine3("Big Whinging").setCity("Muggle City").setLocality("Surrey")
                    .setPostcode("MC1 1AA").setCountry("GB").build();

            // Create a payer
            FundingSourceUpdatePayer fundingSourceUpdatePayer =
                    new FundingSourcePayerUpdateBuilder()
                            .setEmail("updated-" + uuid + "@email.com").setFundingSourceAddress(fundingSourceAddress).build();

            // Create a funding source (for update)
            FundingSourceUpdate fundingSourceUpdate = new FundingSourceUpdateBuilder().setTitle(newTitle)
                    .setFundingSourceUpdatePayer(fundingSourceUpdatePayer).build();

            return FundingSourceService.update(profileId, fundingSourceId, fundingSourceUpdate);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


    // Validate a funding source with a new title and new payer's name, date of birth, email and address
    private static FundingSource validateFundingSource(UUID profileId, UUID fundingSourceId) {
        try {
            // Create a new title (must be unique)
            UUID uuid = UUID.randomUUID();
            String newTitle = "Funding Source " + uuid;

            // Create a funding source address
            FundingSourceAddress fundingSourceAddress = new FundingSourceAddressBuilder()
                    .setAddressLine1("5 Privet Drive").setAddressLine2("Little Whinging")
                    .setAddressLine3("Big Whinging").setCity("Muggle City").setLocality("Surrey")
                    .setPostcode("MC1 1AA").setCountry("GB").build();

            // Create a payer to validate
            FundingSourceValidatePayer fundingSourceValidatePayer =
                    new FundingSourcePayerValidateBuilder().setFirstName("Mickey").setLastName("Mouse").setBirthDate("1920-05-16")
                            .setEmail("updated-" + uuid + "@email.com").setFundingSourceAddress(fundingSourceAddress).build();

            // Create a funding source (for validation)
            FundingSourceValidate fundingSourceValidate = new FundingSourceValidateBuilder().setTitle(newTitle)
                    .setFundingSourceValidatePayer(fundingSourceValidatePayer).build();

            return FundingSourceService.validate(profileId, fundingSourceId, fundingSourceValidate);
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

            PayeeAccount payeeAccount = new PayeeAccountBuilder().setIban("SAPYGB2L400000537618168")
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
                    .setAmount(10000000).setDescription("Deposit for Flat 1").setCountry("GB").setCurrency(Currency.GBP)
                    .setWebhookUri("https://webhook.site/8b3911e1-7d5d-42a0-9d8c-27e198e96070")
                    .setRedirectUri("https://www.bbc.co.uk").setMetadata(metadata).setProviderId("mock-payments-gb-redirect")
                    .setPayerName("Paul McCartney").setBeneficiaryName("Tesco LTD").build();

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
                    .setBeneficiaryName("Tesco LTD").build();

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
                    .setAmount(1).setDescription("Payment to wallet").setExecutionDate(now)
                    .setCurrency(Currency.GBP).setMetadata(metadata).setPayeeId(payeeId).build();

            return PaymentService.createWalletToWallet(profileId, paymentWalletToPayeeCreate);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


    // Create a single direct debit to wallet payment from the profile to the payee.
    // The funding source must be of type direct debit and the payee must be of type wallet.
    private static Payment createDirectDebitToWalletPayment(UUID profileId, UUID fundingSourceId, UUID payeeId) {
        try {
            // Create some metadata (optional)
            JsonNode metadata = JsonHelper.createEmptyObjectNode();
            JsonHelper.addStringField(metadata, "sample_client_id", "123456789");

            Date date = new Date();
            String now = new SimpleDateFormat("yyyy-MM-dd").format(date);

            PaymentFundingSourceToPayeeCreate paymentFundingSourceToPayeeCreate = new PaymentFundingSourceToPayeeBuilder()
                    .setAmount(1000).setDescription("Single Direct Debit to wallet").setExecutionDate(now)
                    .setCurrency(Currency.GBP).setMetadata(metadata).setFundingSourceId(fundingSourceId).setPayeeId(payeeId).build();

            return PaymentService.createDirectDebitToWallet(profileId, paymentFundingSourceToPayeeCreate);
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

    // Get a page of payments for a profile
    private static PaymentPage getPaymentPage(UUID profileId, int pageNum, int pageSize) {
        try {
            return PaymentService.getPage(profileId, pageNum, pageSize);
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


    // Get the list of non-processing dates with a funding source ID and payee ID
    private static NonProcessingDates getNonProcessingDates(LocalDate intervalStartDate, LocalDate intervalEndDate, UUID fundingSourceId, UUID payeeId) {
        try {
            return PaymentService.getNonProcessingDates(intervalStartDate, intervalEndDate, fundingSourceId, payeeId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }


    // Get the list of non-processing dates with a funding source type and payee type
    private static NonProcessingDates getNonProcessingDates(LocalDate intervalStartDate, LocalDate intervalEndDate,
                                                            FundingSourceType fundingSourceType, PayeeType payeeType) {
        try {
            return PaymentService.getNonProcessingDates(intervalStartDate, intervalEndDate, fundingSourceType, payeeType);
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


    // Get all transactions for a profile
    private static TransactionPage getTransactions(UUID profileId) {
        try {
            return TransactionService.getAll(profileId);
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
