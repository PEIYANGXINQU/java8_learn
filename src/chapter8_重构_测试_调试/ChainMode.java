package chapter8_重构_测试_调试;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @ClassName ChainMode
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ChainMode {
    public static void main(String[] args) {
       /* Chain chain = new ChainA();
        chain.setChain(new ChainB());
        String crissss = chain.handle("crissss");
        System.out.println(crissss);*/

        UnaryOperator<String> unaryOperator = s -> s.replace("s", "a");
        UnaryOperator<String> unaryOperator1 = s -> s.toUpperCase();
        Function<String, String> function = unaryOperator.andThen(unaryOperator1);
        String crisss = function.apply("crisss");
        System.out.println(crisss);

    }
}

abstract class Chain {

    public Chain chain;

    public void setChain(Chain chain) {
        this.chain = chain;
    }

    public String handle(String str) {
        String s = this.handleConcrete(str);
        if (s != null && this.chain != null) {
            s = this.chain.handleConcrete(s);
        }
        return s;
    }

    abstract String handleConcrete(String string);
}
/*class ChainA extends Chain{

    @Override
    String handleConcrete(String string) {
        return string.replace("s", "a");
    }
}
class ChainB extends Chain{

    @Override
    String handleConcrete(String string) {
        return string.toUpperCase();
    }
}*/


