package org.vistula.customer;

import org.vistula.basket.BasketItem;
import org.vistula.basket.PromoItem;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private int age;
    private List<BasketItem> basket;

    public Customer() {

    }

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        basket = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BasketItem> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketItem> basket) {
        this.basket = basket;
    }

    public boolean isAdult() {

        if (age >= 18) {
            System.out.println("Masz co najmniej 18 lat, zapraszamy do zakupów!");
            return true;
        } else {
            System.out.println("Nie ukończyłeś 18 lat, zakupy mogą robić wyłącznie osoby pełnoletnie!");
            return false;
        }
    }

    public float getTotalBasketPrice() {
        float sum = 0;
        for (int i = 0; i < basket.size(); i++)
            sum += basket.get(i).getPrice();
        return sum;
    }

    public void addItemToBasket(BasketItem item) {
        if (item.isAgeRestrictedItem() == true)
            if (this.age < 18)
                System.out.println("Ponieważ masz mniej niż 18 lat, nie możesz kupić tej rzeczy");
            else {
                basket.add(item);
                System.out.println("Dodano produkt do koszyka");
            }
        else {
            basket.add(item);
            System.out.println("Dodano produkt do koszyka");

        }

    }

    public void addItemToBasket(PromoItem item) {
        if (item.isAgeRestrictedItem() == true)
            if (this.age <18)
                System.out.println("Masz mniej niż 18 lat, nie możesz kupić tej rzeczy");
        else{
            basket.add(item);
                System.out.println("Dodano rzecz do koszyka");
            }
        }
     public void currentBasket(){
        for (int i=0; i<basket.size(); i++)
            System.out.println("Masz w koszyku: " + basket.get(i).getName());
     }

     public void removeItemFromBasket(BasketItem item) {
         basket.remove(item);
         System.out.println("Usunięto rzecz z koszyka");

     }

}