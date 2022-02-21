package com.bank.clients.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.clients.Model.Client;
import com.bank.clients.Repository.ClientsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl  implements ClientService{

	 @Autowired
	 ClientsRepository repository;
	 
	@Override
	public Flux<Client> findAll() {
		 return repository.findAll();
	}

	@Override
	public Mono<Client> save(Client client) {
		return repository.save(client);
	}

    @Override
    public Flux<Client> findClientsByName(String name) {
        return repository.findByName(name);
    }


    @Override
    public Mono<Client> update(Client client) {
        return repository.save(client);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

	
}
