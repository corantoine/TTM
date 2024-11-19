package fr.initiativedeuxsevres.ttm.configuration;

// Controller permettant la mise en place du BFF
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {
    @RequestMapping("/{anyPath}/**")
    public String forward(@PathVariable String anyPath) {
        return "forward:/";
    }
}
