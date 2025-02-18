package cursoSpringBoot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestControlller {

    @GetMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name) {
        System.out.println("Solicitud ejecutada");
        return "Hola, " + name;
    }

}
