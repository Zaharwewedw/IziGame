package Store.authorization.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ControllerStart {


    @GetMapping
    public String getViuStart() {
        return "start";
    }
}
