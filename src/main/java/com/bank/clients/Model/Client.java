package com.bank.clients.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Document(collection = "clients")
public class Client {
	@Id
    public String id;   
	@Field
	public String name;
	@Field
	public String lastname;
	@Field
	public String email;
	@Field
	public String typeClient;
	@Field
	public String idAccount;
}
