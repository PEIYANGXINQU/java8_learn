package chapter12_新的时间API;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName ParseDateTime
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ParseDateTime {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2013, 11, 11);
        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format1 = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(format + "----" + format1);
        LocalDate parse = LocalDate.parse("20181106", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse1 = LocalDate.parse("2018-12-04", DateTimeFormatter.ISO_DATE);
        System.out.println(parse + "-----" + parse1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format2 = localDate.format(dateTimeFormatter);
        System.out.println(format2);
        LocalDate parse2 = LocalDate.parse(format2, dateTimeFormatter);
        System.out.println(parse2);
    }


}

