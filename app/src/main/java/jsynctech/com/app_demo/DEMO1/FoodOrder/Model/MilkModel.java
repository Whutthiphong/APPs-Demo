package jsynctech.com.app_demo.DEMO1.FoodOrder.Model;

import jsynctech.com.app_demo.DEMO1.FoodOrder.FoodBaseItem;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewType;

public class MilkModel extends FoodBaseItem {

    private int salePrice;
    private String productName;
    private String productDesc;
    private int amount;

    public MilkModel() {
        super(ViewType.MILK_TYPE);
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
