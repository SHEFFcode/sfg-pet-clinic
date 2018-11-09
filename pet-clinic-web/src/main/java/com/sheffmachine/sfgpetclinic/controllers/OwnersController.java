package com.sheffmachine.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") // alternative way to do /owners/index etc
@Controller
public class OwnersController {
    @RequestMapping({"", "/", "/index", "/index.html"})
    String listOwners() {
            return "owners/index";
    }
}
