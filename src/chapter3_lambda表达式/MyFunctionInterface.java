package chapter3_lambda表达式;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface MyFunctionInterface {
    public String process(BufferedReader bufferedReader) throws IOException;

}
