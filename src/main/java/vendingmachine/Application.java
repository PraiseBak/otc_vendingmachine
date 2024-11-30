package vendingmachine;

import vendingmachine.domain.MachineController;
import vendingmachine.exception.MachineException;
import vendingmachine.repository.MachineRepository;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    private final static MachineController machineController = new MachineController(new MachineService(new MachineRepository()));
    public static void main(String[] args) {
        inputMachineMoney();

    }

    private static String inputMachineMoney() {
        while (true){
            try{
                String input = InputView.inputMachineMoney();
                OutputView.println(machineController.inputMachineMoney(input));
            }catch (MachineException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
}
