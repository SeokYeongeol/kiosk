package org.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> burgerItemList = new ArrayList<>();
    private List<MenuItem> drinkItemList = new ArrayList<>();
    private List<MenuItem> dessertItemList = new ArrayList<>();

    /* Burger List Method */
    public List<MenuItem> getBurgerItemList() { return this.burgerItemList; }

    public void setBurgerItemList(MenuItem menuItem) { getBurgerItemList().add(menuItem); }

    public MenuItem getBurgerItem(int index) { return getBurgerItemList().get(index); }

    public void lookUpBurgerMenuList() {      // 버거 메뉴 리스트 조회
        for(int i = 0; i < getBurgerItemList().size(); i++) {
            System.out.println((i+1) + ". " + getBurgerItem(i).getName() + "   | W " + getBurgerItem(i).getPrice() + " | " + getBurgerItem(i).getDesc());
        }
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
    public List<MenuItem> getDrinkItemList() { return this.drinkItemList; }

    public void setDrinkItemList(MenuItem menuItem) { getDrinkItemList().add(menuItem); }

    public MenuItem getDrinkItem(int index) { return getDrinkItemList().get(index); }

    public void lookUpDrinkMenuList() {     // 음료 메뉴 리스트 조회
        for(int i = 0; i < getDrinkItemList().size(); i++) {
            System.out.println((i+1) + ". " + getDrinkItem(i).getName() + "   | W " + getDrinkItem(i).getPrice() + " | " + getDrinkItem(i).getDesc());
        }
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
    public List<MenuItem> getDessertItemList() { return this.dessertItemList; }

    public void setDessertItemList(MenuItem menuItem) { getDessertItemList().add(menuItem); }

    public MenuItem getDessertItem(int index) { return getDessertItemList().get(index); }

    public void lookUpDessertMenuList() {     // 디저트 메뉴 리스트 조회
        for(int i = 0; i < getDessertItemList().size(); i++) {
            System.out.println((i+1) + ". " + getDessertItem(i).getName() + "   | W " + getDessertItem(i).getPrice() + " | " + getDessertItem(i).getDesc());
        }
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
