package org.example.kiosk1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println( "\n[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack, 8.9, 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger, 6.9, 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger, 5.4, 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료     | 종료");

            System.out.print("입력 : ");
            String selectFood = sc.next();

            if(selectFood.equals("0")) break;
            else System.out.println("잘못된 값을 입력하였습니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
