package org.example.kiosk7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    public static final String NUMBER_REG = "^[0-9]*$";
    public static final String SALE_NUMBER_REG = "^[1-4]$";
    private Menu<MenuItemInterface> menu;
    private ShoppingCart<MenuItemInterface> shoppingCart;
    private MenuController<MenuItemInterface> menuController;

    public Kiosk(Menu<MenuItemInterface> menu, ShoppingCart<MenuItemInterface> shoppingCart) {
        this.menu = menu;
        this.shoppingCart = shoppingCart;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        menuController = new MenuController<>(menu, shoppingCart);

        while(true) {
            menu.mainMenuController();

            if(!shoppingCart.getShoppingCart().isEmpty()) {
                menu.orderMenuController();
            }

            System.out.print("입력 : ");
            String selectFoods = sc.next();
            menuController.setSelectFoods(selectFoods);

            switch(selectFoods) {
                case "0":
                    break;

                case "1":
                case "2":
                case "3":
                    menuController.menuController();
                    continue;

                case "4":
                    if(shoppingCart.getShoppingCart().isEmpty()) {
                        System.out.println("쇼핑 카트가 비어있습니다.");
                        continue;
                    }
                    menuController.shoppingCartBuy();
                    continue;

                case "5":
                    if(shoppingCart.getShoppingCart().isEmpty()) {
                        System.out.println("쇼핑 카트가 비어있습니다.");
                        continue;
                    }
                    menuController.shoppingCartDelete();
                    continue;

                default:
                    System.out.println("잘못된 값을 입력하였습니다.");
                    continue;
            }
            break;
        }
        System.out.println("프로그램을 종료합니다.");
    }
}