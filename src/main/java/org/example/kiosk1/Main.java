package org.example.kiosk1;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private static final String NUMBER_REG = "^[0-9]*$";

    public static void main(String[] args) {
        List<MenuItem> menuItemList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        menuItemList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i = 0; i < menuItemList.size(); i++) {
                System.out.println(i+1 + ". " + menuItemList.get(i).getName() + "   | W " + menuItemList.get(i).getPrice() + " | " + menuItemList.get(i).getDesc());
            }
            System.out.println("0. 종료");
            System.out.print("입력 : ");
            String value = sc.next();

            if(value.equals("0")) break;

            try {
                if(!Pattern.matches(NUMBER_REG, value) || Integer.parseInt(value) > menuItemList.size()) throw new IOException("잘못된 값을 입력하였습니다. \n");
                System.out.println("선택한 메뉴 : " + menuItemList.get(Integer.parseInt(value)-1).getName() + "   | W " + menuItemList.get(Integer.parseInt(value)-1).getPrice() + " | " + menuItemList.get(Integer.parseInt(value)-1).getDesc() + "\n");
            } catch(IOException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
