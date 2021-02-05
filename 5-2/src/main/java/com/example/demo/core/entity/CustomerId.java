package com.example.demo.core.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class CustomerId {

    @Column(name="customer_id")
    private long id;

    private CustomerId() {
    }

    public CustomerId(long id) {
        this.id = id;
    }
}
