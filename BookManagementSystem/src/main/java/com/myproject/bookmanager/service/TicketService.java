package com.myproject.bookmanager.service;

import com.myproject.bookmanager.model.Ticket;

public interface TicketService {

    /**
     * 添加t票
     */
    void addTicket(Ticket t);

    /**
     * 根据用户id获取t票信息
     * @param uid
     * @return
     */
    Ticket getTicket(int uid);

    /**
     * 根据t票名称获取t票信息
     * @param t
     * @return
     */
    Ticket getTicket(String t);

    /**
     * 根据t票id删除t票
     * @param tid
     */
    void deleteTicket(int tid);

    /**
     * 根据t票名称删除t票
     * @param t
     */
    void deleteTicket(String t);
}
