package com.fq.pojo;

public class Address {
    private Integer addressId;
    private Integer customerId;
    private String receiverName;
    private String receiverMoblie;
    private String content;
    private String tag;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMoblie() {
        return receiverMoblie;
    }

    public void setReceiverMoblie(String receiverMoblie) {
        this.receiverMoblie = receiverMoblie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
