package com.example.demo.core.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HOTEL")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 15, message = "")
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "name")
    private String name;

    public String getFullName() {
        return this.city + " " + this.name;
    }
}
