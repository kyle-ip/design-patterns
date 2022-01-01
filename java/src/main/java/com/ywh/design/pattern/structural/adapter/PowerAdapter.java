package com.ywh.design.pattern.structural.adapter;

/**
 * 被适配者类：电源适配器
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        // 变压器...
        int adapterOutput = adapterInput / 44;

        System.out.println("使用 PowerAdapter 输入 AC：" + adapterInput + "V" + "输出 DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}
