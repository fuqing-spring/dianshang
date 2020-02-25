package com.fq.dto.out;

import java.util.List;

public class OrderShowOut {
    private Integer orderId;
    private Long createTimestamp;
    private Short payMethod;
    private Short shipMethod;
    private Double shipPrice;
    private String payAddress;
    private String shipAddress;
    private List<OrderProductOut> orderProducts;
    private Double orderProductTotalPrice;
    private Double totalPrice;
    private List<PrderHistoryOut> orderHistories;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Short getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Short shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public String getPayAddress() {
        return payAddress;
    }

    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public List<OrderProductOut> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductOut> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Double getOrderProductTotalPrice() {
        return orderProductTotalPrice;
    }

    public void setOrderProductTotalPrice(Double orderProductTotalPrice) {
        this.orderProductTotalPrice = orderProductTotalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PrderHistoryOut> getOrderHistories() {
        return orderHistories;
    }

    public void setOrderHistories(List<PrderHistoryOut> orderHistories) {
        this.orderHistories = orderHistories;
    }
}
