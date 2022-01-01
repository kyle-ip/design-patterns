package com.ywh.design.pattern.creational.singleton.bak;

/**
 * Created by ywh
 */
public enum EnumInstance {
    INSTANCE{
        protected  void printTest(){
            System.out.println("ywh Print Test");
        }
    };
    protected abstract void printTest();
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumInstance getInstance(){
        return INSTANCE;
    }

}
