package com.example.demo.core.entity;

import com.example.demo.core.entity.constant.ColumnLength;
import com.example.demo.core.entity.enums.CustomerStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "CUSTOMER")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = ColumnLength.VARCHAR_NAME)
    private String firstName;

    @Column(name = "last_name", length = ColumnLength.VARCHAR_NAME)
    private String lastName;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @Transient
    @JsonIgnore
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
