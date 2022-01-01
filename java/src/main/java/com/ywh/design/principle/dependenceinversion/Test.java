package com.ywh.design.principle.dependenceinversion;

/**
 * 依赖倒置原则
 *
 * Created by ywh
 */
public class Test {


    public static void main(String[] args) {

//        // v1
//        Ywh ywh = new Ywh();
//        ywh.studyJavaCourse();
//        ywh.studyPythonCourse();
//
//        // v2
//        Ywh ywh = new Ywh();
//        ywh.studyImoocCourse(new JavaCourse());
//        ywh.studyImoocCourse(new FECourse());
//        ywh.studyImoocCourse(new PythonCourse());
//
//        // v3
//        Ywh ywh = new Ywh(new JavaCourse());
//        ywh.studyImoocCourse();

        // v4
        Ywh ywh = new Ywh();
        ywh.setiCourse(new JavaCourse());
        ywh.studyImoocCourse();

        ywh.setiCourse(new FECourse());
        ywh.studyImoocCourse();

    }


}
