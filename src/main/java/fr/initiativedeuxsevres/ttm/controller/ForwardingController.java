package fr.initiativedeuxsevres.ttm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {
    @RequestMapping("/**/{path:[^\\.]+}")
    public String forward() {
        return "index";
    }
}