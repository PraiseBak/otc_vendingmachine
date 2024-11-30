package vendingmachine.domain;

import vendingmachine.exception.MachineException;
import vendingmachine.utility.NumberUtility;

public class Product {
    private static final String INVALID_PRODUCT_INFO = "유효하지 않은 상품 정보입니다.";
    private final String name;
    private int amount;
    private final int price;

    public Product(String name,String moneyInput,String amountInput) {
        validateProduct(name,amountInput,moneyInput);
        this.name = name;
        this.amount = Integer.parseInt(amountInput);
        this.price = Integer.parseInt(moneyInput);
    }

    private void validateProduct(String name, String amountInput, String moneyInput) {
        if(name == null || name.isEmpty()){
            throw new MachineException(INVALID_PRODUCT_INFO);
        }
        if(!NumberUtility.isNumber(amountInput) || !NumberUtility.isPositive(Integer.parseInt(amountInput))){
            throw new MachineException(INVALID_PRODUCT_INFO);
        }
        if(!NumberUtility.isNumber(moneyInput) || !NumberUtility.isPositive(Integer.parseInt(moneyInput))){
            throw new MachineException(INVALID_PRODUCT_INFO);
        }
    }

    public boolean isSameName(String inputBuyProductName) {
        if(inputBuyProductName.equals(name)){
            return true;
        }
        return false;
    }

    public boolean isBuyable(int leftMoney) {
        if(price <= leftMoney){
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return amount == 0;
    }

    public int getPrice() {
        return price;
    }

    public void buy() {
        amount--;
    }
}
