package org.vistula.customer;

import org.junit.Test;
import org.vistula.basket.BasketItem;
import org.vistula.basket.PromoItem;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CustomerTest {

    @Test
    public void VerifyAge() {
        Customer Maciek = new Customer();
        Maciek.setAge(18);
        assert Maciek.isAdult();
    }

    @Test
    public void VerifyAge2() {
        Customer Aneta = new Customer();
        Aneta.setAge(19);
        assertThat(Aneta.isAdult()).isTrue();
    }

    @Test
    public void VerifyAge3() {
        Customer marian = new Customer("Marian", "Kowalski", 30);
        assertThat(marian.isAdult()).isTrue();
    }

    @Test
    public void addItemToTheBasketTest() {
        Customer customer = new Customer("Janusz", "Kowalski", 28);
        BasketItem book = new BasketItem("condoms", 5, true);
        customer.addItemToBasket(book);
        customer.currentBasket();
    }

    @Test
    public void addItemToTheBasketTest2() {
        Customer customer = new Customer("Marek", "Kolos", 16);
        BasketItem game = new BasketItem("GTA Vice City", 40, false);
        customer.addItemToBasket(game);
        customer.currentBasket();
    }

    @Test
    public void addItemToTheBasketTest3() {
        Customer customer = new Customer("Jan", "Kowalski", 15);
        BasketItem pornnewspaper = new BasketItem("Foxy", 10, true);
        customer.addItemToBasket(pornnewspaper);
        customer.currentBasket();
    }

    @Test
    public void totalPriceTest() {
        Customer customer = new Customer("Jarek", "Sobieszek", 29);
        BasketItem vodka = new BasketItem("Luksusowa", 18, true);
        customer.addItemToBasket(vodka);
        assertThat(customer.getTotalBasketPrice()).isEqualTo(18);
    }

    @Test
    public void totalPriceTest2() {
        Customer customer = new Customer("Jarek", "Sobieszek", 29);
        BasketItem vodka = new BasketItem("Luksusowa", 18, true);
        BasketItem cigarettes = new BasketItem("Marlboro", 16, true);
        customer.addItemToBasket(vodka);
        customer.addItemToBasket(cigarettes);
        assertThat(customer.getTotalBasketPrice()).isEqualTo(34);
        System.out.println("Cena wszystkich produktów:" + customer.getTotalBasketPrice());
    }

    @Test
    public void removeItemFromBasketTest() {
        Customer customer = new Customer("Jarek", "Sobieszek", 29);
        BasketItem vodka = new BasketItem("Luksusowa", 18, true);
        BasketItem cigarettes = new BasketItem("Marlboro", 16, true);
        customer.addItemToBasket(vodka);
        customer.addItemToBasket(cigarettes);
        assertThat(customer.getTotalBasketPrice()).isEqualTo(34);
        customer.currentBasket();
        customer.removeItemFromBasket(vodka);
        assertThat(customer.getTotalBasketPrice()).isEqualTo(16);
        customer.currentBasket();
    }

    @Test
    public void discountPriceTest() {
        Customer customer = new Customer("Jarek", "Sobieszek", 29);
        PromoItem shoes = new PromoItem("Reebok Speed TR 2.0", 350, false, 0.8);
        customer.addItemToBasket(shoes);
        assertThat(shoes.usePromotion(shoes)).isEqualTo(280);
    }
    @Test
    public void discountPriceTest2(){
        Customer customer = new Customer("Jarek", "Sobieszek", 29);
        PromoItem wheel = new PromoItem("Kormoran RunPro", 109, false, 0.8);
        customer.addItemToBasket(wheel);
        assertThat(wheel.usePromotion(wheel)).isBetween(87.1,87.5);
    }
}


