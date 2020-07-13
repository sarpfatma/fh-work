package com.maya.homework.models;

import java.util.Date;

public class TransactionMerchantModel {
    String referenceNo = null;
    int merchantId;
    String status = null;
    String channel = null;
    String customData = null;
    String chainId = null;
    int agentInfoId;
    String operation = null;
    int fxTransactionId;
    Date updated_at = null;
    Date created_at = null;
    int id;
    int acquirerTransactionId;
    String code = null;
    String message = null;
    String transactionId = null;
    String agent = null;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public int getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(int agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getFxTransactionId() {
        return fxTransactionId;
    }

    public void setFxTransactionId(int fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcquirerTransactionId() {
        return acquirerTransactionId;
    }

    public void setAcquirerTransactionId(int acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
