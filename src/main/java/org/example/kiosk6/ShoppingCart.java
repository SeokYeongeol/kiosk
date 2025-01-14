package org.example.kiosk6;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<MenuItem> shoppingCart = new ArrayList<>();

    public List<MenuItem> getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(MenuItem menuItem) {
        getShoppingCart().add(menuItem);
    }

    public void ordersShoppingCart() {
        System.out.println("아래와 같이 주문하시겠습니까 ?");
        System.out.println("\n[ ORDERS ]");
        for(int i = 0; i < getShoppingCart().size(); i++) {
            System.out.println((i+1) + ". " + getShoppingCart().get(i).getName() + "   | W " + getShoppingCart().get(i).getPrice() + " | " + getShoppingCart().get(i).getDesc());
        }
        System.out.println("\n[ TOTAL ]");
        System.out.println("W " + getShoppingPrice());
        System.out.println("\n1. 주문      2. 메뉴판");
        System.out.print("입력 : ");
    }

    public double getShoppingPrice() {
        return getShoppingCart().stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void clearShoppingCart() {
        getShoppingCart().clear();
    }
}
