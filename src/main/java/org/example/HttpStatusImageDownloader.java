package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String imageUrl = checker.getStatusImage(code);
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            OutputStream outputStream = new FileOutputStream(code + ".jpg")) {

                byte[] buffer = new byte[1024];
                int count;
                while ((count = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, count);
                }

                System.out.println("Image for status code (" + code + ") downloaded");
            }
        } catch (IOException e) {
            throw new Exception("Failed to download image: " + e.getMessage());
        }
    }
}
