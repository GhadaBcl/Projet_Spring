package com.example.tp_s1.Repository;

import com.example.tp_s1.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
