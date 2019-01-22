package com.lifengming.tybs.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * on 2018-03-18 12:45
 * @author lifengming
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }


}
