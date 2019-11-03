package edu.mum.controller;


import edu.mum.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationServlet {

    @Autowired
    DataFacade data;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String index() {

        int a =1;
        return "login";
    }


    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    protected String doPost(@RequestParam("name") String name, @RequestParam("password") String password) {
        String expectedPassword = data.findPassword(name);
        if (expectedPassword == null || !expectedPassword.equals(password)) {
            return "login";

        }
        return "LoginSuccessful";

    }
}
