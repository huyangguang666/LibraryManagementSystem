package com.myproject.bookmanager.dao;

import com.myproject.bookmanager.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Mapper
public interface BookDAO {

  String table_name = " book ";
  String insert_field = " name, author, price ";
  String select_field = " id, status, " + insert_field;

  @Select({"select", select_field, "from", table_name})
  List<Book> selectAll();

  @Insert({"insert into", table_name, "(", insert_field,
      ") values (#{name},#{author},#{price})"})
  int addBook(Book book);

  @Update({"update ", table_name, " set status=#{status} where id=#{id}"})
  void updateBookStatus(@Param("id") int id, @Param("status") int status);
}
