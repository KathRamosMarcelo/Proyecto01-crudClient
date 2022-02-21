package com.bank.clients.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bank.clients.Model.Client;
import com.bank.clients.Model.Mensaje;
import com.bank.clients.Service.ClientService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class controller {
Logger log = org.slf4j.LoggerFactory.getLogger(controller.class);
	
   @Autowired
    ClientService serviceClientService;


    @GetMapping
    public Flux<Client> getClient(){
        log.info("Se inicia el findall del Cliente");
        return serviceClientService.findAll();
    }


    @GetMapping("/getNameClient/{name}")
    public Flux<Client> getClientByName(@PathVariable("name") String name){
        return serviceClientService.findClientsByName(name);
    }


    @PostMapping
    Mono<Client> postClient(@RequestBody Client clients){

    	return serviceClientService.save(clients);
          
    }

    @PostMapping("/updateClient")
    Mono<Client> update (@RequestBody Client clients ){
        return serviceClientService.update(clients);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity delete (@PathVariable("id") String id) {
    	serviceClientService.delete(id);
    return new ResponseEntity(new Mensaje("Cliente del ID: "+ id + " Eliminado Correctamente!!!"),HttpStatus.OK);
    }
    

}
