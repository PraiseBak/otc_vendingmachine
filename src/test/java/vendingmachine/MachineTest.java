package vendingmachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.Machine;

public class MachineTest {
    @Test
    void 잔돈_숫자_아닌경우(){
        assertThatThrownBy(() -> {
            new Machine("asdf");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잔돈_10으로나눠지지않는_경우(){
        assertThatThrownBy(() -> {
            new Machine("101");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잔돈_음수인_경우(){
        assertThatThrownBy(() -> {
            new Machine("-10");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
