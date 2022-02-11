package com.example.rest_api.controller;

import com.example.rest_api.exception.ClientNotFoundException;
import com.example.rest_api.model.Client;
import com.example.rest_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) throws URISyntaxException {
        Client savedClient = clientService.save(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client currentClient = clientService.findById(id).orElseThrow(ClientNotFoundException::new);
        currentClient.setAge(client.getAge());
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        clientService.save(currentClient);

        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
