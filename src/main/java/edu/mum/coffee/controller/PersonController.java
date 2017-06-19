package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by prasannabajracharya on 6/18/17.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @PostMapping("/create")
    public void create(@RequestBody Person person){
         personService.savePerson(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findById(long id){
        return personService.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Person person){
        personService.savePerson(person);
    }
}
