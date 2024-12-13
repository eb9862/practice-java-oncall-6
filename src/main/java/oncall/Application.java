package oncall;

import static oncall.util.Parser.parseStartingDay;
import static oncall.util.Validator.validateStartMonthAndDay;
import static oncall.view.InputView.readStartMonthAndDay;
import static oncall.view.OutputView.printErrorMessage;

public class Application {
    public static void main(String[] args) {
        StartingDay startingDay = inputForStartingDay();
    }

    private static StartingDay inputForStartingDay() {
        while (true) {
            try {
                String inputForStartMonthAndDay = readStartMonthAndDay();
                validateStartMonthAndDay(inputForStartMonthAndDay);
                return parseStartingDay(inputForStartMonthAndDay);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }
}
