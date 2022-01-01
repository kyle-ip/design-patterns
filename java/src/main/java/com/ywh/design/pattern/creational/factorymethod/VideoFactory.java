package com.ywh.design.pattern.creational.factorymethod;

/**
 * 抽象工厂类
 */
public abstract class VideoFactory {

    public abstract Video getVideo();

//    public Video getVideo(Class c){
//        Video video = null;
//        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
//
//
//    public Video getVideo(String type){
//        if("java".equalsIgnoreCase(type)){
//            return new JavaVideo();
//        }
//        return null;
//    }

}
