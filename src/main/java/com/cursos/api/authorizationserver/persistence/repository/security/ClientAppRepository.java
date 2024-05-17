package com.cursos.api.authorizationserver.persistence.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.api.authorizationserver.persistence.entity.security.ClientApp;

public interface ClientAppRepository extends JpaRepository<ClientApp, Long>{
    
    Optional<ClientApp> findByClientId(String clientId);

}
