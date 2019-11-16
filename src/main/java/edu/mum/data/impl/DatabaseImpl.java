package edu.mum.data.impl;

import edu.mum.data.Database;
import edu.mum.data.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseImpl implements Database {
    private static List<User> users = new ArrayList<>();
    private static HashMap<String, List<String>> advice = new HashMap<String, List<String>>();

    static {
        users.add( new User("Dave", "111"));
        users.add( new User("admin", "admin"));
        users.add( new User("Steve", "222"));
        users.add( new User("Ralph", "333"));
        ArrayList<String> darkList = new ArrayList<String>();
        darkList.add("Sumatra");
        darkList.add("Verona");
        darkList.add("French Roast");
        advice.put("dark", darkList);
        ArrayList<String> medList = new ArrayList<String>();
        medList.add("Breakfast Blend");
        medList.add("Colombia");
        medList.add("Yukon");
        medList.add("Pike Place");
        medList.add("House Blend");
        advice.put("medium", medList);
        ArrayList<String> lightList = new ArrayList<String>();
        lightList.add("Willow");
        lightList.add("Aria");
        lightList.add("Bright Sky");
        lightList.add("Veranda");
        advice.put("light", lightList);
    }

    @Override
    public Optional<User> getPassword(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserPassword(String name, String password) {

        return users.stream().filter( u-> u.getName().equals(name)  &&  u.getPassword().equals(password)  ).findFirst();

    }



    @Override
    public List<String> getAdvice(String roast) {
        return advice.get(roast);
    }




}
