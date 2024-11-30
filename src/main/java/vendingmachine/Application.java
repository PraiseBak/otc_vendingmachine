package vendingmachine;

import vendingmachine.domain.MachineController;
import vendingmachine.dto.BuyProductResult;
import vendingmachine.exception.MachineException;
import vendingmachine.repository.MachineRepository;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    private final static MachineController machineController = new MachineController(new MachineService(new MachineRepository()));
    public static void main(String[] args) {
        inputMachineMoney();
        inputMachineProduct();
        inputBuyProductMoney();
        inputBuyProduct();
    }

    private static void inputBuyProduct() {
        boolean isEnd = false;
        BuyProductResult buyAble = null;
        while (!isEnd){
            try {
                int remainMoney = machineController.getRemainMoney();
                OutputView.printRemainBuyProductMoney(remainMoney);
                buyAble = machineController.isBuyAble();
                isEnd = buyAble.isEnd();
                buyProductIfNotEnd(isEnd);
            }catch (MachineException e){
                OutputView.printError(e.getMessage());
            }
        }
        OutputView.println(buyAble.getResult());
    }

    private static void buyProductIfNotEnd(boolean isEnd) {
        if(isEnd){
            return;
        }
        String inputBuyProduct = InputView.inputBuyProduct();
        machineController.buyProduct(inputBuyProduct);
    }

    private static void inputBuyProductMoney() {
        while (true){
            try{
                String inputBuyMoney = InputView.inputProductBuyRequest();
                machineController.inputProductBuyMoney(inputBuyMoney);
                return;
            }catch (MachineException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void inputMachineProduct() {
        while (true){
            try{
                String productRequest = InputView.inputMachineProduct();
                machineController.inputMachineProduct(productRequest);
                return;
            }catch (MachineException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void inputMachineMoney() {
        while (true){
            try{
                String input = InputView.inputMachineMoney();
                OutputView.printMachineCoin();
                OutputView.println(machineController.inputMachineMoney(input));
                return ;
            }catch (MachineException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
}
