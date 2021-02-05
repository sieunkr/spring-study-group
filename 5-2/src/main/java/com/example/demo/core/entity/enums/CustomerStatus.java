package com.example.demo.core.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CustomerStatus {

    NORMAL("일반계정"),
    INACTIVE("휴면계정");

    private String description;

    CustomerStatus(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name();
    }

}
