package com.fq.pojo;

public class OrderDetail {
    private Long orderId;
    private Short payMethod;
    private String invoiceAdderss;
    private Double invoicePrice;
    private Short shipMethod;
    private String shipAddres;
    private Double shipPrice;
    private String comment;
    private String content;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public String getInvoiceAdderss() {
        return invoiceAdderss;
    }

    public void setInvoiceAdderss(String invoiceAdderss) {
        this.invoiceAdderss = invoiceAdderss;
    }

    public Double getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Double invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public Short getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Short shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getShipAddres() {
        return shipAddres;
    }

    public void setShipAddres(String shipAddres) {
        this.shipAddres = shipAddres;
    }

    public Double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
