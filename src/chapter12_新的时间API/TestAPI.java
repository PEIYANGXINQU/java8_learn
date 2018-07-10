package chapter12_新的时间API;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @ClassName TestAPI
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestAPI {

    public static void main(String[] args) {

/*        LocalDate date = LocalDate.of(2018, 7, 9);
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println( date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());

        LocalDate date1 =LocalDate.now();
        System.out.println(date1);*/

/*        LocalTime time = LocalTime.of(12, 12,12);
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());*/

        LocalTime time = LocalTime.parse("11:11:11");
        LocalDate date = LocalDate.parse("2018-11-11");
        // 合并时间和日期的多种方式
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.AUGUST, 18, 12, 12, 12);
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        LocalDateTime localDateTime = date.atTime(time);
        LocalDateTime localDateTime1 = date.atTime(12, 23, 23);
        LocalDateTime localDateTime2 = time.atDate(date);

        // 从localtime 对象获取日期或者时间
      /*  LocalDate date1 = dateTime.toLocalDate();
        LocalTime time1 = dateTime.toLocalTime();

        Duration between = Duration.between(time, time1);
        Duration between1 = Duration.between(localDateTime, localDateTime1);

        Period between2 = Period.between(LocalDate.of(2018,11,11) , LocalDate.of(2018,11,15));
        System.out.println(between2.getDays());

        // 自定义创建Duration或者Period 对象
        Duration threeMills = Duration.ofMillis(40);
        Duration threeMills2 = Duration.of(3, ChronoUnit.MILLIS);

        Period tendays = Period.ofDays(10);
        Period threeweeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);*/

        // 线程安全的修改日期(不会修改原来的日期对象，而是修改新的副本)
       /* LocalDate localDate = LocalDate.of(2014, 11, 11);
        LocalDate localDate1 = localDate.withYear(2018);
        LocalDate localDate2 = localDate.withMonth(12);
        LocalDate localDate3 = localDate.withDayOfMonth(12);

        // 日期前进或者回滚
        LocalDate localDate4 = localDate.plusDays(12);
        LocalDate localDate5 = localDate.plusWeeks(3);
        LocalDate localDate6 = localDate.minusMonths(2);
        LocalDate localDate7 = localDate.minus(4, ChronoUnit.MONTHS);
        System.out.println(localDate7);
*/
        // 更加复杂的计算日期的方式
        LocalDate localDate = LocalDate.of(2018, 7, 14);
        LocalDate with = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate.get(ChronoField.DAY_OF_WEEK));

        // 方式1
        LocalDate localDate1 = localDate.with(new MyTemporalAdjuster());
        System.out.println(localDate1);
        // 方式2
        LocalDate localDate2 = localDate.with(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int day = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) day = 3;
            else if (dayOfWeek == DayOfWeek.SATURDAY) day = 2;
            return temporal.plus(day, ChronoUnit.DAYS);
        });
        System.out.println(localDate2);
        // 方式3
        TemporalAdjuster temporalAdjuster = temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int day = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) day = 3;
            else if (dayOfWeek == DayOfWeek.SATURDAY) day = 2;
            return temporal.plus(day, ChronoUnit.DAYS);
        };
        LocalDate localDate3 = localDate.with(temporalAdjuster);
        System.out.println(localDate3);


    }


}
