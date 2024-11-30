package vendingmachine.domain;

public enum Coin{
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public static int[] getAmountArr(){
        Coin[] coins = Coin.values();
        int[] amountArr = new int[coins.length];

        for(int i=0;i<coins.length;i++ ){
            amountArr[i] = coins[i].amount;
        }
        return amountArr;
    }

    public static int compareAmount(Coin object,Coin object2){
        return object.amount - object2.amount;
    }

    public static Coin getCoinByAmount(int amount){
        for(Coin coin : Coin.values()){
            if(amount == coin.getAmount()){
                return coin;
            }
        }
        return null;
    }
}