package ru.arhat.wetblue.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.arhat.wetblue.model.Company;
import ru.arhat.wetblue.model.User;

/**
 * Created by etovladislav on 21.06.16.
 */
@Controller
public class IndexController {


    @RequestMapping(value = {"/admin", "/"})
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = {"/login"})
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/checkAuth", method = RequestMethod.GET)
    @ResponseBody
    public Boolean saveCompany() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            return false;
        }
        return true;
    }

}
