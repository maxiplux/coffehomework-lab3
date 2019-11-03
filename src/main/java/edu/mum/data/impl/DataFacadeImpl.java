package edu.mum.data.impl;

import edu.mum.data.DataFacade;
import org.springframework.stereotype.Component;

import java.util.List;

// Implements Singleton Pattern
@Component
public class DataFacadeImpl implements DataFacade {

    // eager init'ed singleton...
    public final static DataFacadeImpl INSTANCE = new DataFacadeImpl();
    private static final DatabaseImpl data = new DatabaseImpl();

    // Private constructor. Prevents instantiation from other classes.
    private DataFacadeImpl() {

    }

    public String findPassword(String name) {
        String expectedPassword = data.getPassword(name);
        return expectedPassword;
    }

    public List<String> getAdvice(String roast) {
        return data.getAdvice(roast);
    }
}



