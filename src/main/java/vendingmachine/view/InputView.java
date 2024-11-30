package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.\n";
    private static final String INVALID_METHOD_MESSAGE = "유효하지 않은 기능입니다.";

    public static String inputMachineMoney() {
        OutputView.println(INPUT_MACHINE_MONEY);
        return readLine();
    }

    public static String readLine(){
        return Console.readLine();
    }
}

