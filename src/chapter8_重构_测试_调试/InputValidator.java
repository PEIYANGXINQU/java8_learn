package chapter8_重构_测试_调试;

/**
 * @ClassName InputValidator
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@FunctionalInterface
public interface InputValidator {

    boolean validate(String str);
}
