package yousry.mohammed.content_calender.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateContentController {

    @GetMapping("/updatecontent.html")
    public String updateContent() {
        return "updatecontent";
    }
}