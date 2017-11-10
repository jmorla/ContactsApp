package org.jmorla.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Created by jmorla on 09/11/2017.
 */
@ControllerAdvice
public class NotFoundHandlerController {

    @ExceptionHandler({Exception.class})
    public String methodNotFound404(){
        return "/errors/404";
    }
}
