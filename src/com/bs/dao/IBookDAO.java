package com.bs.dao;

import com.bs.bean.Book;
import com.bs.bean.Page;

import java.util.List;

public interface IBookDAO {
    /**
     * 增加图书
     *
     * @param book 需要增加的图书
     * @return 返回影响行数
     */
    int addBook(Book book);

    /**
     * 通过图书 id 删除图书
     *
     * @param id 要删除图书的 id
     * @return 返回删除的行数
     */
    int deleteBookById(int id);

    /**
     * 通过图书名删除图书
     *
     * @param name 要删除的图书名
     * @return 返回删除的行数
     */
    int deleteBookByName(String name);

    /**
     * 更改图书信息，必须提供图书 id，否则更新失败
     *
     * @param book 需要更改的信息
     * @return 返回更新的行数
     */
    int updateBook(Book book);

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
     * 分页查询
     *
     * @param pageNo   起始索引
     * @param pageSize 每页数目
     * @return 返回分页查询结果
     */
    Page<Book> queryPage(int pageNo, int pageSize);

    /**
     * 每一分页数据
     *
     * @param begin    开始索引
     * @param pageSize 每页数目
     * @return 返回查询结果
     */
    List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 查询数据表总数据量
     *
     * @return 返回查询得到的条目数
     */
    Integer queryAllBooksCount();

    /**
     * 按照制定价格区间查询数据
     *
     * @param pageNo   开始索引
     * @param pageSize 每页条目数
     * @param min      最低价格
     * @param max      最该价格
     * @return 返回分页查询结果
     */
    Page<Book> queryPageByPrice(int pageNo, int pageSize, int min, int max);

    /**
     * 按照指定价格查询数据
     *
     * @param min 最低价格
     * @param max 最高价格
     * @return 返回符合条件的数据量
     */
    int queryBooksCountByPrice(int min, int max);

    /**
     * 按照指定价格查询数据
     *
     * @param begin    开始索引
     * @param pageSize 每页数目
     * @return 返回查询结果集
     */
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
