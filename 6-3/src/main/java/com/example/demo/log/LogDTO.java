package com.example.demo.log;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogDTO {
    private String name;
    private Integer price;
}