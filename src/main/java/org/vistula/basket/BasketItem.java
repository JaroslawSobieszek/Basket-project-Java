package org.vistula.basket;

public class BasketItem {

    String name;
    private float price;
    private boolean ageRestrictedItem;

    public BasketItem() {
    }

    public BasketItem(String name, float price, boolean ageRestrictedItem) {
        this.name = name;
        this.price = price;
        this.ageRestrictedItem = ageRestrictedItem;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float price) {

        this.price = price;
    }

    public boolean isAgeRestrictedItem() {

        return ageRestrictedItem;
    }

    public void setAgeRestrictedItem(boolean ageRestrictedItem) {
        this.ageRestrictedItem = ageRestrictedItem;
    }
}
