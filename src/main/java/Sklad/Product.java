package Sklad;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private String name;
    private String lastSalePrice;
    private String lastPurchasePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(String lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    public String getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public void setLastPurchasePrice(String lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
    }
}
