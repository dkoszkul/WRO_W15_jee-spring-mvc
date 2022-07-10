package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("random")
public class RandomController {

    @GetMapping("{max}")
    @ResponseBody
    public String generateRandomWithMax(@PathVariable("max") int max) {
        int rand = new Random().nextInt(max) + 1;
        return "Użytkownik podał wartość "
                + max
                + ". Wylosowano liczbę: "
                + rand;
    }

    @GetMapping("{min}/{max}")
    @ResponseBody
    public String generateRandomWithMax(@PathVariable("min") int min,
                                        @PathVariable("max") int max) {
        int rand = new Random().nextInt(max - min) + min;
        return "Użytkownik podał wartość "
                + min
                + "-"
                + max
                + ". Wylosowano liczbę: "
                + rand;
    }
}
