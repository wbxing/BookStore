package com.bs.test;

import com.bs.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JdbcUtilsTest {

    @Test
    public void getConnection() {
        System.out.println(JdbcUtils.getConnection());
    }

    @Test
    public void close() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        JdbcUtils.close(conn);
    }
}