package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.dto.RemainCoinCalculateResult;

public class CoinCalculator {
    private CoinCalculator(){

    }

    public static void getCalculatedMachineLeftCoinMapByLeftMoney() {
    }

    public static Coin[] getDescSortedCoin(){
        Coin[] values = Coin.values();
        Arrays.sort(values,(o1,o2) -> Coin.compareAmount(o2,o1));
        return values;
    }

    public static RemainCoinCalculateResult getCalculatedMachineLeftCoinMapByLeftMoney(int leftMoney, Map<Coin, Integer> curCoinMap) {
        int curMoney = 0;
        Map<Coin,Integer> calculateMap = new HashMap<>();
        for(Coin coin : getDescSortedCoin()){
            Integer curCoinLeft = curCoinMap.get(coin);
            int coinMoney = coin.getAmount();
            int count = 0;
            while (curMoney + coinMoney <= leftMoney && curCoinLeft != 0){
                curMoney += coinMoney;
                curCoinLeft--;
                count++;
            }
            calculateMap.put(coin,count);
        }
        return new RemainCoinCalculateResult(calculateMap,leftMoney - curMoney);
    }

    public static Map<Coin, Integer> getCalculatedMachineLeftCoinMapByRandom(int leftMoney) {
        List<Integer> amountList = getAmountList();
        int curMoney = 0;
        Map<Coin,Integer> calculateMap = new HashMap<>();
        while (curMoney != leftMoney){
            int amount = Randoms.pickNumberInList(amountList);
            if(amount + curMoney > leftMoney){
                continue;
            }
            curMoney += amount;
            Coin coinByAmount = Coin.getCoinByAmount(amount);
            calculateMap.put(coinByAmount,calculateMap.getOrDefault(coinByAmount,0)+1);
        }
        return calculateMap;
    }

    private static List<Integer> getAmountList() {
        List<Integer> amountList = new ArrayList<>();
        int[] amountArr = Coin.getAmountArr();
        for (int i = 0; i < amountArr.length; i++) {
            amountList.add(amountArr[i]);
        }
        return amountList;
    }
}