package br.com.rodrigocmo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController(value = "/math")
public class MathController {
    private static final String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{numberOne}/{numeberTwo}")
    public Double sum(@RequestParam(value = "name", defaultValue = "Word") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
