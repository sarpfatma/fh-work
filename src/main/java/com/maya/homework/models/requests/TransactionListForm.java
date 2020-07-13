package com.maya.homework.models.requests;

public class TransactionListForm {
    public String fromDate;
    public String toDate;
    public String status;
    public String operation;
    public int merchantId;
    public int acquirerId;
    public String paymentMethod;
    public String errorCode;
    public int page;
}
