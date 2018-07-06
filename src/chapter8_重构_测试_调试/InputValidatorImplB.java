package chapter8_重构_测试_调试;

/**
 * @ClassName InputValidatorImplB
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class InputValidatorImplB implements InputValidator {
    @Override
    public boolean validate(String str) {
        return str.matches("[a-z]+");
    }
}
