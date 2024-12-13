package oncall;

import static java.util.Collections.frequency;
import static java.util.Collections.unmodifiableList;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WorkOrder {

    List<String> weekdays;
    List<String> weekend;

    public WorkOrder(List<String> weekdays, List<String> weekend) {
        validateWorkOrder(weekdays, weekend);
        this.weekdays = weekdays;
        this.weekend = weekend;
    }

    private void validateWorkOrder(List<String> weekdays, List<String> weekend) {
        checkDuplicatedName(weekdays);
        checkDuplicatedName(weekend);
        checkNameLength(weekdays);
        checkNameLength(weekend);
        checkSameWorkers(weekdays, weekend);
        checkWorkersNumber(weekdays);
    }

    private void checkDuplicatedName(List<String> workOrder) {
        for (String name : workOrder) {
            if (frequency(workOrder, name) != 1) {
                throw new IllegalArgumentException("닉네임은 중복될 수 없습니다");
            }
        }
    }

    private void checkNameLength(List<String> workOrder) {
        for (String name : workOrder) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("닉네임은 최대 5자로 유지해주시기 바랍니다");
            }
        }
    }

    private void checkSameWorkers(List<String> weekdays, List<String> weekend) {
        Set<String> weekdaysWorkers = new HashSet<>(weekdays);
        Set<String> weekendWorkers = new HashSet<>(weekend);
        if (!Objects.equals(weekdaysWorkers, weekendWorkers)) {
            throw new IllegalArgumentException("평일 및 휴일 근무자가 동일하지 않습니다");
        }
    }

    private void checkWorkersNumber(List<String> workOrder) {
        if (!(5 <= workOrder.size() && workOrder.size() <= 35)) {
            throw new IllegalArgumentException("비상 근무자는 최소 5명, 최대 35명까지 관리해주시기 바랍니다");
        }
    }

    public List<String> getWeekdays() {
        return unmodifiableList(weekdays);
    }

    public List<String> getWeekend() {
        return unmodifiableList(weekend);
    }
}
