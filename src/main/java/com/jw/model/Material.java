package com.jw.model;

import java.io.Serializable;

public class Material implements Serializable {

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    private Integer id;
    private String itemName;
    private Float itemPrice;
    private String itemDetail;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDetail='" + itemDetail + '\'' +
                '}';
    }
}
