package org.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends MenuItemInterface> {
    private List<T> shoppingCart = new ArrayList<>();
    private Sale jobSale;

    public List<T> getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(T menuItem) {
        getShoppingCart().add(menuItem);
    }

    public void ordersShoppingCart() {
        final int[] index = {1};
        getShoppingCart().stream().forEach(f -> {
            System.out.println(index[0] + ". " + f.getName() + "   | W " + f.getPrice() + " | " + f.getDesc());
            index[0]++;
        });
    }
    
    // 쇼핑 카트 리스트에 담긴 물건들 결제
    public double getShoppingPrice() {
        return getShoppingCart().stream().mapToDouble(T::getPrice).sum();
    }
    
    // 쇼핑 카트 리스트 비우기
    public void clearShoppingCart() {
        getShoppingCart().clear();
    }
    
    // 쇼핑 카트에 담긴 메뉴 중 삭제할 이름 지정 후 삭제
    public boolean deleteMenuSelect(String value) {
       return getShoppingCart().stream().filter(f -> f.getName().contains(value))
               .findFirst()
               .map(item -> getShoppingCart().remove(item))
               .orElse(false);
    }


    /* 직업 별 할인 메서드 + Enum */
    private void setJobSale(Sale jobSale) { this.jobSale = jobSale; }

    public double salePrice() { return this.jobSale.salePercent(getShoppingPrice()); }

    public void priceCalculate(String value) {
        Sale sale = switch(value) {
          case "1" -> Sale.Veteran;
          case "2" -> Sale.Soldier;
          case "3" -> Sale.Student;
          case "4" -> Sale.General;
          default -> throw new IllegalStateException();
        };
        setJobSale(sale);
    }

    public void orderPrice() {          // 할인 패널
        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인 : 5%");
        System.out.println("3. 학생 : 3%");
        System.out.println("4. 일반인 : 0%");
        System.out.print("입력 : ");
    }

    public enum Sale {
        Veteran("1") {
            @Override
            public double salePercent(double price) { return price * 0.9; }
        },
        Soldier("2") {
            @Override
            public double salePercent(double price) { return price * 0.95; }
        },
        Student("3") {
            @Override
            public double salePercent(double price) { return price * 0.97; }
        },
        General("4") {
            @Override
            public double salePercent(double price) { return price; }
        };

        public final String selectJob;

        Sale(String selectJob) { this.selectJob = selectJob; }

        public abstract double salePercent(double price);
    }
}
