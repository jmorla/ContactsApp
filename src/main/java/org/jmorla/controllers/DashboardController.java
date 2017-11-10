package org.jmorla.controllers;

import org.jmorla.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jmorla on 26/10/2017.
 */
@Controller
@RequestMapping("/dashboard/")
public class DashboardController {

    @Autowired  private ContactRepository contactRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loadDashboard(Model model){
        model.addAttribute("contacts",contactRepository.findAll());
        return "dashboard";
    }
}
