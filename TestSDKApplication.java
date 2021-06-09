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
import java.util.UUID;

/**
 * Tests some of the endpoints in the Customate Java SDK.
 *
 * THIS IS USED IN THE JENKINS JOB CheckAPI_Isup.
 *
 * Date: 08-Mar-21
 * Time: 1:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
//@SpringBootApplication
public class TestSDKApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSDKApplication.class);

	// Tests some of the endpoints
	public static void main(String[] args) {
		SpringApplication.run(TestOpenBankingApplication.class, args);
		try {
			// Get the API status
			Status status = getStatus();
			LOGGER.info("\n");
			LOGGER.info("API Status\n" + status.asJson() + "\n");
			LOGGER.info("\n");

			// Get a page of 2 profiles
			ProfilePage profilePage = getProfilePage(1, 2);
			LOGGER.info("Page 1 with 4 profiles per page\n" + profilePage.asJson() + "\n");
			LOGGER.info("\n");

			// Get open banking providers in the UK
			PaymentOpenBankingProviderPage paymentOpenBankingProviderPage = getOpenBankingProviders(Currency.GBP, "GB");
			LOGGER.info("Open banking providers (banks) in the UK: " + "\n" + paymentOpenBankingProviderPage.asJson() + "\n");
			LOGGER.info("\n");

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


	// Get open banking providers
	private static PaymentOpenBankingProviderPage getOpenBankingProviders(Currency currency, String country) {
		try {
			return PaymentService.getOpenBankingProviders(currency, country);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}


}