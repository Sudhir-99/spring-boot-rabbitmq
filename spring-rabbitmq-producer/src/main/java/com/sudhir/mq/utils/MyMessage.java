package com.sudhir.mq.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyMessage {
    private String messageId;
    private String message;

    @Override
    public String toString() {
        return "{messageId=" + messageId + ", message=" + message + ", messageDate=" + messageDate + "}";
    }

    private Date messageDate;
}