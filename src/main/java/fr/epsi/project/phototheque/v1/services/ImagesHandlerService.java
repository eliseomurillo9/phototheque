package fr.epsi.project.phototheque.v1.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class ImagesHandlerService {
    @Value("${IMAGE_API_KEY}")
    private String api_key;

    public void imageHandler(String urlString, String imageFile) throws IOException {
        System.out.println("-------------");
        System.out.println(urlString);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        String jsonBody = "{\"image\": \"" + imageFile + "\"}";
        connection.setRequestProperty("x-api-key", api_key);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println(responseCode);
        } else {
            System.out.println("ERROR: " + responseCode);
        }
        connection.disconnect();
    }
}
