package com.example.tp_s1.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc; // Relation ManyToOne avec Bloc

    @OneToMany
    private List<Reservation> reservations; // Relation OneToMany avec Reservation
}
