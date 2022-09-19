package com.persist.postventa.enums;

public enum ApartmentStatusEnum {
    PENDING("pending"), DELIVERED("delivered");

    ApartmentStatusEnum(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }
}
