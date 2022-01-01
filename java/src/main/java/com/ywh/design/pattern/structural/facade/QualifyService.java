package com.ywh.design.pattern.structural.facade;

/**
 * 积分校验服务类
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+pointsGift.getName()+" 积分资格通过,库存通过");
        return true;
    }
}
