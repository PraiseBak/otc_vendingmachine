package vendingmachine.repository;

import vendingmachine.domain.Machine;

public class MachineRepository {
    private Machine machine = null;
    public void saveMachineMoney(String input) {
        machine = new Machine(input);
    }

    public Machine getMachine() {
        return machine;
    }
}
