package com.bs.test;

import com.bs.bean.Book;
import com.bs.dao.IBookDAO;
import com.bs.dao.impl.BookDAOImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IBookDAOTest {
    private IBookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        System.out.println(bookDAO.addBook(new Book(null, "钢铁是怎么炼成的？", "列夫·托尔斯泰",
                69.9, 100, 100, null)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDAO.deleteBookById(21));
    }

    @Test
    public void deleteBookByName() {
        System.out.println(bookDAO.deleteBookByName("钢铁是怎么炼成的？"));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDAO.updateBook(new Book(14, "水浒传", "施耐庵",
                20.9, 100, 20, null)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(20));
    }

    @Test
    public void queryBookByName() {
        System.out.println(bookDAO.queryBookByName("西游记"));
    }

    @Test
    public void queryAllBooks() {
        System.out.println(bookDAO.queryAllBooks());
    }

    @Test
    public void queryForPageItems() {
        int begin = 0;
        int pageSize = 4;
        System.out.println(bookDAO.queryForPageItems(begin, pageSize));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDAO.queryForPageItemsByPrice(0, 4, 10, 50));
    }

    @Test
    public void queryAllBooksCount() {
        System.out.println(bookDAO.queryAllBooksCount());
    }

    @Test
    public void queryBooksCountByPrice() {
        System.out.println(bookDAO.queryBooksCountByPrice(10, 50));
    }

}