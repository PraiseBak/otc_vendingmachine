package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.MachineException;

public class InputView {
    private static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.\n";
    private static final String INVALID_PRODUCT_MESSAGE = "유효하지 않은 상품입니다.";
    private static final String INPUT_MACHINE_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_BUY_MONEY = "투입 금액을 입력해 주세요.";
    private static final String INPUT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static String inputMachineMoney() {
        OutputView.println(INPUT_MACHINE_MONEY);
        return readLine();
    }

    public static String readLine(){
        return Console.readLine();
    }

    public static String inputMachineProduct() {
        OutputView.println(INPUT_MACHINE_PRODUCT);
        String input = readLine();
        validateMachineProduct(input);
        return input;
    }

    private static void validateMachineProduct(String input) {
        String[] productArr = input.split(";");
        if(productArr.length == 0){
            throw new MachineException(INVALID_PRODUCT_MESSAGE);
        }
        for(String product : productArr){
            if(product.split(",").length != 3){
                throw new MachineException(INVALID_PRODUCT_MESSAGE);
            }
        }
    }

    public static String inputProductBuyRequest() {
        OutputView.println(INPUT_BUY_MONEY);
        return readLine();
    }

    public static String inputBuyProduct() {
        OutputView.println(INPUT_BUY_PRODUCT);
        return readLine();
    }
}

