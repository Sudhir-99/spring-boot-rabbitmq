package com.sudhir.mq.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutputResponseDTO {

    private boolean status;
    private Object data;
    private String message;
    private String statusCode;
}