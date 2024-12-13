package oncall;

import static oncall.util.Parser.parseStartingDay;
import static oncall.util.Validator.removeBlank;
import static oncall.util.Validator.validateStartMonthAndDay;
import static oncall.view.InputView.readStartMonthAndDay;
import static oncall.view.InputView.readWeekdaysWorkOrder;
import static oncall.view.InputView.readWeekendWorkOrder;
import static oncall.view.OutputView.printErrorMessage;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        StartingDay startingDay = inputForStartingDay();
        WorkOrder workorder = inputWorkOrder();
    }

    private static WorkOrder inputWorkOrder() {
        while (true) {
            try {
                String weekdaysWorkOrderInput = readWeekdaysWorkOrder();
                String weekendWorkOrderInput = readWeekendWorkOrder();
                List<String> weekdaysWorkOrder = parseWorkOrderInput(weekdaysWorkOrderInput);
                List<String> weekendWorkOrder = parseWorkOrderInput(weekendWorkOrderInput);
                return new WorkOrder(weekdaysWorkOrder, weekendWorkOrder);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static List<String> parseWorkOrderInput(String workOrderInput) {
        String[] workOrder = workOrderInput.split(",");
        return removeBlank(workOrder);
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
