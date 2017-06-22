package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.GET;
import java.security.Principal;

/**
 * Created by prasannabajracharya on 6/21/17.
 */

@Controller
public class HomeController {

    @Autowired
    PersonService personService;

    @Autowired
    OrderService orderService;

    @GetMapping({"/", "/index"})
    public String homePage() {
        return "index";
    }

    @GetMapping({"/secure"})
    public String securePage() {
        return "secure";
    }

    @GetMapping("/login")
    public String loginPage(Principal principal) {
        return (principal == null) ? "login" : "redirect:/index";
    }

    @GetMapping({"/register"})
    public String register() {
        return "registrationForm";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(Person person) {
        personService.updatePerson(person);
        return "redirect:/productList";
    }

    @GetMapping("/listOrders")
    public String listOrders(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "orderList";
    }

}
