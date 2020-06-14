package com.example.handler;

public enum PhonebookExceptionCode {
    INVALID_PAYLOAD("INVALID_PAYLOAD");

    private final String code;

    PhonebookExceptionCode(String code) {
        this.code = code;
    }

    public String getExceptionCode() {
        return code;
    }
}
