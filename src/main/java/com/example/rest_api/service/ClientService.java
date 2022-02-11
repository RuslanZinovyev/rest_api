package com.example.rest_api.service;

import com.example.rest_api.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAllClients();

    Optional<Client> findById(Long id);

    Client save(Client client);

    void deleteById(Long id);
}
