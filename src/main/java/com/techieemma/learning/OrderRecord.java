package com.techieemma.learning;

public record OrderRecord(
        String orderName,
        String orderDescription,
        int orderAmount
) {
    @Override
    public String toString() {
        return "OrderRecord{" +
                "orderName='" + orderName + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
