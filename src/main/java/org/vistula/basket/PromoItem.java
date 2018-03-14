package org.vistula.basket;

public class PromoItem extends BasketItem {

    private double discountPrice = 0.8;

    public PromoItem(String name, float price, boolean ageRestrictedItem, double discountPrice) {
        super (name, price, ageRestrictedItem);
        this.discountPrice = discountPrice;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }
    public double usePromotion (PromoItem item){
        System.out.println("Przyznano zniżkę 20%");
        System.out.println("Aktualna cena wynosi " + ((double)item.getPrice()*getDiscountPrice()));
        return ((double)item.getPrice()*getDiscountPrice());

    }
}
