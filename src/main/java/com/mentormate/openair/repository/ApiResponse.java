package com.mentormate.openair.repository;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int statusCode;
    private final String message;
    private final T response;

    public ApiResponse(int statusCode, String message, T response) {
        this.statusCode = statusCode;
        this.message = message;
        this.response = response;
    }

}
