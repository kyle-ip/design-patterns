package com.ywh.design.principle.compositionaggregation;

/**
 * Created by ywh
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
