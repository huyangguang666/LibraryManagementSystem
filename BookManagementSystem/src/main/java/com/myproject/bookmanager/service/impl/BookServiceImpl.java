package com.myproject.bookmanager.service.impl;

import com.myproject.bookmanager.dao.BookDao;
import com.myproject.bookmanager.model.Book;
import com.myproject.bookmanager.model.enums.BookStatusEnum;
import com.myproject.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBook() {
        return bookDao.selectAll();
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void deleteBooks(int id) {
        bookDao.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
    }

    @Override
    public void recoverBooks(int id) {
        bookDao.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
    }
}
