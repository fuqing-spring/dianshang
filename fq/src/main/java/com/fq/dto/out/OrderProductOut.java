package com.fq.dto.out;

public class OrderProductOut {
    private Integer orderProductId;
    private String orderProductCode;
    private String orderProductName;
    private Double unitPrice;
    private Integer orderProductQuantity;
    private Double totaPrice;

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getOrderProductCode() {
        return orderProductCode;
    }

    public void setOrderProductCode(String orderProductCode) {
        this.orderProductCode = orderProductCode;
    }

    public String getOrderProductName() {
        return orderProductName;
    }

    public void setOrderProductName(String orderProductName) {
        this.orderProductName = orderProductName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getOrderProductQuantity() {
        return orderProductQuantity;
    }

    public void setOrderProductQuantity(Integer orderProductQuantity) {
        this.orderProductQuantity = orderProductQuantity;
    }

    public Double getTotaPrice() {
        return totaPrice;
    }

    public void setTotaPrice(Double totaPrice) {
        this.totaPrice = totaPrice;
    }
}
