package com.bs.test;

import com.bs.bean.Book;
import com.bs.service.IBookService;
import com.bs.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class IBookServiceTest {
private IBookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "钢铁是怎么炼成的？", "列夫·托尔斯泰",
                69.9, 100, 100, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void deleteBookByName() {
        bookService.deleteBookByName("钢铁是怎么炼成的？");
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(4, "钢铁是怎么炼成的？", "列夫·托尔斯泰",
                69.9, 100, 100, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(4));
    }

    @Test
    public void queryBookByName() {
        System.out.println(bookService.queryBookByName("西游记"));
    }

    @Test
    public void queryAllBooks() {
        System.out.println(bookService.queryAllBooks());
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, 4));
    }
}