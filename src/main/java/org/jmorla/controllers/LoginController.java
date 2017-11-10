package org.jmorla.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jmorla on 08/11/2017.
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @RequestMapping
    public String showLogin(){
        return "login";
    }
}
