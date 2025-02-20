package com.example.tp_s1.Control;

import com.example.tp_s1.Entity.Bloc;
import com.example.tp_s1.Entity.Etudiant;
import com.example.tp_s1.Service.IBlocService;
import com.example.tp_s1.Service.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;

    // http://localhost:8089/tp_s1/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    // http://localhost:8089/tp_s1/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(etId);
        return etudiant;
    }

    // http://localhost:8089/tp_s1/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }
    // http://localhost:8089/tp_s1/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etId) {
        etudiantService.removeEtudiant(etId);
    }
    // http://localhost:8089/tp_s1/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }

}
