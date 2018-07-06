package chapter8_重构_测试_调试;

/**
 * @ClassName ValidateInput
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ValidateInput {

    public static void main(String[] args) {
     /*   InputValidator inputValidator = new InputValidatorImplA();
        boolean cris = validate("cris", inputValidator);
        System.out.println(cris);
        inputValidator = new InputValidatorImplB();
        boolean cris1 = validate("cris", inputValidator);
        System.out.println(cris1);*/
        boolean cris = validate("cris", str -> str.matches("[a-z]+"));
        boolean cris1 = validate("cris", str -> str.matches("\\d+"));
        System.out.println(cris + "====" + cris1);

    }

    public static boolean validate(String string, InputValidator inputValidator) {
        return inputValidator.validate(string);
    }

}
