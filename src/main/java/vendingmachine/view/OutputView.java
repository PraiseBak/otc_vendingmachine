package vendingmachine.view;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR] ";
    private static final String REMAIN_BUY_PRODUCT_MONEY_FORMAT = "투입 금액: %d원";
    private static final String REMAIN_PRODUCT_MONEY = "잔돈";
    private static final String REMAIN_MACHINE_COIN = "자판기가 보유한 동전";

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printRemainBuyProductMoney(int remainMoney) {
        String format = String.format(REMAIN_BUY_PRODUCT_MONEY_FORMAT, remainMoney);
        println(format);
    }

    public static void printRemainProductBuyMoney(){
        println(REMAIN_PRODUCT_MONEY);
    }

    public static void printMachineCoin(){
        println(REMAIN_MACHINE_COIN);
    }
}
