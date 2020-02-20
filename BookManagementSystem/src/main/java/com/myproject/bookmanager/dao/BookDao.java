package com.myproject.bookmanager.dao;

import com.myproject.bookmanager.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    /**
     * 查询所有图书
     * @return
     */
    @Select("select * from book")
    List<Book> selectAll();

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Insert("insert into book(name,author,price) values(#{name},#{author},#{price})")
    int addBook(Book book);

    /**
     * 更新图书状态
     * @param id
     * @param status
     */
    @Update("update book set status=#{status} where id=#{id}")
    void updateBookStatus(@Param("id") int id, @Param("status") int status);
}
