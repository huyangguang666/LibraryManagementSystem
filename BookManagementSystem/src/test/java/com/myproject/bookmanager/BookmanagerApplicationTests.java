package com.myproject.bookmanager;

import com.myproject.bookmanager.model.Ticket;
import com.myproject.bookmanager.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BookmanagerApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void addUser() {
        User user = new User();
        user.setName("dlfj");
        user.setEmail("glhjghj");
        user.setPassword("123456");
        System.out.println(user.toString());
    }

    @Test
    void addTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicket("ticket");
        ticket.setUserId(3);
        ticket.setExpiredAt(new Date());
        System.out.println(ticket.toString());

    }
}
