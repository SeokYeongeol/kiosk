package org.example.kiosk7;

import java.util.*;
import java.util.regex.Pattern;

public class MenuController<T extends MenuItemInterface> {
    private Menu<T> menu;
    private ShoppingCart<T> shoppingCart;

    private String selectFoods;
    private Scanner sc = new Scanner(System.in);

    public MenuController(Menu<T> menu, ShoppingCart<T> shoppingCart) {
        this.menu = menu;
        this.shoppingCart = shoppingCart;
    }

    public void setSelectFoods(String selectFoods) {
        this.selectFoods = selectFoods;
    }

    /* 번호마다 다른 리스트를 가져오는 메서드 */
    private List<T> getMenuList() {
        List<T> list = new ArrayList<>();
        if(this.selectFoods.equals("1")) list = menu.getBurgerItemList();
        else if(this.selectFoods.equals("2")) list = menu.getDrinkItemList();
        else if(this.selectFoods.equals("3")) list = menu.getDessertItemList();

        return list;
    }

    private T getMenuItem(int index) { return getMenuList().get(index); }

    /* 메뉴 리스트를 보여주는 메서드 */
    private void lookUpMenuList() {      // 메뉴 리스트 조회
        final int[] index = {1};
        getMenuList().stream().forEach(f -> {
            System.out.println(index[0] + ". " + f.getName() + "   | W " + f.getPrice() + " | " + f.getDesc());
            index[0]++;
        });
        System.out.print("\n입력 : ");
    }
    
    /* 선택한 메뉴를 보여주는 메서드 */
    private void lookUpMenu(String value) {
        System.out.println("선택한 메뉴 : " + getMenuItem(Integer.parseInt(value)-1).getName() + "   | W " +
                getMenuItem(Integer.parseInt(value)-1).getPrice() + " | " + getMenuItem(Integer.parseInt(value)-1).getDesc());
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        System.out.print("입력 : ");
    }

    /* 선택된 숫자에 따라 메뉴를 보여주는 메서드 */
    public void menuController() {
        System.out.println( "\n[ SHAKESHACK MENU ]");
        lookUpMenuList();                          // 메뉴 리스트를 보여주는 메서드

        String selectMenu = sc.next();

        try {       // 숫자가 아닌 다른 값이 들어가거나, 리스트 사이즈보다 큰 값이 들어갔을 때 예외처리문
            if(!Pattern.matches(Kiosk.NUMBER_REG, selectMenu) || Integer.parseInt(selectMenu) > getMenuList().size()) throw new BadInputException();
            else if(selectMenu.equals("0")) throw new BadInputException();
            lookUpMenu(selectMenu);        // 선택한 메뉴를 보여주는 메서드
            String orderSelect = sc.next();

            if(orderSelect.equals("1")) shoppingCart.setShoppingCart(getMenuItem(Integer.parseInt(selectMenu)-1));
            else if(orderSelect.equals("2")) System.out.println("주문이 취소되었습니다.");
            else throw new BadInputException();

        } catch(BadInputException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // 4번의 쇼핑카트 구매 메서드
    public void shoppingCartBuy() throws BadInputException {
        System.out.println("아래와 같이 주문하시겠습니까 ?");
        System.out.println("\n[ ORDERS ]");
        shoppingCart.ordersShoppingCart();      // 쇼핑 카트 목록 열람
        System.out.println("\n[ TOTAL ]");
        System.out.printf("W %.1f\n", shoppingCart.getShoppingPrice());
        System.out.println("\n1. 주문      2. 메뉴판");
        System.out.print("입력 : ");
        String order = sc.next();

        if(order.equals("1")) {
            shoppingCart.orderPrice();      // 할인 패널
            String saleNumber = sc.next();
            try {
                if(!Pattern.matches(Kiosk.SALE_NUMBER_REG, saleNumber)) throw new BadInputException();
                shoppingCart.priceCalculate(saleNumber);        // 할인 유형 설정
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", shoppingCart.salePrice());      // 할인 금액
                shoppingCart.clearShoppingCart();

            } catch(BadInputException e) {
                System.out.println(e.getMessage());
            }
        } else if(order.equals("2")) System.out.println("메뉴판으로 이동합니다.");
        else System.out.println("잘못된 값을 입력하였습니다.");
    }
    
    // 5번의 쇼핑카트 삭제 메서드
    public void shoppingCartDelete() {
        System.out.println("\n어떤 메뉴를 취소하시겠습니까 ?");
        shoppingCart.ordersShoppingCart();      // 쇼핑 카트 목록 열람
        System.out.print("입력 : ");
        String deleteMenu = sc.next();
        boolean deleteCheck = shoppingCart.deleteMenuSelect(deleteMenu);

        if(deleteCheck) System.out.println(deleteMenu + " (이)가 삭제되었습니다.");
        else System.out.println("잘못된 값을 입력하였습니다.");
    }
}
