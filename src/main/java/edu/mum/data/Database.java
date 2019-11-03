package edu.mum.data;

import java.util.List;

public interface Database {
    String getPassword(String name);

    List<String> getAdvice(String roast);

    String findPassword(String name);
}
