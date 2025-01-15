package org.example.kiosk7;

public class MenuItem implements MenuItemInterface {
    private String name;
    private double price;
    private String desc;

    public String getName() { return name; }

    public double getPrice() { return price; }

    public String getDesc() { return desc; }

    public MenuItem(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
}
