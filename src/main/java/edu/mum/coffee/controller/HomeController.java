package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by prasannabajracharya on 6/21/17.
 */

    @Controller
    public class HomeController {

        @GetMapping({"/", "/index"})
        public String homePage() {
            return "index";
        }

        @GetMapping({"/secure"})
        public String securePage() {
            return "secure";
        }

    @GetMapping("/login")
    public String loginPage(Principal principal){
        return (principal == null)?"login":"redirect:/index";
    }

        @GetMapping({"/register"})
        public String register(){
            return "registrationForm";
        }

}
