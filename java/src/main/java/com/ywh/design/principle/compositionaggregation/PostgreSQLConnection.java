package com.ywh.design.principle.compositionaggregation;

/**
 * Created by ywh
 */
public class PostgreSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "PostgreSQL数据库连接";
    }
}
