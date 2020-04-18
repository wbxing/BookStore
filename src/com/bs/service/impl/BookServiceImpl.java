package com.bs.service.impl;

import com.bs.bean.Book;
import com.bs.bean.Page;
import com.bs.dao.IBookDAO;
import com.bs.dao.impl.BookDAOImpl;
import com.bs.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void deleteBookByName(String name) {
        bookDAO.deleteBookByName(name);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBookByName(String name) {
        return bookDAO.queryBookByName(name);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookDAO.queryAllBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int PageSize) {
        return bookDAO.queryPage(pageNo, PageSize);
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int PageSize, int min, int max) {
        return bookDAO.queryPageByPrice(pageNo, PageSize, min, max);
    }
}
