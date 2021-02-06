package com.example.demo.web;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.dto.RoomDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Room;
import com.example.demo.core.entity.RoomId;
import com.example.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")
    public RoomDTO getOne(@PathVariable(name = "id") long id) {
        return roomService.findById(new RoomId(id));
    }

    @PostMapping
    public String test() {
        roomService.test();
        return "d";
    }

}
