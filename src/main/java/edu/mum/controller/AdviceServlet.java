package edu.mum.controller;

import edu.mum.data.Database;
import edu.mum.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class AdviceServlet {
    @Autowired
    Database data;

    @RequestMapping(value = "/advice/", method = RequestMethod.GET)
    protected ModelAndView  doGet(@ModelAttribute("user") User requestUser) {

        Map<String, String> roastMap = new HashMap<String, String>();

        roastMap.put("Light", "light");
        roastMap.put("Medium", "medium");
        roastMap.put("Dark", "dark");

        ModelAndView mav = new ModelAndView("advice");
        mav.addObject("user",requestUser);
        mav.addObject("roasts", roastMap);

        return mav;
    }

    @RequestMapping(value = "/advice/", method = RequestMethod.POST)
    protected ModelAndView doPost(@ModelAttribute("user")  User requestUser,@RequestParam("roast") String roast) {
        List<String> advice = data.getAdvice(roast);
        ModelAndView mav = new ModelAndView("display");
        mav.addObject("user",requestUser);

        mav.addObject("roastList", advice);
        return mav;
    }

}
