package com.ywh.design.principle.singleresponsibility;

/**
 * Created by ywh
 */
public class Method {
    private void updateUserInfo(String userName, String address) {
        userName = "ywh";
        address = "beijing";
    }

    private void updateUserInfo(String userName, String... properties) {
        userName = "ywh";
//        address = "beijing";
    }

    private void updateUsername(String userName) {
        userName = "ywh";
    }

    private void updateUserAddress(String address) {
        address = "beijing";
    }

    private void updateUserInfo(String userName, String address, boolean bool) {
        if (bool) {
            //todo something1
        } else {
            //todo something2
        }


        userName = "ywh";
        address = "beijing";
    }


}
