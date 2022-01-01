package com.ywh.design.pattern.creational.prototype.clone;

import com.ywh.design.pattern.creational.singleton.bak.HungrySingleton;

import java.lang.reflect.Method;

/**
 * @author ywh
 * @since 2018/12/26
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception {

        // 使用原型模式克隆会破环单例模式对象（反射获取克隆方法、再获取对象）
        // 解决方法是单例类不去实现 Cloneable 接口，或重写 clone 方法直接返回原单例对象（而非 super.clone()）
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) method.invoke(hungrySingleton);

        System.out.println(hungrySingleton);
        System.out.println(cloneHungrySingleton);
    }
}
