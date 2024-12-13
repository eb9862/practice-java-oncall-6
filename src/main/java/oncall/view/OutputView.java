package oncall.view;

public class OutputView extends View {

    private static final String ERROR_MESSAGE_TAG = "[ERROR] ";

    public static void printErrorMessage(String errorMessage) {
        printMessage(ERROR_MESSAGE_TAG + errorMessage);
    }
}
