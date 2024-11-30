package vendingmachine.view;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR] ";

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
