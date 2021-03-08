package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.Webhook;
import com.customate.client.models.WebhookCreate;
import com.customate.client.models.WebhookPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for webhooks.
 *
 * Date: 26-Feb-21
 * Time: 4:24 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class WebhookService {

    /**
     * Gets all webhooks.
     *
     * @return WebhookPage  A webhook object.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static WebhookPage getAll() throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("webhooks");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, WebhookPage.class);
    }

    /**
     * Gets a page of webhooks.
     *
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return WebhookPage  A webhook object.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static WebhookPage getPage(int pageNum, int pageSize) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("webhooks?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, WebhookPage.class);
    }

    /**
     * Gets a webhook.
     *
     * @param id  ID of the webhook
     * @return WebhookPage  A webhook object.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Webhook get(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("webhooks/" + id);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Webhook.class);
    }

    /**
     * Creates a webhook.
     *
     * @param webhookCreate  The webhook to create.
     * @return Webhook  The webhook.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Webhook create(WebhookCreate webhookCreate) throws URISyntaxException, IOException, InterruptedException, ApiException {
        webhookCreate.setEnabled(true);
        HttpResponse<String> response = CustomateClient.post("webhooks", webhookCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Webhook.class);
    }

    /**
     * Updates a webhook.
     *
     * @param webhook  The webhook to update.
     * @return Webhook  The webhook.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Webhook update(Webhook webhook) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.put("webhooks/" + webhook.getId(), webhook.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Webhook.class);
    }

    /**
     * Deletes a webhook.
     *
     * @param id  The ID of the webhook to delete.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("webhooks/" + id);
        return response.statusCode();
    }

}
