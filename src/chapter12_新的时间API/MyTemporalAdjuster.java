package chapter12_新的时间API;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @ClassName MyTemporalAdjuster
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class MyTemporalAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        int i = temporal.get(ChronoField.DAY_OF_WEEK);
        int number = 1;
        if (i == 5) {
            number = 3;
        } else if (i == 6) {
            number = 2;
        }
        return temporal.plus(number, ChronoUnit.DAYS);
    }
}
