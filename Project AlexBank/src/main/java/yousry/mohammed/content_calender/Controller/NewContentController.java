package yousry.mohammed.content_calender.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewContentController {

    @GetMapping("/newcontent.html")
    public String newcontent() {
        return "newcontent";
    }
}

