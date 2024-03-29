package com.ywh.design.pattern.structural.proxy.db;

/**
 * 数据源上下文类
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

    public static void setDBType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDBType() {
        return (String) CONTEXT_HOLDER.get();
    }

    public static void clearDBType() {
        CONTEXT_HOLDER.remove();
    }


}
