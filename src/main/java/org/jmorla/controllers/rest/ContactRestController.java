package org.jmorla.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.jmorla.models.Contacts;
import org.jmorla.repositories.ContactRepository;
@RestController
@RequestMapping("/rest/contact/")
public class ContactRestController {

	@Autowired private ContactRepository contactRepository;
	
	@RequestMapping(value="/list/",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			method=RequestMethod.GET)
	public List<Contacts> listContacts(){
		return contactRepository.findAll();
	}
}
