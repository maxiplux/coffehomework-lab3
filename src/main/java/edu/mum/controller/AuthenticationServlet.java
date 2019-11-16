package edu.mum.controller;


import edu.mum.data.DataFacade;
import edu.mum.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

@Controller
@SessionAttributes("user")
public class AuthenticationServlet {

    @Autowired
    DataFacade data;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String index() {

        int a =1;
        return "login";
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }


    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    protected String doPost(@ModelAttribute("user")  User requestUser, Model model) {

        Optional<User> user = data.findUserPassword(requestUser.getName(),requestUser.getPassword());

         if (user.isPresent() )
         {

             model.addAttribute("user",user.get());
             return "redirect:/successful";
         }

        return "login";

    }


    @RequestMapping(value="/successful")
    public String loginSuccessful(@ModelAttribute("user")  User requestUser) {
        return "successful";
    }


    @RequestMapping(value="/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}
