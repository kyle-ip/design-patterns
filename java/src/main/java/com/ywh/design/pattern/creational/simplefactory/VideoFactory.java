package com.ywh.design.pattern.creational.simplefactory;

/**
 * 视频工厂类
 */
public class VideoFactory {

    /**
     * 指定课程类型、返回课程视频对象
     *
     * @param c
     * @return
     */
    public Video getVideo(Class c) {
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }

    /**
     * 指定课程名称、返回课程视频对象
     *
     * @param type
     * @return
     */
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        }
        return null;
    }

}
