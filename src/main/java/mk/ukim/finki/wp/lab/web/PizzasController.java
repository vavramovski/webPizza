package mk.ukim.finki.wp.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("piz")
public class PizzasController {

    @GetMapping
    public String home() {
        return "piz.html";
    }
}
