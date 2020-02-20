package com.myproject.bookmanager.service;


import com.myproject.bookmanager.dao.UserDAO;
import com.myproject.bookmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Service
public class UserService {

  @Autowired
  private UserDAO userDAO;

  public int addUser(User user){
    return userDAO.addUser(user);
  }

  public User getUser(String email) {
    return userDAO.selectByEmail(email);
  }

  public User getUser(int uid) {
    return userDAO.selectById(uid);
  }
}
