package coffee.trapapp.coffee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class TrapappController {

    @GetMapping
    public String welcomeTrapApp() {
        return "Welcome to Trapapp";
    }
}
