package com.ywh.design.principle.liskovsubstitution.methodinput;

import java.util.HashMap;

/**
 * Created by ywh
 */
public class Test {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
