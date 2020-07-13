package com.maya.homework.models.responses;

import com.maya.homework.models.CustomerInfoModel;
import com.maya.homework.models.FxModel;
import com.maya.homework.models.MerchantModel;
import com.maya.homework.models.TrnModel;

public class TransactionDetailResponse {
    FxModel fx;
    CustomerInfoModel customerInfo;
    MerchantModel merchant;
    TrnModel transaction;

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

    public TrnModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TrnModel transaction) {
        this.transaction = transaction;
    }
}
