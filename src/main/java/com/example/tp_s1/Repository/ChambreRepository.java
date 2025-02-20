package com.example.tp_s1.Repository;

import com.example.tp_s1.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tp_s1.Entity.TypeChambre;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
