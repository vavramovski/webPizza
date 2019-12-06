package mk.ukim.finki.wp.lab.web.servlet;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoaderListener;


@Controller
public class ControllerClass {

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String search(@RequestParam String query,@RequestParam String model) {
        return "redirect:/";

    }


}
