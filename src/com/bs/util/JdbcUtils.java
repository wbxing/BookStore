package com.bs.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class JdbcUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    static {
        try {
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();

            properties.load(is);

            // 创建数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池里的连接
     *
     * @return 返回一个数据库连接，如果返回 null，说明获取数据库连接失败
     */
    public static Connection getConnection() {

        Connection connection = connectionThreadLocal.get();
        if (connection == null) {
            try {
                // 从数据库连接池中获取连接
                connection = dataSource.getConnection();
                // 保存到 ThreadLocal 对象中
                connectionThreadLocal.set(connection);
                // 设置为手动管理事务
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose() {
        Connection connection = connectionThreadLocal.get();
        if (connection != null) {
            try {
                // 提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定需要 remove
        connectionThreadLocal.remove();
    }

    /**
     * 提交事务并关闭连接
     */
    public static void rollbackAndClose() {
        Connection connection = connectionThreadLocal.get();
        if (connection != null) {
            try {
                // 回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定需要 remove
        connectionThreadLocal.remove();
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 需要关闭的连接
     */
    @Deprecated
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
