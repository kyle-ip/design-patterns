package com.ywh.design.pattern.creational.builder;

/**
 * 建造者模式（重点）：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * 用户只需要指定需要建造的类型就可以得到他们，建造过程及细节不需要知道；
 * 适用于当对象有非常复杂的内部结构（创建需要多个步骤），需要把复杂的创建和使用分离；
 * 封装性好，创建和使用分离；
 * 扩展性好，建造类之间独立，一定程度上解耦；
 * 产生多余的 Builder 对象，而且当产品内部发生变化，建造者都需要修改，成本较大。
 */
public class Test {
    
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();

        // 给指挥者指定一名建造者，建造者根据指挥者提交的课程资料创建课程
        // 建造者封装在指挥者内，课程的建造细节封装在建造者内
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse(
            "Java设计模式精讲",
            "Java设计模式精讲PPT",
            "Java设计模式精讲视频",
            "Java设计模式精讲手记",
            "Java设计模式精讲问答"
        );
        System.out.println(course);

    }
}
