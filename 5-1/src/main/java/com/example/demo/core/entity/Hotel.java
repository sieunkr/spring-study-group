package com.example.demo.core.entity;

import com.example.demo.core.entity.constant.ColumnLength;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HOTEL")
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "city", length = ColumnLength.VARCHAR_NAME)
    private String city;

    @NotNull
    @Column(name = "name", length = ColumnLength.VARCHAR_NAME)
    private String name;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
    //@OneToMany
    private List<Room> roomList = new ArrayList<>();
}
