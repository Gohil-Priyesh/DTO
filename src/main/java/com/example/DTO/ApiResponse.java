package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
///  this is a wrapper class for custom api response
public class ApiResponse<T> {

    private int status;
    private T data;
}
