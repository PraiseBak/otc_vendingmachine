package vendingmachine.domain;

import vendingmachine.dto.BuyProductResult;
import vendingmachine.service.MachineService;

public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    public String inputMachineMoney(String input) {
        machineService.inputMachineMoney(input);
        return machineService.getMachineCoinSummery();
    }

    public void inputMachineProduct(String productRequest) {

        machineService.initProduct(productRequest);
    }

    public void inputProductBuyMoney(String inputBuyMoney) {
        machineService.initProductBuyMoney(inputBuyMoney);
    }

    public int buyProduct(String inputBuyProductName) {
        return machineService.buyProduct(inputBuyProductName);
    }

    public BuyProductResult isBuyAble() {
        if(!machineService.isBuyAble()){
            return machineService.getRemainCoinSummery();
        }
        return new BuyProductResult("",false);

    }

    public int getRemainMoney() {
        return machineService.getRemainProductBuyMoney();
    }
}
