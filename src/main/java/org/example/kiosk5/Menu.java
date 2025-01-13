package org.example.kiosk5;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private List<MenuItem> menuItemList = new ArrayList<>();

    // getter
    public List<MenuItem> getMenuItemList() { return this.menuItemList; }

    // setter
    public void setMenuItemList(MenuItem menuItem) { this.menuItemList.add(menuItem); }

    public void lookUpMenuList() {      // 메뉴 리스트 조회
        for(int i = 0; i < getMenuItemList().size(); i++) {
            System.out.println(i+1 + ". " + getMenuItemList().get(i).getName() + "   | W " + getMenuItemList().get(i).getPrice() + " | " + getMenuItemList().get(i).getDesc());
        }
    }

    public void lookUpMenu(String value) {      // 선택한 메뉴 조회
        System.out.println("선택한 메뉴 : " + getMenuItemList().get(Integer.parseInt(value)-1).getName() + "   | W " + getMenuItemList().get(Integer.parseInt(value)-1).getPrice() + " | " + getMenuItemList().get(Integer.parseInt(value)-1).getDesc());
    }
}
