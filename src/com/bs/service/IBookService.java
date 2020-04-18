package com.bs.service;

import com.bs.bean.Book;
import com.bs.bean.Page;

import java.util.List;

public interface IBookService {
    /**
     * 增加图书
     *
     * @param book 需要增加的图书
     */
    void addBook(Book book);

    /**
     * 通过图书 id 删除图书
     *
     * @param id 要删除图书的 id
     */
    void deleteBookById(int id);

    /**
     * 通过图书名删除图书
     *
     * @param name 要删除的图书名
     */
    void deleteBookByName(String name);

    /**
     * 更改图书信息，必须提供图书 id，否则更新失败
     *
     * @param book 需要更改的信息
     */
    void updateBook(Book book);

    /**
     * 通过 id 查询图书
     *
     * @param id 需要查询的图书 id
     * @return 返回查询到的图书，查不到返回 null
     */
    Book queryBookById(int id);

    /**
     * 通过图书名查询图书
     *
     * @param name 需要查询的图书名
     * @return 以 list 数组形式返回查询结果，查不到 null
     */
    List<Book> queryBookByName(String name);

    /**
     * 查询所有图书信息
     *
     * @return 以 list 数组形式返回查询结果，查不到 null
     */
    List<Book> queryAllBooks();

    /**
     * 以分页形式返回查询数据
     * @param pageNo 开始索引
     * @param PageSize 每页数目
     * @return 返回分页查询结果
     */
    Page<Book> page(int pageNo, int PageSize);

    /**
     * 以分页形式返回符合查询价格区间的数据
     * @param pageNo 开始索引
     * @param PageSize 每页条目
     * @param min 最低价格
     * @param max 最高价格
     * @return 返回分页查询结果
     */
    Page<Book> pageByPrice(int pageNo, int PageSize, int min, int max);
}
