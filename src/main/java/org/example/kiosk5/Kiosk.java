package org.example.kiosk5;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Kiosk {
    private static final String NUMBER_REG = "^[0-9]*$";
    private Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료     | 종료");

            System.out.print("입력 : ");
            String selectFoods = sc.next();
            if(selectFoods.equals("0")) break;

            else if(selectFoods.equals("1")) {
                System.out.println( "\n[ SHAKESHACK MENU ]");
                menu.lookUpMenuList();
                System.out.println("0. 이전     | 이전 페이지");
                System.out.print("입력 : ");
                String selectMenu = sc.next();

                if(selectMenu.equals("0")) continue;

                try {
                    if(!Pattern.matches(NUMBER_REG, selectMenu) || Integer.parseInt(selectMenu) > menu.getMenuItemList().size()) throw new IOException("잘못된 값을 입력하였습니다. \n");
                    menu.lookUpMenu(selectMenu);
                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
