package com.myproject.bookmanager.controllers;

import com.myproject.bookmanager.model.Book;
import com.myproject.bookmanager.model.Ticket;
import com.myproject.bookmanager.model.User;
import com.myproject.bookmanager.service.BookService;
import com.myproject.bookmanager.service.TicketService;
import com.myproject.bookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Controller
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private UserService userService;

  @Autowired
  private TicketService ticketService;

  /**
   * 图书列表
   * @param model
   * @return
   */
  @GetMapping("/index")
  public String bookList(Model model, @CookieValue String t){
//        User host = hostHolder.getUser();
    //判断t票是否存在，来判断是否已经登录
    User host = null;
    Ticket ticket = ticketService.getTicket(t);
    if(ticket != null){
      host = userService.getUser(ticket.getUserId());
    }
    if(host != null){
      model.addAttribute("host", host);
    }
    loadAllBooksView(model);
    return "book/books";
  }

  @RequestMapping(path = {"/books/add"}, method = {RequestMethod.GET})
  public String addBook() {
    return "book/addbook";
  }


  @RequestMapping(path = {"/books/add/do"}, method = {RequestMethod.POST})
  public String doAddBook(
      @RequestParam("name") String name,
      @RequestParam("author") String author,
      @RequestParam("price") String price
  ) {

    Book book = new Book();
    book.setName(name);
    book.setAuthor(author);
    book.setPrice(price);
    bookService.addBooks(book);

    return "redirect:/index";

  }

  @RequestMapping(path = {"/books/{bookId:[0-9]+}/delete"}, method = {RequestMethod.GET})
  public String deleteBook(
      @PathVariable("bookId") int bookId
  ) {

    bookService.deleteBooks(bookId);
    return "redirect:/index";

  }

  @RequestMapping(path = {"/books/{bookId:[0-9]+}/recover"}, method = {RequestMethod.GET})
  public String recoverBook(
      @PathVariable("bookId") int bookId
  ) {

    bookService.recoverBooks(bookId);
    return "redirect:/index";

  }

  /**
   * 为model加载所有的book
   */
  private void loadAllBooksView(Model model) {
    model.addAttribute("books", bookService.getAllBooks());
  }

}
