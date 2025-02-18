package cursoSpringBoot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestControlller {

    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld() {
        System.out.println("Solicitud ejecutada");
        return "Hola, Mundo";
    }

}
