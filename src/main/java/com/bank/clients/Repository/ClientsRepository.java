package com.bank.clients.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.clients.Model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClientsRepository extends ReactiveMongoRepository<Client, String>{

	Mono<Client> findByid(String id);
    Flux<Client> findByName(String name);
}
