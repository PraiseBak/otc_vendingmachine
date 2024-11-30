package vendingmachine.domain;

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
}
