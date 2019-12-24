package mk.ukim.finki.wp.lab.web.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ControllerClass {

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(@RequestParam String query,@RequestParam String model) {
        return "redirect:/";

    }


}
