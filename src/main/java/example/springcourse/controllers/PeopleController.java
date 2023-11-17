package example.springcourse.controllers;

import example.springcourse.dao.PersonDAO;
import example.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String people(Model model) {
        model.addAttribute("people", personDAO.getPeople());

        return "people/people";
    }

    @GetMapping("/{id}")
    public String person(@PathVariable("id") int id,
                         Model model) {

        model.addAttribute("person", personDAO.getPerson(id));

        return "people/person";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        Person person = new Person();
        model.addAttribute(person);
        return "people/new";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person) {
        personDAO.savePerson(person);

        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAO.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }

    @GetMapping("/test-multiply")
    public String testMultiplyUpdate() {
        personDAO.testMultiply();

        return "redirect:/people";
    }

    @GetMapping("/test-batch")
    public String testBatchUpdate() {
        personDAO.testBatch();

        return "redirect:/people";
    }

    @GetMapping("/test")
    public String test() {
        return "people/testBatchAndMultiply";
    }
}
