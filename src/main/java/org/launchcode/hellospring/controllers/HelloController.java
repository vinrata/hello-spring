package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {


     //lives at hello/hello
    @RequestMapping(value = "hello",method = {RequestMethod.GET, RequestMethod.POST})
     public String helloWithQueryParam(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
     }

    //lives at /hello/string
     @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
         model.addAttribute("greeting", "Hello, " + name + "!");
             return "Hello";
     }
    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
         return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Bill");
        names.add("Mary");
        names.add("Jeff");
        names.add("Henry");
        model.addAttribute("names", names); //first is what the template sees, second is the value that that variable should have
    return "hello-list";
    }

}
