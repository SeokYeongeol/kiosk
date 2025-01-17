package org.example.kiosk3;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private List<MenuItem> menuItemList = new ArrayList<>();
    private static final String NUMBER_REG = "^[0-9]*$";

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(MenuItem menu) {
        getMenuItemList().add(menu);
    }

    public Kiosk() {
        setMenuItemList(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        setMenuItemList(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        setMenuItemList(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        setMenuItemList(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println( "\n[ SHAKESHACK MENU ]");
            for(int i = 0; i < getMenuItemList().size(); i++) {
                System.out.println((i+1) + ". " + getMenuItemList().get(i).getName() + "   | W " + getMenuItemList().get(i).getPrice() + " | " + getMenuItemList().get(i).getDesc());
            }
            System.out.println("0. 종료     | 종료");
            System.out.print("입력 : ");
            String selectFood = sc.next();

            if(selectFood.equals("0")) break;

            try {
                if(!Pattern.matches(NUMBER_REG, selectFood) || Integer.parseInt(selectFood) > getMenuItemList().size()) throw new IOException("잘못된 입력입니다.");
                System.out.println("선택한 메뉴 : " + getMenuItemList().get(Integer.parseInt(selectFood)-1).getName() + "   | W " + getMenuItemList().get(Integer.parseInt(selectFood)-1).getPrice() + " | " + getMenuItemList().get(Integer.parseInt(selectFood)-1).getDesc());
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
