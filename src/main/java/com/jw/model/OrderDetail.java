package com.jw.model;

import java.io.Serializable;
import java.math.BigInteger;

public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material item) {
        this.material = item;
    }

    private Integer id;
    private BigInteger orderId;
    private Double totalPrice;
    private Integer status;
    private Material material;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    private Integer itemId;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", material=" + material +
                '}';
    }
}
