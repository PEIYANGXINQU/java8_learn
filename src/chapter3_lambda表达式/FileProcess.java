package chapter3_lambda表达式;

import java.io.*;

public class FileProcess {

    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");
        String s = fileProcess(file);
        System.out.println(s);

        /*使用改进后的方法完成各种读取需求*/
        String s1 = fileProcessByLambda(file, (x) -> x.readLine());
        System.out.println("--------------");
        System.out.println(s1);
        /*我想读取两行文本*/
        String s2 = fileProcessByLambda(file, (x) -> {
            return x.readLine() +"++++++" + x.readLine();
        });
        System.out.println(s2);

    }

    /*如果我们想要读取两行,三行文字呢?,对一个资源有不同的行为意图,表示我们可以将这种意图参数化(策略化),首要想到使用lambda+函数式接口 */
    public static String fileProcess(File file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String s = bufferedReader.readLine();
            return s;
        }
    }

    /*改进：将文件读取的逻辑抽取为函数式接口，读取文件过程中的开启流，关闭流等重复操作将其固定，变化的部分抽取出来使用lambda实现*/
    public static String fileProcessByLambda(File file, MyFunctionInterface myFunctionInterface) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            return myFunctionInterface.process(bufferedReader);
        }
    }

}
