package com.javastart.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.StringJoiner;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;

    private Long senderId;

    private Long recipientId;

    private String timeOfTransfer;

    private int transferAmount;

    public Transfer(Long senderId, Long recipientId, String timeOfTransfer, int transferAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.timeOfTransfer = timeOfTransfer;
        this.transferAmount = transferAmount;
    }

    public Transfer() {
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getTimeOfTransfer() {
        return timeOfTransfer;
    }

    public void setTimeOfTransfer(String timeOfTransfer) {
        this.timeOfTransfer = timeOfTransfer;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Transfer.class.getSimpleName() + "[", "]")
                .add("transferId=" + transferId)
                .add("senderId=" + senderId)
                .add("recipientId=" + recipientId)
                .add("timeOfTransfer='" + timeOfTransfer + "'")
                .add("transferAmount=" + transferAmount)
                .toString();
    }
}
