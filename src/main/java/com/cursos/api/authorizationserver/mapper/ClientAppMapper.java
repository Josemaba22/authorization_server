package com.cursos.api.authorizationserver.mapper;

import java.util.Date;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;



import com.cursos.api.authorizationserver.persistence.entity.security.ClientApp;
import java.time.Duration;

public class ClientAppMapper {

    public static RegisteredClient toRegisteredCliend(ClientApp clientApp){

        RegisteredClient client = RegisteredClient.withId(clientApp.getClientId())
            .clientId(clientApp.getClientId())
            .clientSecret(clientApp.getClientSecret())
            .clientIdIssuedAt(new Date(System.currentTimeMillis()).toInstant())
            .clientAuthenticationMethods(clienAuthMethods -> {
                clientApp.getClientAuthenticationMethods().stream()
                    .map(method -> new ClientAuthenticationMethod(method))
                    .forEach(clienAuthMethods::add);
            })
            .authorizationGrantTypes(authGrantTypes -> {
                clientApp.getAuthorizationGrantTypes().stream()
                    .map(grantType -> new AuthorizationGrantType(grantType))
                    .forEach(authGrantTypes::add);
            })
            .redirectUris(redirecUries -> {
                clientApp.getRedirectUris().stream().forEach(redirecUries::add);
            })
            .scopes(scopes -> {
                clientApp.getScopes().stream().forEach(scopes::add);
            })
            .tokenSettings(TokenSettings.builder()
                .accessTokenTimeToLive(Duration.ofMinutes(clientApp.getDurationInMinutes()))
                .refreshTokenTimeToLive(Duration.ofMinutes(clientApp.getDurationInMinutes() * 4))
                .build())
            .clientSettings(ClientSettings.builder()
                .requireProofKey(clientApp.isRequireProofKey())
                .build())
            .build();

            return client;

        }
    }