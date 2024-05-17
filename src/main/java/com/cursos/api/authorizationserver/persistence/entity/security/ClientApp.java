package com.cursos.api.authorizationserver.persistence.entity.security;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClientApp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean requireProofKey;

    private String clientId;     
	private String clientSecret;  

    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> clientAuthenticationMethods;    
	
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorizationGrantTypes;
    
    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> redirectUris;   

    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> scopes;

    private int durationInMinutes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public List<String> getClientAuthenticationMethods() {
        return clientAuthenticationMethods;
    }
    public void setClientAuthenticationMethods(List<String> clientAuthenticationMethods) {
        this.clientAuthenticationMethods = clientAuthenticationMethods;
    }
    public List<String> getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }
    public void setAuthorizationGrantTypes(List<String> authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }
    public List<String> getRedirectUris() {
        return redirectUris;
    }
    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }
    public List<String> getScopes() {
        return scopes;
    }
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
    public boolean isRequireProofKey() {
        return requireProofKey;
    }
    public void setRequireProofKey(boolean requireProofKey) {
        this.requireProofKey = requireProofKey;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    } 

    

}
