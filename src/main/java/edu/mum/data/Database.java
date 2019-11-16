package edu.mum.data;

import java.util.List;
import java.util.Optional;

public interface Database {
    abstract Optional<User> getPassword(String name);

    Optional<User> findUserPassword(String name, String password);

    List<String> getAdvice(String roast);

}
