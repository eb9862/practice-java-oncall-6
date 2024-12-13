package oncall;

import java.util.List;

public class WorkOrder {

    List<String> weekdays;
    List<String> weekend;

    public WorkOrder(List<String> weekdays, List<String> weekend) {
        validateWorkOrder(weekdays, weekend);
        this.weekdays = weekdays;
        this.weekend = weekend;
    }

    private void validateWorkOrder(List<String> weekdays, List<String> weekend) {

    }
}
