package com.ywh.design.pattern.structural.composite;

import org.apache.ibatis.scripting.xmltags.SqlNode;

/**
 * 组合模式：将对象组合成树形结构表示“部分 - 整体”的层次结构，使客户端对单个对象和组合对象保持一致的方式处理；
 * 适用于希望客户端忽略组合对象与单个对象的差异、或处理一个树形结构（node - leaf）时；
 * 清楚地定义分层次的复杂对象，表示对象的全部或部分层次；
 * 客户端忽略层次的差异，方便对整个层次结构进行控制，简化客户端代码；
 * 增加含有子节点的节点，不需要对现有代码做任何修改，符合开闭原则；
 * 使设计变得更抽象（对象声明统一为抽象父类或统一的接口实现），当需要限制类型时会比较复杂；
 *
 * 对比：组合模式和访问者模式。
 */
public class Test {
    public static void main(String[] args) {

        // 课程、课程目录都继承自目录组件类，视为同一类对象，可以执行类似的操作
        // 操作的区别是课程目录执行打印方法时会打印其下所有课程的名称
        // 对于两种类型的对象，都利用多态性把对象声明为 CourseComponent 类型，调用方法 print 被统一（多层次时需要递归）

        // 课程
        CourseComponent linuxCourse = new Course("Linux课程", 11);
        CourseComponent windowsCourse = new Course("Windows课程", 11);

        // 课程目录及其下课程
        CourseComponent javaCourseCatalog = new CourseCourse("Java课程目录", 2);
        CourseComponent mmallCourse1 = new Course("Java电商一期", 55);
        CourseComponent mmallCourse2 = new Course("Java电商二期", 66);
        CourseComponent designPattern = new Course("Java设计模式", 77);

        javaCourseCatalog.add(mmallCourse1);
        javaCourseCatalog.add(mmallCourse2);
        javaCourseCatalog.add(designPattern);

        // 课程主目录
        CourseComponent imoocMainCourseCatalog = new CourseCourse("慕课网课程主目录", 1);
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();

        // Awt 源码中的应用：java.awt.Component，Container（add）
        // JDK 源码中的应用：HashMap（putAll）、ArrayList（addAll）
        // Mybatis 源码中的应用：SqlNode（TrimSqlNode、WhereSqlNode）

    }
}
