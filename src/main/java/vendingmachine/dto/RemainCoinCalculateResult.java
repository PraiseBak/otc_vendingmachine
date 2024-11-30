package vendingmachine.dto;

import java.util.Map;
import vendingmachine.domain.Coin;

public class RemainCoinCalculateResult {
    private Map<Coin, Integer> coinMap;
    private int remainMoney;

    public RemainCoinCalculateResult(Map<Coin, Integer> coinMap, int remainMoney) {
        this.coinMap = coinMap;
        this.remainMoney = remainMoney;
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }

    public int getRemainMoney() {
        return remainMoney;
    }
}
