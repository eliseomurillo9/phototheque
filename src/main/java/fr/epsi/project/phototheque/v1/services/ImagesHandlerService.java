package fr.epsi.project.phototheque.v1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ImagesHandlerService {
    @Value("${IMAGE_API_KEY}")
    private String api_key;

    public void imageHandler(String urlString, MultipartFile imageFile) throws IOException {
        String jsonBody = "{\"filename\": \"" + imageFile.getOriginalFilename() + "\"}";
        var fileInfo = imageFile.getInputStream();


        RestClient restClient = RestClient.create();
        String result = restClient.post()
                .uri(urlString)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(httpHeaders -> {
                    httpHeaders.set("x-api-key", api_key);
                })
                .body(jsonBody)
                .retrieve()
                .body(String.class);


        if (result != null) {
            System.out.println(result);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> responseMap = mapper.readValue(result, Map.class);
            ByteArrayResource resource = new ByteArrayResource(imageFile.getBytes());
            System.out.println(resource);

            // Access the signedUrl
            String signedUrl = responseMap.get("signedUrl");

            String imageAnalizer = restClient.put()
                    .uri(signedUrl)
                    .headers(httpHeaders -> {
                        httpHeaders.set("Content-Type", "image/jpeg");
                    })
                    .body(resource)
                    .retrieve()
                    .body(String.class);


            System.out.println(imageAnalizer);
        }
  /**      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        String jsonBody = "{\"filename\": \"" + imageFile.getOriginalFilename() + "\"}";
        connection.setRequestProperty("x-api-key", api_key);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            var fileInfo = connection.getInputStream().toString();

            System.out.println(fileInfo);
        } else {
            System.out.println("ERROR: " + responseCode);
        }
        connection.disconnect(); */
    }
}

