package com.jw.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Order  implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private Long userId;
    private String orderNumber;
    private Date created;
    private Date updated;
    private  User user;



    private List<OrderDetail> orderDetails;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                '}';
    }
}
