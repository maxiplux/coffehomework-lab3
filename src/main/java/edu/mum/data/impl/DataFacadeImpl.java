package edu.mum.data.impl;

import edu.mum.data.DataFacade;
import edu.mum.data.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Implements Singleton Pattern
@Component
public class DataFacadeImpl implements DataFacade {

    // eager init'ed singleton...
    public final static DataFacadeImpl INSTANCE = new DataFacadeImpl();
    private static final DatabaseImpl data = new DatabaseImpl();

    // Private constructor. Prevents instantiation from other classes.
    private DataFacadeImpl() {

    }

    @Override
    public Optional<User> findUserPassword(String name, String password) {

        return data.findUserPassword(name,password);
    }



    public List<String> getAdvice(String roast) {
        return data.getAdvice(roast);
    }
}



