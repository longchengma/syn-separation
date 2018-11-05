package com.home.alibaba.druid;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * Created by li.ma on 2018/8/22.
 */
public class DruidDataSourceDemo {
    public static void main(String[] args) throws SQLException {
        long maxWaitMillis = 100;

        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.getConnectionDirect(maxWaitMillis);

    }
}
