package oncall;

import static oncall.view.InputView.readStartMonthAndDay;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputForStartMonthAndDay = readStartMonthAndDay();
        validateStartMonthAndDay(inputForStartMonthAndDay);
    }

    private static void validateStartMonthAndDay(String inputForStartMonthAndDay) {
        List<String> startMonthAndDay = List.of(inputForStartMonthAndDay.split(","));
        checkSize(startMonthAndDay);
        validateStartMonth(startMonthAndDay.getFirst());

    }

    static void checkSize(List<String> startMonthAndDay) {
        if (startMonthAndDay.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    static void validateStartMonth(String month) {
        try {
            int monthInput = Integer.parseInt(month);
            if (!isValidMonth(monthInput)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    static boolean isValidMonth(int monthInput) {
        for (MonthInfo monthInfo : MonthInfo.values()) {
            if (monthInfo.getMonth() == monthInput) {
                return true;
            }
        }
        return false;
    }
}
