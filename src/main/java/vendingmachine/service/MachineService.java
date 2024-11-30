package vendingmachine.service;

import vendingmachine.repository.MachineRepository;

public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public void inputMachineMoney(String input) {
        machineRepository.saveMachineMoney(input);
    }

    public String getMachineCoinSummery() {
        return machineRepository.getMachine().getMachineCoinSummery();
    }
}
