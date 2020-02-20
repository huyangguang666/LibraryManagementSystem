package com.myproject.bookmanager.service;

import com.myproject.bookmanager.model.Book;

import java.util.List;

public interface BookService {

    /**
     * 获取所有图书信息
     * @return
     */
    List<Book> getAllBook();

    /**
     * 添加图书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 删除图书
     */
    void deleteBooks(int id);

    /**
     * 恢复图书
     * @param id
     */
    void recoverBooks(int id);
}
