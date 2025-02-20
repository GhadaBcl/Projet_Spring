package com.example.tp_s1.Repository;

import com.example.tp_s1.Entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
