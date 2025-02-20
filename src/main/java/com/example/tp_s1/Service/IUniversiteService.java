package com.example.tp_s1.Service;

import com.example.tp_s1.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long idUniversite);
    public Universite modifyUniversite(Universite universite);
}
