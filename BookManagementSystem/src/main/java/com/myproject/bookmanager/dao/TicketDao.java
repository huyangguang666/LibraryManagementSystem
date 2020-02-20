package com.myproject.bookmanager.dao;

import com.myproject.bookmanager.model.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TicketDao {

    /**
     * 添加t票
     * @param ticket
     * @return
     */
    @Insert("insert into ticket(user_id,ticket,expired_at) values(#{userId},#{ticket},#{expiredAt})")
    int addTicket(Ticket ticket);

    /**
     * 通过用户id查询查询t票信息
     * @param id
     * @return
     */
    @Select("select * from ticket where id=#{id}")
    Ticket selectByUserId(Integer id);

    /**
     * 通过门票查询t票信息
     * @param t
     * @return
     */
    @Select("select * from ticket where ticket=#{t}")
    Ticket selectByTicket(String  t);

    /**
     * 通过门票id查询t票信息
     * @param tid
     */
    @Delete("delete from ticket where id=#{tid}")
    void deleteTicketById(Integer tid);

    /**
     * 删除t票
     * @param t
     */
    @Delete("delete from ticket where ticket=#{t}")
    void deleteTicket(String t);
}
