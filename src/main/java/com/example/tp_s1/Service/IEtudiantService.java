package com.example.tp_s1.Service;

import com.example.tp_s1.Entity.Chambre;
import com.example.tp_s1.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long idEtudiant);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long idEtudiant);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
