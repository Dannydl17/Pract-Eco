package EcommerceApp;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public Item() {
    }

    public Item(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
