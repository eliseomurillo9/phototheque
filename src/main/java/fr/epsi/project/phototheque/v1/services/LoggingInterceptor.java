package fr.epsi.project.phototheque.v1.services;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println("Request URI: " + request.getURI());
        System.out.println("Request Method: " + request.getMethod());
        // Log headers if needed
        System.out.println("Request Headers: " + request.getHeaders());
        System.out.println("Request Body: " + request.getURI().getQuery());
        // Log request body if needed
        // System.out.println("Request Body: " + new String(body, StandardCharsets.UTF_8));
        return execution.execute(request, body);
    }

}