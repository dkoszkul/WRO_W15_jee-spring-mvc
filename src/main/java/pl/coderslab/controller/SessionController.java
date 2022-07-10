package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Slf4j
@Controller
@SessionAttributes("loginStart")
public class SessionController {

//    private static final Logger log = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("login")
    @ResponseBody
    public String login(Model model, HttpSession session) {
        model.asMap().entrySet().forEach(kv -> log.info("{} - {}", kv.getKey(), kv.getValue()));

        if(!model.asMap().containsKey("loginStart")) {
            LocalDateTime ldt = LocalDateTime.now();
//            model.addAttribute("loginStart", ldt);
            session.setAttribute("loginStart", ldt);
            return ldt.toString();
        }

        return model.asMap().entrySet()
                .stream().filter(e -> e.getKey().equals("loginStart"))
                .findFirst()
                .get()
                .getValue()
                .toString();
    }

}
