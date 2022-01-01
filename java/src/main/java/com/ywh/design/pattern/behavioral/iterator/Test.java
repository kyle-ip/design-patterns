package com.ywh.design.pattern.behavioral.iterator;

/**
 * 迭代器模式：提供一种方法顺序访问一个集合对象中元素，而且不暴露该对象的内部表示；
 * 访问一个集合对象的内容而无需暴露它的内部表示，且为遍历不同的集合结构提供一个统一的接口；
 * 分离了集合对象的遍历行为（外部代码透明地访问集合）；
 * 类的个数会成对增加（集合类 - 迭代器类）；
 * 应用广泛，但很少需要自己实现。
 * 对比：迭代器模式和访问者模式。
 */
public class Test {

    public static void main(String[] args) {
        Course course1 = new Course("Java电商一期");
        Course course2 = new Course("Java电商二期");
        Course course3 = new Course("Java设计模式精讲");
        Course course4 = new Course("Python课程");
        Course course5 = new Course("算法课程");
        Course course6 = new Course("前端课程");

        CourseAggregate courseAggregate = new CourseAggregateImpl();

        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);
        courseAggregate.addCourse(course4);
        courseAggregate.addCourse(course5);
        courseAggregate.addCourse(course6);

        System.out.println("-----课程列表-----");
        printCourses(courseAggregate);

        courseAggregate.removeCourse(course4);
        courseAggregate.removeCourse(course5);

        System.out.println("-----删除操作之后的课程列表-----");
        printCourses(courseAggregate);

        // JDK 源码中的应用：Iterator
        // Mybatis 源码中的应用：Cursor
    }


    public static void printCourses(CourseAggregate courseAggregate) {
        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (!courseIterator.isLastCourse()) {
            Course course = courseIterator.nextCourse();
            System.out.println(course.getName());
        }
    }


}
