package com.example.demo.core.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoomType {

    STANDARD("스탠다드"),
    DELUXE("디럭스");

    private String description;

    RoomType(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name();
    }

}
