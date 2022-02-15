package com.example.rest_api.service;

import com.example.rest_api.model.Client;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ClientService {

    Page<Client> findAllClients(int page, int limit);

    Optional<Client> findById(Long id);

    Client save(Client client);

    void deleteById(Long id);
}
