package com.example.tp_s1.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;


    @ManyToOne
    private Chambre chambre; // Relation ManyToOne avec Chambre

    @ManyToMany
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private List<Etudiant> etudiants;
}
