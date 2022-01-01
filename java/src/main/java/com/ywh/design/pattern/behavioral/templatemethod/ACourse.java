package com.ywh.design.pattern.behavioral.templatemethod;

/**
 * 课程抽象类（模板）
 */
public abstract class ACourse {

    /**
     * 模板方法：不可被子类覆盖，描述制作课程的流程顺序，所有子类共有
     */
    protected final void makeCourse() {
        System.out.println("制作PPT");
        System.out.println("制作视频");
        if (needWriteArticle()) {
            System.out.println("编写手记");
        }
        this.packageCourse();
    }

    /**
     * 钩子方法：提供默认值，子类可选实现，描述该课程是否有提供手记
     */
    protected boolean needWriteArticle() {
        return false;
    }

    /**
     * 抽象方法：完全交由子类实现（必须），描述课程附件
     */
    abstract void packageCourse();


}
