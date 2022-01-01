package com.ywh.design.principle.compositionaggregation;

/**
 * Created by ywh
 */
public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new PostgreSQLConnection());
        productDao.addProduct();
    }
}
