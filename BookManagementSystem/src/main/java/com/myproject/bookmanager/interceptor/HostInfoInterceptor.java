package com.myproject.bookmanager.interceptor;

import com.myproject.bookmanager.model.Ticket;
import com.myproject.bookmanager.model.User;
import com.myproject.bookmanager.service.TicketService;
import com.myproject.bookmanager.service.UserService;
import com.myproject.bookmanager.utils.ConcurrentUtils;
import com.myproject.bookmanager.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 这个拦截器试图通过请求中的Cookie来寻找t票，
 * 一旦寻找到t票并成功的从数据库中找到了对应的用户，
 * 就直接放入ConcurrentUtils中(ConcurrentUtils 和 HostHolder是一回事）。
 */
@Component
public class HostInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    /**
     * 注入host信息
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String t = CookieUtils.getCookie("t", request);
        if(!StringUtils.isEmpty(t)){
            Ticket ticket = ticketService.getTicket(t);
            if(ticket != null && ticket.getExpiredAt().after(new Date())){
                User host = userService.getUser(ticket.getUserId());
                ConcurrentUtils.setHost(host);
            }
        }
        return true;
    }
}
