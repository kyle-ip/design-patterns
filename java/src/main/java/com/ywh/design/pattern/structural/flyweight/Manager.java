package com.ywh.design.pattern.structural.flyweight;

/**
 * 部门经理类
 */
public class Manager implements Employee {
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    // 内部状态，固定在对象内部
    private String title = "部门经理";

    // 外部状态：在外部声明，依赖于外部传入参数
    private String department;

    private String reportContent;

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Manager(String department) {
        this.department = department;
    }


}
