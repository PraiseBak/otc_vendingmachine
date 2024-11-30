package vendingmachine.domain;

import java.util.Map;

public class MachineFormatter {
    private final static String MACHINE_COIN_SUMMERY = "자판기가 보유한 동전";
    private final static String MACHINE_COIN_SUMMERY_FORMAT = "%d원 - %d개";

    public static String getMachineCoinSummery(Map<Coin, Integer> leftCoin) {
        StringBuilder stringBuilder = new StringBuilder(MACHINE_COIN_SUMMERY);
        for(Coin coin : leftCoin.keySet()){
            String coinSummery = String.format(MACHINE_COIN_SUMMERY_FORMAT, coin.getAmount(), leftCoin.get(coin));
            stringBuilder.append(coinSummery).append("\n");
        }
        return stringBuilder.toString();
    }
}
