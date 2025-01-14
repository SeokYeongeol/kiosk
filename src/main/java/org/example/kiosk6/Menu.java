package org.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList = new ArrayList<>();

    // getter
    public List<MenuItem> getMenuItemList() { return this.menuItemList; }

    // setter
    public void setMenuItemList(MenuItem menuItem) { getMenuItemList().add(menuItem); }

    public MenuItem getMenuItem(int index) { return getMenuItemList().get(index); }

    public void lookUpMenuList() {      // 메뉴 리스트 조회
        for(int i = 0; i < getMenuItemList().size(); i++) {
            System.out.println((i+1) + ". " + getMenuItemList().get(i).getName() + "   | W " + getMenuItemList().get(i).getPrice() + " | " + getMenuItemList().get(i).getDesc());
        }
    }

    public void lookUpMenu(String value) {      // 선택한 메뉴 조회
        System.out.println("선택한 메뉴 : " + getMenuItemList().get(Integer.parseInt(value)-1).getName() + "   | W " + getMenuItemList().get(Integer.parseInt(value)-1).getPrice() + " | " + getMenuItemList().get(Integer.parseInt(value)-1).getDesc());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        System.out.print("입력 : ");
    }
}
