package com.jw.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private BigInteger orderNumber;
    private Date created;
    private Date updated;
    private SysUser sysUser;


    private List<OrderDetail> orderDetails;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigInteger orderNumber) {
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

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
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
                ", userId=" + sysUser.getId() +
                ", orderNumber='" + orderNumber + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", sysUser=" + sysUser +
                '}';
    }
}
