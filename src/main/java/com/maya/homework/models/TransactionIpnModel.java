package com.maya.homework.models;

public class TransactionIpnModel {
    Boolean received;

    public TransactionIpnModel(Boolean received) {
        this.received = received;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}
