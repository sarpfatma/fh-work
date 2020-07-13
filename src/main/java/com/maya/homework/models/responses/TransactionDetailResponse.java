package com.maya.homework.models.responses;

import com.maya.homework.models.CustomerInfoModel;
import com.maya.homework.models.FxModel;
import com.maya.homework.models.MerchantModel;
import com.maya.homework.models.TransactionModel;

public class TransactionDetailResponse {
    FxModel fx;
    CustomerInfoModel customerInfo;
    MerchantModel merchant;
    TransactionModel transaction;

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

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }
}
