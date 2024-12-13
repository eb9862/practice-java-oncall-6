package oncall.util;

import static oncall.util.Validator.removeBlank;

import java.util.List;
import oncall.StartingDay;

public class Parser {

    public static StartingDay parseStartingDay(String inputForStartMonthAndDay) {
        List<String> startMonthAndDay = removeBlank(inputForStartMonthAndDay.split(","));
        String startMonth = startMonthAndDay.getFirst();
        String startDay = startMonthAndDay.getLast();
        return new StartingDay(Integer.parseInt(startMonth), startDay);
    }
}
