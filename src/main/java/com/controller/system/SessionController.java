package com.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {

    @RequestMapping
    public String session(HttpSession session) {
        session.invalidate();
        return "/system/login";
    }

}
