package org.example.kiosk6;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private static final String NUMBER_REG = "^[0-9]*$";
    private Menu menu;
    private ShoppingCart shoppingCart;

    public Kiosk(Menu menu, ShoppingCart shoppingCart) {
        this.menu = menu;
        this.shoppingCart = shoppingCart;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료     | 종료");

            if(!shoppingCart.getShoppingCart().isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders     | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel     | 진행중인 주문을 취소합니다.");
            }

            System.out.print("입력 : ");
            String selectFoods = sc.next();
            if(selectFoods.equals("0")) break;

            else if(selectFoods.equals("1")) {
                System.out.println( "\n[ SHAKESHACK MENU ]");
                menu.lookUpMenuList();                          // 메뉴 리스트를 보여주는 메서드
                System.out.println("0. 이전     | 이전 페이지");
                
                System.out.print("입력 : ");
                String selectMenu = sc.next();

                if(selectMenu.equals("0")) continue;

                try {
                    if(!Pattern.matches(NUMBER_REG, selectMenu) || Integer.parseInt(selectMenu) > menu.getMenuItemList().size()) throw new IOException("잘못된 값을 입력하였습니다.");
                    menu.lookUpMenu(selectMenu);        // 선택한 메뉴를 보여주는 메서드
                    String orderSelect = sc.next();

                    if(orderSelect.equals("1")) shoppingCart.setShoppingCart(menu.getMenuItem(Integer.parseInt(selectMenu)-1));
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
                shoppingCart.ordersShoppingCart();
                String order = sc.next();

                if(order.equals("1")) System.out.println("주문이 완료되었습니다. 금액은 W " + shoppingCart.getShoppingPrice() + " 입니다.");
                else if(order.equals("2")) {}
                else System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
