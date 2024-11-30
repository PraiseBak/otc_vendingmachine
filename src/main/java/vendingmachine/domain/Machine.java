package vendingmachine.domain;

import java.util.Map;
import vendingmachine.dto.RemainCoinCalculateResult;
import vendingmachine.exception.MachineException;
import vendingmachine.utility.NumberUtility;

public class Machine {
    private static final int MIN_MONEY_UNIT = 10;
    private final Map<Coin,Integer> leftCoin;
    private int insideMoney;
    private final static String INVALID_LEFT_COIN_MONEY = "유효하지 않은 자판기 보유 금액입니다.";

    public Machine(String leftMoney){
        validateMoney(leftMoney);
        this.insideMoney = 0;
        this.leftCoin = CoinCalculator.getCalculatedMachineLeftCoinMapByRandom(Integer.parseInt(leftMoney));
        initCoinMap();
    }

    private void initCoinMap() {
        for(Coin coin : Coin.values()){
            if(leftCoin.get(coin) == null){
                leftCoin.put(coin,0);
            }
        }
    }

    private void validateMoney(String leftMoneyInput) {
        if(!NumberUtility.isNumber(leftMoneyInput)){
            throw new MachineException(INVALID_LEFT_COIN_MONEY);
        }
        int leftMoney = Integer.parseInt(leftMoneyInput);
        if(!NumberUtility.isPositive(leftMoney)){
            throw new MachineException(INVALID_LEFT_COIN_MONEY);
        }
        if(leftMoney % MIN_MONEY_UNIT != 0){
            throw new MachineException(INVALID_LEFT_COIN_MONEY);
        }
    }

    public String getMachineCoinSummery(){
        return MachineFormatter.getMachineCoinSummery(leftCoin);
    }

    public void addRemainMoney(int price) {
        insideMoney += price;
    }

    public String getMachineRemainCoinSummery(int leftMoney) {
        RemainCoinCalculateResult calculatedMachineLeftCoinMapByLeftMoney = CoinCalculator.getCalculatedMachineLeftCoinMapByLeftMoney(leftMoney, leftCoin);
        return MachineFormatter.getMachineCoinSummery(calculatedMachineLeftCoinMapByLeftMoney.getCoinMap());
    }
}
