package oncall.view;

import static oncall.view.Constant.INPUT_MESSAGE_FOR_START_MONTH_AND_DAY;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    public static String readStartMonthAndDay() {
        printMessage(INPUT_MESSAGE_FOR_START_MONTH_AND_DAY);
        return Console.readLine();
    }
}
