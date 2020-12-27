package com.maltsev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        System.out.println("hello! " + name + " " + surname);
        model.addAttribute("message", "hello " + name + "  " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action, Model model) {

        switch (action) {
            case "sum":
                model.addAttribute("message", a + "+" + b + "=" + (a + b));
                break;
            case "sub":
                model.addAttribute("message", a + "-" + b + "=" + (a - b));
                break;
            case "mult":
                model.addAttribute("message", a + "*" + b + "=" + (a * b));
                break;
            case "div":
                model.addAttribute("message", a + ":" + b + "=" + (a /(double) b));
                break;
            default:
        }
        return "first/calculator";

    }
}
