package oncall;

import static oncall.util.Validator.checkSize;
import static oncall.util.Validator.removeBlank;
import static oncall.util.Validator.validateStartDay;
import static oncall.util.Validator.validateStartMonth;
import static oncall.view.InputView.readStartMonthAndDay;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputForStartMonthAndDay = readStartMonthAndDay();
        validateStartMonthAndDay(inputForStartMonthAndDay);
    }

    private static void validateStartMonthAndDay(String inputForStartMonthAndDay) {
        List<String> startMonthAndDay = removeBlank(inputForStartMonthAndDay.split(","));
        checkSize(startMonthAndDay);
        validateStartMonth(startMonthAndDay.getFirst());
        validateStartDay(startMonthAndDay.getLast());
    }

}
