package fr.epsi.project.phototheque.entity;

import lombok.Builder;

@Builder
public class JwtResponse {
    private String token;
    private String user;



    public JwtResponse(String token, String user) {
        this.token = token;
        this.user = user;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
