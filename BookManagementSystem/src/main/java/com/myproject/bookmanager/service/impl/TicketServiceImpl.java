package com.myproject.bookmanager.service.impl;

import com.myproject.bookmanager.dao.TicketDao;
import com.myproject.bookmanager.model.Ticket;
import com.myproject.bookmanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;


    @Override
    public void addTicket(Ticket t) {
        ticketDao.addTicket(t);
    }

    @Override
    public Ticket getTicket(int uid) {
        return ticketDao.selectByUserId(uid);
    }

    @Override
    public Ticket getTicket(String t) {
        return ticketDao.selectByTicket(t);
    }

    @Override
    public void deleteTicket(int tid) {
        ticketDao.deleteTicketById(tid);
    }

    @Override
    public void deleteTicket(String t) {
        ticketDao.deleteTicket(t);
    }
}
