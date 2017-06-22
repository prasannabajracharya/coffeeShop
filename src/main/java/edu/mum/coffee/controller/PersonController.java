package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prasannabajracharya on 6/18/17.
 */
@RestController
@RequestMapping("/rs/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable("id") long id) {
        try {
            Person person = personService.findById(id);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity findAllUsers() {
        try {
            List<Person> person = personService.findAll();
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Person> findByEmail(@RequestParam("email") String email) { // RequestParam is used because email doesnot work on path variable
        return personService.findByEmail(email);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Person person) {
        personService.updatePerson(person);
    }
}
