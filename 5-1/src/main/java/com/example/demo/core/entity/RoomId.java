package com.example.demo.core.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Embeddable
public class RoomId implements Serializable {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private RoomId() {
    }

    public RoomId(long id) {
        this.id = id;
    }
}