package com.fq.dto.out;

import com.fq.vo.OrderProductVO;

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
    public Byte status;
    public Integer rewordPoints;
    public Long setUpdateTimestamp;
    private long updateTimestamp;
    public String invoiceAddress;
    private Double invoicePrice;
    public String setComment;
    private String comment;

    public String getSetComment() {
        return setComment;
    }

    public void setSetComment(String setComment) {
        this.setComment = setComment;
    }

    public long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Double getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Double invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public Long getSetUpdateTimestamp() {
        return setUpdateTimestamp;
    }

    public void setSetUpdateTimestamp(Long setUpdateTimestamp) {
        this.setUpdateTimestamp = setUpdateTimestamp;
    }

    public Integer getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Integer rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

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

    public void setOrderProducts(List<OrderProductVO> orderProducts) {
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

    public void setOrderHistories(List<OrderHistoryListOutDTO> orderHistories) {
        this.orderHistories = orderHistories;
    }

    public void setUpdateTimestamp(long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
