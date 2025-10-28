package es.uclm.library.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.uclm.library.business.entity.Greeting;
import es.uclm.library.business.repository.GreetingRepository;

@Controller
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        log.info("Listado de saludos: {}", greetingRepository.findAll());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        Greeting saved = greetingRepository.save(greeting);
        model.addAttribute("greeting", saved);
        log.info("Nuevo saludo guardado: {}", saved);
        return "result";
    }
}
