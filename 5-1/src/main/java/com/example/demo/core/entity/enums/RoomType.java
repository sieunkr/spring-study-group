package com.example.demo.core.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoomType {

    STANDARD("스탠다드", 3),
    DELUXE("디럭스", 5);

    private String description;
    private Integer maxPeople;

    RoomType(String description, Integer maxPeople) {
        this.description = description;
        this.maxPeople = maxPeople;
    }

    public String getName() {
        return this.name();
    }

}
