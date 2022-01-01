package com.ywh.design.principle.demeter;

/**
 * 老板类
 * <p>
 * Created by ywh
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }

}
