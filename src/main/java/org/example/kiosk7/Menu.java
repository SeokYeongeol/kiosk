package org.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class Menu<T extends MenuItemInterface> {
    private List<T> burgerItemList = new ArrayList<>();
    private List<T> drinkItemList = new ArrayList<>();
    private List<T> dessertItemList = new ArrayList<>();

    /* Burger List Method */
    public List<T> getBurgerItemList() { return this.burgerItemList; }

    public void setBurgerItemList(T menuItem) { getBurgerItemList().add(menuItem); }


    /* Drink List Method */
    public List<T> getDrinkItemList() { return this.drinkItemList; }

    public void setDrinkItemList(T menuItem) { getDrinkItemList().add(menuItem); }


    /* Dessert List Method */
    public List<T> getDessertItemList() { return this.dessertItemList; }

    public void setDessertItemList(T menuItem) { getDessertItemList().add(menuItem); }

    
    /* 메뉴 상태를 보여주는 메서드들 */
    public void mainMenuController() {
        System.out.println("\n[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("0. 종료     | 종료");
    }

    public void orderMenuController() {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println("4. Orders     | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel     | 진행중인 주문을 취소합니다.");
    }
}
