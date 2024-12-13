package oncall.view;

import static oncall.view.Constant.INPUT_MESSAGE_FOR_START_MONTH_AND_DAY;
import static oncall.view.Constant.INPUT_MESSAGE_FOR_WEEKDAYS_WORK_ORDER;
import static oncall.view.Constant.INPUT_MESSAGE_FOR_WEEKEND_WORK_ORDER;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    public static String readStartMonthAndDay() {
        printMessage(INPUT_MESSAGE_FOR_START_MONTH_AND_DAY);
        return Console.readLine();
    }

    public static String readWeekdaysWorkOrder() {
        printMessage(INPUT_MESSAGE_FOR_WEEKDAYS_WORK_ORDER);
        return Console.readLine();
    }

    public static String readWeekendWorkOrder() {
        printMessage(INPUT_MESSAGE_FOR_WEEKEND_WORK_ORDER);
        return Console.readLine();
    }
}
