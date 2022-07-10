package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

import static java.time.LocalTime.of;

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String thisMethodReturnsHelloWorldStringInGetRequest() {
        return "Hello Sunday!";
    }

    @GetMapping("helloView")
    public String helloView(Model model) {

        LocalTime now = LocalTime.now();
        // LocalTime now = LocalTime.of(21, 0);
        String color, backgroundColor;

        if (now.isAfter(of(8, 0)) && now.isBefore(of(20, 0))) {
            color = "black";
            backgroundColor = "white";
        } else {
            backgroundColor = "black";
            color = "white";
        }

        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        return "home";
    }
}
