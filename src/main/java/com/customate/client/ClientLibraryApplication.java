package com.customate.client;

import com.customate.client.builders.*;
import com.customate.client.enums.*;
import com.customate.client.models.*;
import com.customate.client.service.*;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientLibraryApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientLibraryApplication.class);

	private static CustomateClient customateClient = new CustomateClient("<API URL>",
			"v1", "<YOUR API KEY>", "<YOUR API SECRET>");

	public static void main(String[] args) {
		SpringApplication.run(ClientLibraryApplication.class, args);

		try {

			// Get the API status
			Status status = getStatus();
			LOGGER.info("API Status\n" + status.asJson());

			// Create a profile
			Profile profile = createProfile("paulmccartney10@music.com", "+447773100010");
			LOGGER.info("Profile\n" + profile.asJson());

			// Force-verify the profile
			VerificationResponse verificationResponse = forceVerifyProfile(profile);
			LOGGER.info("Force-verification of profile\n" + verificationResponse.asJson());

			// Get the newly-created profile
			Profile verifiedProfile = getProfile(profile.getId());
			LOGGER.info("Verified profile\n" + verifiedProfile.asJson());

			// Create a second profile
			Profile profile2 = createProfile("paulmccartney12@music.com", "+447773100012");
			LOGGER.info("Profile 2\n" + profile2.asJson());

			// Verify the second profile (this will fail as we're not using real data)
			VerificationResponse verificationResponse2 = verifyProfile(profile2);
			LOGGER.info("Verification of profile 2\n" + verificationResponse2.asJson());

			// Update the profile's address from Westminster Cathedral to Westminster Abbey
			Profile updatedProfile = updateProfile(profile);
			LOGGER.info("Updated profile\n" + updatedProfile.asJson());

			// Get all profiles
			ProfilePage profiles = getAllProfiles();
			LOGGER.info("All profiles\n" + profiles.asJson());

			// Get a page of profiles
			ProfilePage profilePage = getProfilePage(1, 4);
			LOGGER.info("Page 1 with 4 profiles per page\n" + profilePage.asJson());

			// Get the wallets for the profile
			WalletPage wallets = getWallets(profile.getId());
			LOGGER.info("Wallets for profile, ID: " + profile.getId() + "\n" + wallets.asJson());

			// Get a page of wallets
			WalletPage walletPage = getWalletPage(profile.getId(), 1, 1);
			LOGGER.info("Page 1 with 1 wallet per page\n" + walletPage.asJson());

			// Create a (direct debit) funding source for the profile
			FundingSource fundingSource = createFundingSource(profile);
			LOGGER.info("Created funding source for profile, ID: " + profile.getId() + "\n" + fundingSource.asJson());

			// Get the newly-created funding source
			FundingSource fundingSource1 = getFundingSource(profile.getId(), fundingSource.getId());
			LOGGER.info("Funding source, ID: " + fundingSource1.getId() + " for profile, ID: " + profile.getId() + "\n" + fundingSource1.asJson());

			// Get the funding sources for a profile
			FundingSourcePage fundingSources = getFundingSources(profile.getId());
			LOGGER.info("Funding sources for profile, ID: " + profile.getId() + "\n" + fundingSources.asJson());

			// Get a page of funding sources
			FundingSourcePage fundingSourcePage = getFundingSourcePage(profile.getId(), 1, 1);
			LOGGER.info("Page 1 with 1 funding source per page\n" + fundingSourcePage.asJson());

			// Delete the funding source
			int statusCode = deleteFundingSource(profile.getId(), fundingSource1.getId());
			LOGGER.info("Deleted funding source, ID: " + fundingSource1.getId() + " from profile, ID: " + profile.getId() + ", status code: " + statusCode);

			// Get all transactions for the profile
			TransactionPage transactions = getAllTransactions(profile.getId());
			LOGGER.info("Transactions for profile, ID: " + profile.getId() + "\n" + transactions.asJson());

			// Get a page of transactions
			TransactionPage transactionPage = getTransactionPage(profile.getId(), 1, 1);
			LOGGER.info("Page 1 with 1 transaction\n" + transactionPage.asJson());

			// Get transaction bcdd31ab-b9cb-415f-821c-74f00c9aa377
			Transaction transaction = getTransaction(profile.getId(), UUID.fromString("bcdd31ab-b9cb-415f-821c-74f00c9aa377"));
			LOGGER.info("Transaction:\n" + transaction.asJson());

			// Delete the profiles
			statusCode = deleteProfile(profile.getId());
			LOGGER.info("Deleted profile, ID: " + profile.getId() + ", status code: " + statusCode);
			statusCode = deleteProfile(profile2.getId());
			LOGGER.info("Deleted profile, ID: " + profile2.getId() + ", status code: " + statusCode);

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
			Profile newProfile1 = new ProfileBuilder()
					.setType(ProfileType.personal).setTitle(Title.mr).setFirstName("James").setMiddleName("Paul")
					.setLastName("McCartney").setEmail(email).setPhoneNumber(phoneNumber)
					.setBirthDate("1942-06-18").setAddress(address).setGender(Gender.male).setMetadata(metadata).build();

			return ProfileService.create(newProfile1);
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

	// Verify a profile (check the country of birth, mother's maiden name, passport or driving licence)
	private static VerificationResponse verifyProfile(Profile profile) {
		try {
			Passport passport = new PassportBuilder().setOriginCountry("GB")
					.setNumber("PD12345678IRL1234567M1234567<<<<<<<<<<<<<<<0").setExpiryDate("2031-09-23").build();
			DriverLicence driverLicence = new DriverLicenceBuilder().setNumber("EUEGE123456BM9NM")
					.setPostcode("B126DY").setIssueDate("2011-10-27").build();
			VerificationRequest verificationRequest = new VerificationRequestBuilder()
					.setBirthCountry("IE").setMotherMaidenName("Smithy").setPassport(passport).setDriverLicence(driverLicence).build();
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
	private static ProfilePage getAllProfiles() {
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
	private static FundingSource createFundingSource(Profile profile) {
		try {
			FundingSourcePayer fundingSourcePayer = new FundingSourcePayerBuilder().setFullName("Jack Smith").build();

			FundingSourceAccount fundingSourceAccount =
					new FundingSourceAccountBuilder().setSortCode("040004").setAccountNumber("37618166").build();

			FundingSourceCreateData fundingSourceCreateData = new FundingSourceDataBuilder()
					.setFundingSourceOwnership(FundingSourceOwnership.single).setFundingSourcePayer(fundingSourcePayer)
					.setFundingSourceAccount(fundingSourceAccount).build();

			FundingSourceCreate fundingSourceCreate =
					new FundingSourceBuilder().setTitle("Direct Debit Source")
							.setCurrency(Currency.GBP).setFundingSourceType(FundingSourceType.direct_debit)
							.setFundingSourceCreateData(fundingSourceCreateData).build();

			return FundingSourceService.create(profile.getId(), fundingSourceCreate);
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

	// Get all transactions for a profile
	private static TransactionPage getAllTransactions(UUID profileId) {
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
}
