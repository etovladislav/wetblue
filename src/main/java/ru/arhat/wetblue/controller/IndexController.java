package ru.arhat.wetblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by etovladislav on 21.06.16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String getIndexPage() {
        return "index";
    }
}
