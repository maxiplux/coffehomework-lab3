package edu.mum.data;

import java.util.List;
import java.util.Optional;

public interface DataFacade {


    Optional<User> findUserPassword(String name, String password);

    public List<String> getAdvice(String roast);
}
