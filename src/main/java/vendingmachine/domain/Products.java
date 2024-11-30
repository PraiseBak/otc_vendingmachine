package vendingmachine.domain;

import java.util.List;
import vendingmachine.exception.MachineException;

public class Products {
    private static final String NOT_EXISTS_PRODUCT = "유효하지 않은 상품명입니다.";
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public Product getProductByName(String inputBuyProductName) {
        for(Product product : products){
            if(product.isSameName(inputBuyProductName)){
                return product;
            }
        }

        throw new MachineException(NOT_EXISTS_PRODUCT);
    }

    public boolean isBuyAbleSomething(int leftMoney) {
        for(Product product : products){
            if(product.isBuyable(leftMoney) && !product.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
