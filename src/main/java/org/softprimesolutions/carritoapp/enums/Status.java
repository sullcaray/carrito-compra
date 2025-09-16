package org.softprimesolutions.carritoapp.enums;

import lombok.Getter;

@Getter
public enum Status {
    INACTIVE("0", "Inactive"),
    ACTIVE("1", "Active"),
    DELETED("2", "Deleted");

    private final String code;
    private final String description;

    Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Status fromCode(String code) {
        for (Status status : Status.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

}
