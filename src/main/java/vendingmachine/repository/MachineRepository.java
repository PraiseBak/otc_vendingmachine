package vendingmachine.repository;

import java.util.List;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Products;
import vendingmachine.domain.Product;

public class MachineRepository {
    private Machine machine = null;
    private Products products;
    private int productBuyMoney;

    public void saveMachineMoney(String input) {
        machine = new Machine(input);
    }

    public Machine getMachine() {
        return machine;
    }

    public void saveProducts(List<Product> products) {
        this.products = new Products(products);
    }

    public void setProductBuyMoney(int productBuyMoney) {
        this.productBuyMoney = productBuyMoney;
    }

    public Products getProducts() {
        return products;
    }

    public int getLeftMoney() {
        return productBuyMoney;
    }

    public void updateLeftMoney(int price) {
        productBuyMoney -= price;
    }
}
