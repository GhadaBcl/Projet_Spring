package com.example.tp_s1.Control;

import com.example.tp_s1.Entity.Reservation;
import com.example.tp_s1.Entity.Universite;
import com.example.tp_s1.Service.IReservationService;
import com.example.tp_s1.Service.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;

    // http://localhost:8089/tp_s1/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getAllUniversites() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }
    // http://localhost:8089/tp_s1/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveUniversite(@PathVariable("reservation-id") String reId) {
        Reservation reservation = reservationService.retrieveReservation(reId);
        return reservation;
    }

    // http://localhost:8089/tp_s1/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addUniversite(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }
    // http://localhost:8089/tp_s1/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reId) {
        reservationService.removeReservation(reId);
    }
    // http://localhost:8089/tp_s1/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyUniversite(@RequestBody Reservation r) {
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }

}
