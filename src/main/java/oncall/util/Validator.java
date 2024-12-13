package oncall.util;

import java.util.ArrayList;
import java.util.List;
import oncall.MonthInfo;

public class Validator {

    private static final String INVALID_INPUT = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    public static void validateStartMonthAndDay(String inputForStartMonthAndDay) {
        List<String> startMonthAndDay = removeBlank(inputForStartMonthAndDay.split(","));
        checkSize(startMonthAndDay);
        validateStartMonth(startMonthAndDay.getFirst());
        validateStartDay(startMonthAndDay.getLast());
    }

    public static void checkSize(List<String> startMonthAndDay) {
        if (startMonthAndDay.size() != 2) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static void validateStartMonth(String month) {
        try {
            int monthInput = Integer.parseInt(month);
            if (!isValidMonth(monthInput)) {
                throw new IllegalArgumentException(INVALID_INPUT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
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

    public static void validateStartDay(String day) {
        if (!isValidDay(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    static boolean isValidDay(String day) {
        List<String> dayOfTheWeek = List.of("일", "월", "화", "수", "목", "금", "토");
        return dayOfTheWeek.contains(day);
    }

    public static List<String> removeBlank(String[] startMonthAndDayInput) {
        List<String> startMonthAndDay = new ArrayList<>();
        for (String element : startMonthAndDayInput) {
            String strippedElement = element.strip();
            startMonthAndDay.add(strippedElement);
        }
        return startMonthAndDay;
    }
}
