package com.ywh.design.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式：封装作用于某数据结构（List、Map、Set）中的各元素的操作；
 * 可以在不改变各元素的类的前提下定义作用于这些元素的操作；
 * 当一个数据结构中包含很多类型对象时，或数据结构有与其数据操作分离的时候适用；
 * 增加新的数据操作很容易，只需要新增一个访问者；
 * 增加新的数据结构很困难，且具体元素的变更（增删元素中的元素）很困难；
 * 对比：访问者模式和迭代器模式；
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Test {

    public static void main(String[] args) {

        Visitor visitor = new Visitor();
        List<Course> courseList = new ArrayList<Course>();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("Spring MVC");
        courseList.add(freeCourse);

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("设计模式");
        codingCourse.setPrice(399);
        courseList.add(codingCourse);

        for (Course course: courseList) {
            course.accept(visitor);
        }

        // JDK 源码中的应用：FileVisitor
        // Spring 源码中的应用：BeanDefinitionVisitor.visitBeanDefinition
    }

}
