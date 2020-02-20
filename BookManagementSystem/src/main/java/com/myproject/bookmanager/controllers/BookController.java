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
        loadAllBookView(model);
        return "book/books";
    }

    @GetMapping("/books/add")
    public String addBook(){
        return "book/addbook";
    }

    @PostMapping("/books/add/do")
    public String doAddBook(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("price") String price){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBook(book);
        return "redirect:/index";
    }

    @GetMapping(path = "/books/{bookId:[0-9]+}/delete")
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBooks(bookId);
        return "redirect:/index";
    }

    @GetMapping(path = "/books/{bookId:[0-9]+}/recover")
    public String recoverBook(@PathVariable("bookId") int bookId){
        bookService.recoverBooks(bookId);
        return "redirect:/index";
    }

    /**
     * 为model加载所有图书
     * @param model
     */
    private void loadAllBookView(Model model){
        model.addAttribute("books", bookService.getAllBook());
    }
}
