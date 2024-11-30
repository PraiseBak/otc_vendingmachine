package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Coin, Integer> getCalculatedMachineLeftCoinMapByLeftMoney(int leftMoney) {
        int curMoney = 0;
        Map<Coin,Integer> calculateMap = new HashMap<>();
        for(Coin coin : getDescSortedCoin()){
            int coinMoney = coin.getAmount();
            int count = 0;
            while (curMoney + coinMoney <= leftMoney){
                curMoney += coinMoney;
                count++;
            }
            calculateMap.put(coin,count);
        }
        return calculateMap;
    }

    public static Map<Coin, Integer> getCalculatedMachineLeftCoinMapByRandom(int leftMoney) {
        List<Integer> amountList = new ArrayList<>();
        int[] amountArr = Coin.getAmountArr();
        for (int i = 0; i < amountArr.length; i++) {
            amountList.add(amountArr[i]);
        }
        int curMoney = 0;
        Map<Coin,Integer> calculateMap = new HashMap<>();
        while (curMoney != leftMoney){
            int amount = Randoms.pickNumberInList(amountList);
            if(amount + curMoney <= leftMoney){
                curMoney += amount;
            }
            Coin coinByAmount = Coin.getCoinByAmount(amount);
            calculateMap.put(coinByAmount,calculateMap.getOrDefault(coinByAmount,0)+1);
        }
        return calculateMap;
    }
}