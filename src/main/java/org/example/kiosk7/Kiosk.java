package org.example.kiosk7;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String SALE_NUMBER_REG = "^[1-4]$";
    private Menu<MenuItem> menu;
    private ShoppingCart<MenuItem> shoppingCart;

    public Kiosk(Menu<MenuItem> menu, ShoppingCart<MenuItem> shoppingCart) {
        this.menu = menu;
        this.shoppingCart = shoppingCart;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            menu.mainMenuController();

            if(!shoppingCart.getShoppingCart().isEmpty()) {
                menu.orderMenuController();
            }

            System.out.print("입력 : ");
            String selectFoods = sc.next();
            if(selectFoods.equals("0")) break;

            else if(selectFoods.equals("1")) {
                System.out.println( "\n[ SHAKESHACK MENU ]");
                menu.lookUpBurgerMenuList();                          // 메뉴 리스트를 보여주는 메서드

                String selectBurgerMenu = sc.next();

                if(selectBurgerMenu.equals("0")) continue;

                try {       // 숫자가 아닌 다른 값이 들어가거나, 리스트 사이즈보다 큰 값이 들어갔을 때 예외처리문
                    if(!Pattern.matches(NUMBER_REG, selectBurgerMenu) || Integer.parseInt(selectBurgerMenu) > menu.getBurgerItemList().size()) throw new IOException("잘못된 값을 입력하였습니다.");
                    menu.lookUpBurgerMenu(selectBurgerMenu);        // 선택한 메뉴를 보여주는 메서드
                    String orderSelect = sc.next();

                    if(orderSelect.equals("1")) shoppingCart.setShoppingCart(menu.getBurgerItem(Integer.parseInt(selectBurgerMenu)-1));
                    else if(orderSelect.equals("2")) System.out.println("주문이 취소되었습니다.");
                    else throw new IOException("잘못된 값을 입력하였습니다.");

                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if(selectFoods.equals("2")) {
                System.out.println( "\n[ DRINK MENU ]");
                menu.lookUpDrinkMenuList();

                String selectDrinkMenu = sc.next();

                if(selectDrinkMenu.equals("0")) continue;

                try {       // 숫자가 아닌 다른 값이 들어가거나, 리스트 사이즈보다 큰 값이 들어갔을 때 예외처리문
                    if(!Pattern.matches(NUMBER_REG, selectDrinkMenu) || Integer.parseInt(selectDrinkMenu) > menu.getDrinkItemList().size()) throw new IOException("잘못된 값을 입력하였습니다.");
                    menu.lookUpDrinkMenu(selectDrinkMenu);        // 선택한 메뉴를 보여주는 메서드
                    String orderSelect = sc.next();

                    if(orderSelect.equals("1")) shoppingCart.setShoppingCart(menu.getDrinkItem(Integer.parseInt(selectDrinkMenu)-1));
                    else if(orderSelect.equals("2")) System.out.println("주문이 취소되었습니다.");
                    else throw new IOException("잘못된 값을 입력하였습니다.");

                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if(selectFoods.equals("3")) {
                System.out.println( "\n[ DESSERT MENU ]");
                menu.lookUpDessertMenuList();

                String selectDessertMenu = sc.next();

                if(selectDessertMenu.equals("0")) continue;

                try {       // 숫자가 아닌 다른 값이 들어가거나, 리스트 사이즈보다 큰 값이 들어갔을 때 예외처리문
                    if(!Pattern.matches(NUMBER_REG, selectDessertMenu) || Integer.parseInt(selectDessertMenu) > menu.getDessertItemList().size()) throw new IOException("잘못된 값을 입력하였습니다.");
                    menu.lookUpDessertMenu(selectDessertMenu);        // 선택한 메뉴를 보여주는 메서드
                    String orderSelect = sc.next();

                    if(orderSelect.equals("1")) shoppingCart.setShoppingCart(menu.getDessertItem(Integer.parseInt(selectDessertMenu)-1));
                    else if(orderSelect.equals("2")) System.out.println("주문이 취소되었습니다.");
                    else throw new IOException("잘못된 값을 입력하였습니다.");

                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if(selectFoods.equals("4")) {
                if(shoppingCart.getShoppingCart().isEmpty()) {
                    System.out.println("쇼핑 카트가 비어있습니다.");
                    continue;
                }
                System.out.println("아래와 같이 주문하시겠습니까 ?");
                System.out.println("\n[ ORDERS ]");
                shoppingCart.ordersShoppingCart();      // 쇼핑 카트 목록 열람
                System.out.println("\n[ TOTAL ]");
                System.out.println("W " + shoppingCart.getShoppingPrice());
                System.out.println("\n1. 주문      2. 메뉴판");
                System.out.print("입력 : ");
                String order = sc.next();

                if(order.equals("1")) {
                    shoppingCart.orderPrice();      // 할인 패널
                    String saleNumber = sc.next();
                    try {
                        if(!Pattern.matches(SALE_NUMBER_REG, saleNumber)) throw new IOException("잘못된 값을 입력하였습니다.");
                        shoppingCart.priceCalculate(saleNumber);        // 할인 유형 설정
                        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", shoppingCart.salePrice());      // 할인 금액
                        shoppingCart.clearShoppingCart();

                    } catch(IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else if(order.equals("2")) {}
                else System.out.println("잘못된 값을 입력하였습니다.");

            } else if(selectFoods.equals("5")) {
                if(shoppingCart.getShoppingCart().isEmpty()) {
                    System.out.println("쇼핑 카트가 비어있습니다.");
                    continue;
                }
                System.out.println("\n어떤 메뉴를 취소하시겠습니까 ?");
                shoppingCart.ordersShoppingCart();      // 쇼핑 카트 목록 열람
                System.out.print("입력 : ");
                String deleteMenu = sc.next();
                boolean deleteCheck = shoppingCart.deleteMenuSelect(deleteMenu);

                if(deleteCheck) System.out.println(deleteMenu + " (이)가 삭제되었습니다.");
                else System.out.println("잘못된 값을 입력하였습니다.");

            } else System.out.println("잘못된 값을 입력하였습니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }
}