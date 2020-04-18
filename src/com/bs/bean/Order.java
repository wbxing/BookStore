package com.bs.bean;

import java.util.Date;

public class Order {
    public static final int NOT_SHIPPED = 0;
    public static final int SHIPPED = 1;
    //    public static final int UNSIGNED = 1;
    public static final int SIGNED = 2;

    private String orderId;
    private String createTime;
    private Double totalMoney;
    private Integer status = NOT_SHIPPED;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, String createTime, Double totalMoney, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.totalMoney = totalMoney;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", totalMoney=" + totalMoney +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }
}
