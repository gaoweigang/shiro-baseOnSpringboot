package com.gwg.shiro.demo.spring.autowire.test;

import java.io.Serializable;

/**
 * 分账信息
 */
public class DivideInfo implements Serializable{

    private String fundChannel; //资金渠道

    private String merNo;//资金渠道 在第三方支付公司的 商户号

    private String amount;//分账金额 分

    public DivideInfo(String merNo, String amount) {
        this.merNo = merNo;
        this.amount = amount;
    }

    public String getFundChannel() {
        return fundChannel;
    }

    public void setFundChannel(String fundChannel) {
        this.fundChannel = fundChannel;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
