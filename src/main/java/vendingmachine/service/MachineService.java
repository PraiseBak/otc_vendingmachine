package vendingmachine.service;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Products;
import vendingmachine.dto.BuyProductResult;
import vendingmachine.domain.Product;
import vendingmachine.exception.MachineException;
import vendingmachine.repository.MachineRepository;
import vendingmachine.utility.NumberUtility;

public class MachineService {
    private final MachineRepository machineRepository;
    private static final String PRODUCT_IS_EMPTY = "상품이 모두 팔렸습니다.";
    private static final String THIS_MONEY_CANNOT_BUY_THIS_PRODUCT = "이 금액으로 해당 제품을 살 수 없습니다.";
    private static final String INVALID_PRODUCT_BUY_NUMBER = "유효하지 않은 투입 금액입니다.";

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public void inputMachineMoney(String input) {
        machineRepository.saveMachineMoney(input);
    }

    public String getMachineCoinSummery() {
        return machineRepository.getMachine().getMachineCoinSummery();
    }

    public void initProduct(String productRequest) {
        productRequest = productRequest.replace("[","").replace("]","");
        String[] productArr = productRequest.split(";");
        List<Product> products = new ArrayList<>();
        for(String product: productArr){
            String[] productInfoArr = product.split(",");
            products.add(new Product(productInfoArr[0], productInfoArr[1], productInfoArr[2]));
        }
        machineRepository.saveProducts(products);
    }

    public void initProductBuyMoney(String inputBuyMoney) {
        validateProductBuyMoney(inputBuyMoney);
        machineRepository.setProductBuyMoney(Integer.parseInt(inputBuyMoney));
    }

    private void validateProductBuyMoney(String inputBuyMoney) {
        if (!NumberUtility.isNumber(inputBuyMoney) || !NumberUtility.isPositive(Integer.parseInt(inputBuyMoney))) {
            throw new MachineException(INVALID_PRODUCT_BUY_NUMBER);
        }
    }

    public int buyProduct(String inputBuyProductName) {
        Products products = machineRepository.getProducts();
        Product product = products.getProductByName(inputBuyProductName);
        Machine machine = machineRepository.getMachine();
        int leftMoney = machineRepository.getLeftMoney();
        validateBuyProduct(product,leftMoney);
        int price = product.getPrice();
        machineRepository.updateLeftMoney(price);
        machine.addRemainMoney(product.getPrice());
        product.buy();
        return leftMoney - price;
    }

    private void validateBuyProduct(Product product, int leftMoney) {
        if(!product.isBuyable(leftMoney)){
            throw new MachineException(THIS_MONEY_CANNOT_BUY_THIS_PRODUCT);
        }
        if(product.isEmpty()){
            throw new MachineException(PRODUCT_IS_EMPTY);
        }
    }

    public boolean isBuyAble() {
        int leftMoney = machineRepository.getLeftMoney();
        Products products = machineRepository.getProducts();
        return products.isBuyAbleSomething(leftMoney);
    }

    public BuyProductResult getRemainCoinSummery() {
        Machine machine = machineRepository.getMachine();
        int leftMoney = machineRepository.getLeftMoney();
        return new BuyProductResult(machine.getMachineRemainCoinSummery(leftMoney),true);
    }

    public int getRemainProductBuyMoney() {
        int leftMoney = machineRepository.getLeftMoney();
        return leftMoney;
    }
}
