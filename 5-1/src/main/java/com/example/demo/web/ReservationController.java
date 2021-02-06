package com.example.demo.web;

import com.example.demo.core.dto.ReservationDTO;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public ReservationDTO getOne(@PathVariable(name = "id") long id) {
        return reservationService.findById(id);
    }

    //TODO: deleteMapping 이 적합한지...
    @DeleteMapping("/{id}")
    public String cancelReservation(@PathVariable(name = "id") long id) {
        reservationService.cancelReservation(id);

        //TODO: 응답 포맷 확인..
        return "ok";
    }

    /*
    @PostMapping
    public String newReservation() {

        //TODO: 요청 데이터 확인해야 함..
        reservationService.makeReservation(null);
        return "ll";
    }

     */
}
