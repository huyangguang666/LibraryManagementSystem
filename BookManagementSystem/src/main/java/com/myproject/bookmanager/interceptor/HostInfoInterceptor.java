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
 * Created by nowcoder on 2018/08/07 下午5:06
 */
@Component
public class HostInfoInterceptor implements HandlerInterceptor {

  @Autowired
  private TicketService ticketService;

  @Autowired
  private UserService userService;

  /**
   * 为注入host信息
   *
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String t = CookieUtils.getCookie("t", request);
    if (!StringUtils.isEmpty(t)) {
      Ticket ticket = ticketService.getTicket(t);
      if (ticket != null && ticket.getExpiredAt().after(new Date())) {
        User host = userService.getUser(ticket.getUserId());
        ConcurrentUtils.setHost(host);
      }
    }
    return true;
  }

}
