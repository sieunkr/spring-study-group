package com.example.demo.core.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class RoomId {

    @Column(name="room_id")
    private long id;

    private RoomId() {
    }

    public RoomId(long id) {
        this.id = id;
    }
}