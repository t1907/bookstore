package pl.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000/")
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
