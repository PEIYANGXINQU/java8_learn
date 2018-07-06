package chapter8_重构_测试_调试;

/**
 * @ClassName InputValidatorImplA
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class InputValidatorImplA implements InputValidator {
    @Override
    public boolean validate(String str) {
        return str.matches("\\d+");
    }
}
