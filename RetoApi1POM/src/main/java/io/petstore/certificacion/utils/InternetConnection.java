package io.petstore.certificacion.utils;

import cucumber.api.PendingException;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

import static io.petstore.certificacion.utils.enums.EnumPetstore.URI_PETSTORE;


public class InternetConnection {

    //private static final Logger LOGGER=

    public void checkInternetConnection() {
        try {
            URL url = new URL(URI_PETSTORE.getValue());
            HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
            huc.connect();
        } catch (Exception e) {
            //LOGGER.error("Check your internet connection");
            throw new PendingException("Check your internet connection");
        } finally {
            return;
        }
    }

}
