package com.myproject.bookmanager.model;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 与user绑定的id
     */
    private Integer userId;

    /**
     * t票实体
     */
    private String ticket;

    /**
     * 过期时间
     */
    private Date expiredAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", expiredAt=" + expiredAt +
                '}';
    }
}
