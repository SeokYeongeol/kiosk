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

    public T getBurgerItem(int index) { return getBurgerItemList().get(index); }

    public void lookUpBurgerMenuList() {      // 버거 메뉴 리스트 조회
        final int[] index = {1};
        getBurgerItemList().stream().forEach(f -> {
            System.out.println(index[0] + ". " + f.getName() + "   | W " + f.getPrice() + " | " + f.getDesc());
            index[0]++;
        });
        System.out.println("0. 이전     | 이전 페이지");
        System.out.print("입력 : ");
    }

    public void lookUpBurgerMenu(String value) {      // 선택한 버거 메뉴 조회
        System.out.println("선택한 메뉴 : " + getBurgerItem(Integer.parseInt(value)-1).getName() + "   | W " + getBurgerItem(Integer.parseInt(value)-1).getPrice() + " | " + getBurgerItem(Integer.parseInt(value)-1).getDesc());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        System.out.print("입력 : ");
    }


    /* Drink List Method */
    public List<T> getDrinkItemList() { return this.drinkItemList; }

    public void setDrinkItemList(T menuItem) { getDrinkItemList().add(menuItem); }

    public T getDrinkItem(int index) { return getDrinkItemList().get(index); }

    public void lookUpDrinkMenuList() {     // 음료 메뉴 리스트 조회
        final int[] index = {1};
        getDrinkItemList().stream().forEach(f -> {
            System.out.println(index[0] + ". " + f.getName() + "   | W " + f.getPrice() + " | " + f.getDesc());
            index[0]++;
        });
        System.out.println("0. 이전     | 이전 페이지");
        System.out.print("입력 : ");
    }

    public void lookUpDrinkMenu(String value) {      // 선택한 음료 메뉴 조회
        System.out.println("선택한 메뉴 : " + getDrinkItem(Integer.parseInt(value)-1).getName() + "   | W " + getDrinkItem(Integer.parseInt(value)-1).getPrice() + " | " + getDrinkItem(Integer.parseInt(value)-1).getDesc());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        System.out.print("입력 : ");
    }


    /* Dessert List Method */
    public List<T> getDessertItemList() { return this.dessertItemList; }

    public void setDessertItemList(T menuItem) { getDessertItemList().add(menuItem); }

    public T getDessertItem(int index) { return getDessertItemList().get(index); }

    public void lookUpDessertMenuList() {     // 디저트 메뉴 리스트 조회
        final int[] index = {1};
        getDessertItemList().stream().forEach(f -> {
            System.out.println(index[0] + ". " + f.getName() + "   | W " + f.getPrice() + " | " + f.getDesc());
            index[0]++;
        });
        System.out.println("0. 이전     | 이전 페이지");
        System.out.print("입력 : ");
    }

    public void lookUpDessertMenu(String value) {      // 선택한 디저트 메뉴 조회
        System.out.println("선택한 메뉴 : " + getDessertItem(Integer.parseInt(value)-1).getName() + "   | W " + getDessertItem(Integer.parseInt(value)-1).getPrice() + " | " + getDessertItem(Integer.parseInt(value)-1).getDesc());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        System.out.print("입력 : ");
    }

    
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
