package com.bs.bean;

import java.util.Date;

public class OrderItem {
    private Integer id;
    private String name;
    private Double price;
    private Double totalMoney;
    private Integer count;
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Double price, Double totalMoney, Integer count, String orderId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalMoney = totalMoney;
        this.count = count;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                ", count=" + count +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
