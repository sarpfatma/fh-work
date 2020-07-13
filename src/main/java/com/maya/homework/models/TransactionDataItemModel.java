package com.maya.homework.models;

public class TransactionDataItemModel {
    FxModel fx;
    CustomerInfoModel customerInfo;
    MerchantModel merchant;
    TransactionIpnModel ipn;
    TransactionModel transaction;
    AcquirerModel acquirer;
    Boolean refundable;

    public FxModel getFx() {
        return fx;
    }

    public void setFx(FxModel fx) {
        this.fx = fx;
    }

    public CustomerInfoModel getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfoModel customerInfo) {
        this.customerInfo = customerInfo;
    }

    public MerchantModel getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantModel merchant) {
        this.merchant = merchant;
    }

    public TransactionIpnModel getIpn() {
        return ipn;
    }

    public void setIpn(TransactionIpnModel ipn) {
        this.ipn = ipn;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }

    public AcquirerModel getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(AcquirerModel acquirer) {
        this.acquirer = acquirer;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }
}
