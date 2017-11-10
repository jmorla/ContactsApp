package org.jmorla.controllers;

import org.jmorla.models.Contacts;
import org.jmorla.repositories.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by jmorla on 28/10/2017.
 */
@Controller
@RequestMapping("/add/contact/")
public class AddContactController {

    private ContactRepository contactRepository;

    public AddContactController(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showContactForm(Model model){
        model.addAttribute("contact",new Contacts());
        return "addcontact";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addContact(@ModelAttribute ("contact") @Valid Contacts contact, BindingResult result){
        if(result.hasErrors()){
            return "addcontact";
        }

        String id = UUID.randomUUID().toString();
        id  = id.substring(24,36);
        contact.setId(id);

        contactRepository.save(contact);
        return "redirect:/dashboard/";
    }
}
