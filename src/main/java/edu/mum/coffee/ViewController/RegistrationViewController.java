package edu.mum.coffee.ViewController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by prasannabajracharya on 6/21/17.
 */
@Controller
public class RegistrationViewController {

    @Autowired
    PersonService personService;

    public RegistrationViewController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/registerUser")
    public String register(@Valid Person person, BindingResult result){
        if(!result.hasErrors()){

            personService.savePerson(person);
            return "redirect:/login";
        }
        return "registrationForm";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal){
        List<Person> personList = personService.findByEmail(principal.getName());
        model.addAttribute("user", personList.get(0));
        return "profileDetails";
    }


}
