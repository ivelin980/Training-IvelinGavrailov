package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class ContactController {
    private List<Contact> contacts;
    public static final String REDIRECT = "redirect:/";

    public ContactController() {
        this.contacts = new ArrayList<Contact>();
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", this.contacts);
        return modelAndView;
    }

    @PostMapping("/")
    public String storeContact(Contact contact) {
        this.contacts.add(contact);
        return REDIRECT;
    }

    @DeleteMapping("/contacts/{name}")
    public  String deleteContact(@PathVariable String name){
        this.contacts = this.contacts.stream().filter(c -> !c.getName().equals(name)).collect(Collectors.toList());
        return REDIRECT;
    }
}
