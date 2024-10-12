package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String status = "https://http.cat/" + code + ".jpg";
        URL url = new URL(status);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        if (responseCode == 404) {
            throw new Exception("There is no image for this code");
        } else {
            return status;
        }
    }
}
