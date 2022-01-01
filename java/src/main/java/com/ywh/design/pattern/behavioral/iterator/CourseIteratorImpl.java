package com.ywh.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * 课程迭代器类（在内部维护一个列表和索引，并实现取下一个元素和判断最后元素的方法）
 */
public class CourseIteratorImpl implements CourseIterator {

    private List courseList;

    private int position;

    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        System.out.println("返回课程,位置是: " + position);
        course = (Course) courseList.get(position);
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        return position >= courseList.size();
    }
}
