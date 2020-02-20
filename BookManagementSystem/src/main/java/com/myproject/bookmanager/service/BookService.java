package com.myproject.bookmanager.service;


import com.myproject.bookmanager.dao.BookDAO;
import com.myproject.bookmanager.model.Book;
import com.myproject.bookmanager.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Service
public class BookService {

  @Autowired
  private BookDAO bookDAO;

  public List<Book> getAllBooks() {
    return bookDAO.selectAll();
  }

  public int addBooks(Book book) {
    return bookDAO.addBook(book);
  }

  public void deleteBooks(int id) {
    bookDAO.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
  }

  public void recoverBooks(int id) {
    bookDAO.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
  }
}
