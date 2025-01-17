package org.example.kiosk7;

public class Main {
    public static void main(String[] args) {
        Menu<MenuItemInterface> menu = new Menu();
        ShoppingCart<MenuItemInterface> shoppingCart = new ShoppingCart();

        menu.setBurgerItemList(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.setBurgerItemList(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.setBurgerItemList(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.setBurgerItemList(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        
        menu.setDrinkItemList(new MenuItem("Coke", 1.3, "청량함이 첨가된 시원한 콜라"));
        menu.setDrinkItemList(new MenuItem("Americano", 2.5, "시원하고 고소한 아이스 아메리카노"));
        menu.setDrinkItemList(new MenuItem("Beer", 4.7, "시원한 탄산의 맥주"));
        
        menu.setDessertItemList(new MenuItem("Ice-Cream", 1.2, "달콤한 소프트 아이스크림"));
        menu.setDessertItemList((new MenuItem("WholeCake", 12.6, "달콤하고 맛있는 딸기 케이크")));

        Kiosk kiosk = new Kiosk(menu, shoppingCart);
        kiosk.start();
    }
}
