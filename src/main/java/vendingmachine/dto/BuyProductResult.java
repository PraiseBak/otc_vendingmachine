package vendingmachine.dto;

public class BuyProductResult {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public BuyProductResult(String result, boolean isEnd) {
        this.result = result;
        this.isEnd = isEnd;
    }

    private String result;
    private boolean isEnd;
}
