package com.ywh.design.pattern.creational.builder.v2;

import com.ywh.design.pattern.creational.builder.CourseBuilder;

/**
 * 课程类
 */
public class Course {

    private String courseName;

    private String coursePPT;

    private String courseVideo;

    private String courseArticle;

    private String courseQA;

    /**
     * 3. 建造者构造器
     *
     * @param courseBuilder 建造者对象
     */
    public Course(CourseBuilder courseBuilder) {
        this.courseName = courseBuilder.courseName;
        this.coursePPT = courseBuilder.coursePPT;
        this.courseVideo = courseBuilder.courseVideo;
        this.courseArticle = courseBuilder.courseArticle;
        this.courseQA = courseBuilder.courseQA;
    }

    @Override
    public String toString() {
        return "Course{" +
            "courseName='" + courseName + '\'' +
            ", coursePPT='" + coursePPT + '\'' +
            ", courseVideo='" + courseVideo + '\'' +
            ", courseArticle='" + courseArticle + '\'' +
            ", courseQA='" + courseQA + '\'' +
            '}';
    }

    /**
     * 1. 建造者静态内部类
     */
    public static class CourseBuilder {

        private String courseName;

        private String coursePPT;

        private String courseVideo;

        private String courseArticle;

        private String courseQA;

        /**
         * 2. 建造者参数设值方法
         *
         * @param courseName 课程名称
         * @return 建造者对象
         */
        public CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCoursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder buildCourseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        public CourseBuilder buildCourseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        /**
         * 4. 建造对象方法
         *
         * @return 课程对象
         */
        public Course build() {
            return new Course(this);
        }


    }
}
