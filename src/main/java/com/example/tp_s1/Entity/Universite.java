package com.example.tp_s1.Entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne(mappedBy = "universite", cascade = CascadeType.ALL)
    private Foyer foyer; // Relation OneToOne avec Foyer
}
