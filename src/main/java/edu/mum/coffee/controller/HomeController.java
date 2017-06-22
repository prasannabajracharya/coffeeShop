package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by prasannabajracharya on 6/21/17.
 */

    @Controller
    public class HomeController {

        @Autowired
        PersonService personService;


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

    @PutMapping("/updateProfile")
    public String updateProfile(Person person){
            personService.savePerson(person);
            return "redirect:/productList";
    }

}
