package br.com.zuco.controllers;

import br.com.zuco.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong couter = new AtomicLong();

    // http://localhost:8080/greeting?name=Zuco
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Word")
            String name) {
        return new Greeting(couter.incrementAndGet(), String.format(template, name));
    }
}
