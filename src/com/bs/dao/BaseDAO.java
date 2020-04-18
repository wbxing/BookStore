package com.bs.dao;

import com.bs.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {
    // 使用 dbUtils 操作数据库
    private final QueryRunner qr = new QueryRunner();

    /**
     * 更新数据库中的数据
     *
     * @param sql  sql 语句
     * @param args SQL语句对应的参数值
     * @return 返回更新的行数，返回 -1 表示更新失败
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return qr.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 数据库查询语句，返回一条查询结果
     *
     * @param type 返回的对象类型
     * @param sql  查询的 sql 语句
     * @param args sql 语句对应的参数值
     * @param <T>  返回类型的泛型
     * @return 返回查询结果，查询失败返回 null
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return qr.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 数据库查询语句，返回多条查询结果
     *
     * @param type 返回的对象类型
     * @param sql  查询的 sql 语句
     * @param args sql 语句对应的参数值
     * @param <T>  返回类型的泛型
     * @return 返回查询结果 list，查询失败返回 null
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return qr.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 数据库查询语句，返回单个值
     *
     * @param sql  查询的 sql 语句
     * @param args sql 语句对应的参数值
     * @return 返回查询结果，查询失败返回 null
     */
    public Object queryForSingle(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return qr.query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
