package com.javastart.bank.dto;


public class TransferRequestDTO {
    private Long senderId;

    private Long recipientId;

    private int transfer;

    public TransferRequestDTO(Long senderId, Long recipientId, int transfer) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transfer = transfer;
    }

    public TransferRequestDTO() {
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

    public int getTransfer() {
        return transfer;
    }

    public void setTransfer(int transfer) {
        this.transfer = transfer;
    }

}
