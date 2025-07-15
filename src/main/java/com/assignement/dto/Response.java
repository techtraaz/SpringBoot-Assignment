package com.assignement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T>{

    private String responseCode;
    private String responseMsg;
    private T content;



}
