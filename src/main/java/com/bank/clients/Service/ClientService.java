package com.bank.clients.Service;

import com.bank.clients.Model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	Flux<Client> findAll();
	Mono<Client> save(Client client);
    Flux<Client> findClientsByName(String name);
    Mono<Client> update(Client client);
    void delete(String id);
}
