package com.hdfclife.model;

public class Claim {
    private String claimId;
    private int amount;
    private String policyNumber;
    private String customerName;
    private Urgency urgency;

    public Claim(String claimId, int amount, String policyNumber, String customerName, Urgency urgency) {
        this.claimId = claimId;
        this.amount = amount;
        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.urgency = urgency;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId='" + claimId + '\'' +
                ", amount=" + amount +
                ", policyNumber='" + policyNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", Urgency='" + urgency + '\'' +
                '}';
    }
}
