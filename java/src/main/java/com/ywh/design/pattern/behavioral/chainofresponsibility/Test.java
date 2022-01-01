package com.ywh.design.pattern.behavioral.chainofresponsibility;

/**
 * 责任链模式（重点）：为请求创建一个接收处理请求对象的链；
 * 当一个请求的处理需要多个对象中的一或多个协作处理；
 * 请求的发送者和接收者（请求的处理）解耦，且责任链可以动态组合；
 * 责任链太长或处理时间过长时可能会影响性能；
 * 对比：责任链模式和状态模式。
 */
public class Test {

    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("设计模式");
        course.setArticle("手记");
        course.setVideo("视频");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);

        // javax 源码中的应用：MockFilterChain，LoggerContextFilter.doFilter
    }

}
