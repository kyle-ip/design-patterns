package com.ywh.design.pattern.structural.facade;

/**
 * 礼物兑换服务类
 */
public class GiftExchangeService {

    private QualifyService qualifyService = new QualifyService();

    private PointsPaymentService pointsPaymentService = new PointsPaymentService();

    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointsGift pointsGift) {

        // 资格校验通过且如果支付积分成功
        if (qualifyService.isAvailable(pointsGift) && pointsPaymentService.pay(pointsGift)) {
            String shippingOrderNo = shippingService.shipGift(pointsGift);
            System.out.println("物流系统下单成功，订单号是:" + shippingOrderNo);
        }
    }
}
