package com.bs.dao.impl;

import com.bs.bean.Book;
import com.bs.bean.Page;
import com.bs.dao.BaseDAO;
import com.bs.dao.IBookDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO implements IBookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(int id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }

    @Override
    public int deleteBookByName(String name) {
        String sql = "delete from t_book where name=?";
        return update(sql, name);
    }

    @Override
    public int updateBook(Book book) {
//        if (book.getId() == null) {
//            return 0;
//        }
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(int id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBookByName(String name) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where name=?";
        return queryForList(Book.class, sql, name);
    }

    @Override
    public List<Book> queryAllBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Page<Book> queryPage(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        int pageTotalCount = queryAllBooksCount();
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);

        // pageNo 需要执行边界检查
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        int begin = (pageNo - 1) * pageSize;
        List<Book> items = queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book limit ?, ?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryAllBooksCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryForSingle(sql);
        return number.intValue();
    }

    @Override
    public Page<Book> queryPageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        int pageTotalCount = queryBooksCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageSize(pageSize);
        page.setPageTotal(pageTotal);

        // pageNo 需要执行边界检查
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        int begin = (pageNo - 1) * pageSize;
        List<Book> items = queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);
        return page;
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath " +
                " from t_book where `price` between ? and ? order by `price` limit ?, ? ";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }

    @Override
    public int queryBooksCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where `price` between ? and ?";
        Number number = (Number) queryForSingle(sql, min, max);
        return number.intValue();
    }
}
